/*
 * Be careful, do not modify this class, it is generated automatically.
 */

package com.softfactory.sigai.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Persistent class for entity stored in table "utilisateur"
 */

@Entity
@Table(name = "utilisateur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UtilisateurEntity extends AbstractCommonEntity<Long> implements Cloneable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utilisateur", nullable = false)
	private Long idUtilisateur;

	@Column(name = "nom", nullable = false, length = 255)
	private String nom;

	@Column(name = "prenom", nullable = false, length = 255)
	private String prenom;

	@Column(name = "telephone", length = 255)
	private String telephone;

	@Column(name = "email", length = 255)
	private String email;

	@Column(name = "cin", length = 255)
	private String cin;

	@Column(name = "username", nullable = false, length = 255)
	private String username;

	@Column(name = "password", nullable = false, length = 255)
	private String password;
	
	@Column(name = "role", nullable = false)
	private String role;

	@OneToMany(mappedBy = "utilisateurEntity", targetEntity = UtilisateurRolesEntity.class, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<UtilisateurRolesEntity> listOfUtilisateurRoles;

	@Override
	public Long getId() {
		return idUtilisateur;
	}


}
