package com.softfactory.sigai.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Persistent class for entity stored in table "garant"
 * 
 * @author : Kourmou omar
 * @see : <kourmou.omar@gmail.com>
 * @creation : 21-11-2020
 * @version : 1.0
 */

@Entity
@RequiredArgsConstructor
@Data
@Table(name = "garant")
public class GarantEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "email")
	private String email;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "rib")
	private String rib;

	@OneToMany(targetEntity = AdresseEntity.class, cascade = CascadeType.ALL, mappedBy = "garant")
	private List<AdresseEntity> adresse;

	@OneToOne
	@JoinColumn(name = "id_type_garant", nullable = false)
	private TypeGarantEntity type_garant;

}
