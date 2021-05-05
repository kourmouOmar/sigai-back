/*
 * Be careful, do not modify this class, it is generated automatically.
 */

package com.softfactory.sigai.entities;

 
import java.util.Date;



import lombok.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "vue"
 */

@Entity
@Table(name="vue")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VueEntity extends AbstractCommonEntity<Long>  implements Cloneable  {

    private static Logger logger = LoggerFactory.getLogger(VueEntity.class);
 
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vue", nullable = false)
    private Long idVue ;

    @Column(name="libelle", length=255)
    private String libelle ;
    @Column(name="description", length=255)
    private String description ;

    @OneToMany(mappedBy="vue", targetEntity=BienEntity.class)
    private List<BienEntity> listOfBien;


     @Override
	 public Long getId() {
		return idVue;
	} 
 
  
   
}
