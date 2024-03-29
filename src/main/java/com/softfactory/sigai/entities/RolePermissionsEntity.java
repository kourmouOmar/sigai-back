/*
 * Be careful, do not modify this class, it is generated automatically.
 */

package com.softfactory.sigai.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Persistent class for entity stored in table "role_permissions"
 */

@Entity
@Table(name = "role_permissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RolePermissionsEntity extends AbstractCommonEntity<Long> implements Cloneable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role_permissions", nullable = false)
	private Long idRolePermissions;

	@ManyToOne
	@JoinColumn(name = "id_role", referencedColumnName = "id_role")
	private RoleEntity role;

	@ManyToOne
	@JoinColumn(name = "id_permission", referencedColumnName = "id_permission")
	private PermissionEntity permission;

	@OneToMany(mappedBy = "rolePermissions", targetEntity = RoleMenusPermissionsEntity.class)
	private List<RoleMenusPermissionsEntity> listOfRoleMenusPermissions;

	@Override
	public Long getId() {
		return idRolePermissions;
	}

}
