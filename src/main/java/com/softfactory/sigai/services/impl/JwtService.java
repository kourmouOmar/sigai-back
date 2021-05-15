package com.softfactory.sigai.services.impl;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.softfactory.sigai.config.TokenProvider;
import com.softfactory.sigai.controllers.dto.JwtResponseDto;
import com.softfactory.sigai.controllers.dto.MenusAuthoritiesDto;
import com.softfactory.sigai.controllers.dto.SigaiUtilisateurDto;
import com.softfactory.sigai.entities.MenuEntity;
import com.softfactory.sigai.entities.RolePermissionsEntity;
import com.softfactory.sigai.entities.UtilisateurEntity;
import com.softfactory.sigai.repository.IRolePermissionsRepository;
import com.softfactory.sigai.repository.IUtilisateurRepository;
import com.softfactory.sigai.services.IJwtService;
import com.softfactory.sigai.util.Functions;

/**
 * Spring serviceImpl "JwtService"
 * 
 * @author : kourmouOmar
 * @creation : 05/12/20
 * @version : 1.0
 */
@Service
public class JwtService implements IJwtService {

	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

	@Autowired
	private IUtilisateurRepository utilisateurRepository;

	@Autowired
	private IRolePermissionsRepository rolePermissionsRepository;

	@Autowired
	private TokenProvider tokenProvider;

	@Override
	public UtilisateurEntity getUserByUsername(String username) {
		UtilisateurEntity userEntity = new UtilisateurEntity();
		try {
			userEntity = utilisateurRepository.findUtilisateurByUsername(username);

		} catch (Exception e) {
			throw e;
		}
		return userEntity;
	}

	@Override
	public MenusAuthoritiesDto getAuthoritiesAndMenus(UtilisateurEntity user) {

		Set<String> authorities = new LinkedHashSet<>();
		Set<String> menus = new LinkedHashSet<>();
		MenusAuthoritiesDto menusAuthoritiesDto = new MenusAuthoritiesDto();
		Set<MenuEntity> menusEntities = new LinkedHashSet<>();

		/*
		 * get permmissions and menus
		 */
		try {
			user.getListOfUtilisateurRoles().forEach(r -> {
				/* get role */
				List<RolePermissionsEntity> rolePermissions = rolePermissionsRepository
						.getRolePermissionByRole(r.getRoleEntity().getIdRole());
				rolePermissions.forEach(rolePer -> {
					authorities.add(rolePer.getPermission().getLibelle());
					rolePer.getListOfRoleMenusPermissions().forEach(v -> {
						if (v.getMenuPermissions().getMenu() != null) {
							menus.add(v.getMenuPermissions().getMenu().getLibelle());
							menusEntities.add(v.getMenuPermissions().getMenu());
						}
					});
				});
			});

		} catch (Exception e) {
			throw e;
		}

		menusAuthoritiesDto.setAuthorities(constructGrantedAuthorities(authorities));
		menusAuthoritiesDto.setMenus(menusEntities);

		return menusAuthoritiesDto;
	}

	@Override
	public SigaiUtilisateurDto constructResponse(UtilisateurEntity user, String username,
			MenusAuthoritiesDto menusAuthoritiesDto) {
		SigaiUtilisateurDto sigaiUtilisateurDto;

		try {
			/* construct full name */
			StringBuilder fullName = new StringBuilder(user.getPrenom()).append(" ").append(user.getNom());

			/* current date for token creation */
			Date now = new Date();

			/* Token generation */
			String token = tokenProvider.createToken(username, menusAuthoritiesDto.getAuthorities(), now);

			/* finally we construct the response */
			JwtResponseDto response = new JwtResponseDto();
			response.setHeader(tokenProvider.getHeader());
			response.setToken(tokenProvider.getPrefix() + token);
			response.setExpires(Functions.formatDate(tokenProvider.getExpirationTime(now), DATE_FORMAT));
			response.setMenus(menusAuthoritiesDto.getMenus());

			sigaiUtilisateurDto = new SigaiUtilisateurDto(username, fullName.toString(), response);

		} catch (Exception e) {
			throw e;
		}

		return sigaiUtilisateurDto;
	}

	@Override
	public Set<GrantedAuthority> constructGrantedAuthorities(Set<String> authorities) {
		Set<GrantedAuthority> grantedAuthorities = new LinkedHashSet<>();
		try {
			if (authorities != null && Boolean.FALSE.equals(authorities.isEmpty())) {
				authorities.forEach(v -> grantedAuthorities.add(new SimpleGrantedAuthority(v)));
			}
		} catch (Exception e) {
			throw e;
		}

		return grantedAuthorities;
	}
}
