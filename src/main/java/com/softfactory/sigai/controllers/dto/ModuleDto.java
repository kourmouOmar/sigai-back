/*
 * Be careful, do not modify this class, it is generated automatically.
 */
package com.softfactory.sigai.controllers.dto;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.softfactory.sigai.entities.ModuleEntity;
import com.softfactory.sigai.util.Functions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ModuleDto implements Serializable {

private static final long serialVersionUID = 1L;

    private Long idModule     ;
    private Boolean active;
    @Size(max=255)
    private String code;
    @Size(max=255)
    private String colorLibelle;
    @Size(max=255)
    private String description;
    @Size(max=255)
    private String iconeActive;
    @Size(max=255)
    private String iconeHover;
    @Size(max=255)
    private String iconeNormale;
    @Size(max=255)
    private String libelle;
    private String activeLib;
	// Relations
    private List<RoleModulesDto> listOfRoleModulesDto;  
    private List<MenuDto> listOfMenuDto;  

	// Relation Enum
	public enum ModuleRelationsEnum {
		listOfRoleModules,
    	listOfMenu; 
	}
   
	/**
     * Convert ModuleEntity -> ModuleDto
     * @return ModuleDto
     */
    public static ModuleDto entityToDto(ModuleEntity entity){
		ModuleDto dto = null;
		if(entity != null){
			String oui ="Oui";
			String non ="Non";
			dto = new ModuleDto();
        	dto.setIdModule(entity.getIdModule());
        	
        	dto.setActiveLib(entity.getActive()==true?oui:non);  
        	dto.setCode(entity.getCode());  
        	dto.setColorLibelle(entity.getColorLibelle());  
        	dto.setDescription(entity.getDescription());  
        	dto.setIconeActive(entity.getIconeActive());  
        	dto.setIconeHover(entity.getIconeHover());  
        	dto.setIconeNormale(entity.getIconeNormale());  
        	dto.setLibelle(entity.getLibelle());  
		}
		return  dto;
    }
	/**
     * Convert ModuleDto -> ModuleEntity
     * @param ModuleDto
     */
    public static ModuleEntity dtoToEntity(ModuleDto dto){
		ModuleEntity entity = null;
		if(dto != null){
			entity = new ModuleEntity();
        	entity.setIdModule(dto.getIdModule()) ;
        	entity.setActive(dto.getActive());   
        	entity.setCode(dto.getCode());   
        	entity.setColorLibelle(dto.getColorLibelle());   
        	entity.setDescription(dto.getDescription());   
        	entity.setIconeActive(dto.getIconeActive());   
        	entity.setIconeHover(dto.getIconeHover());   
        	entity.setIconeNormale(dto.getIconeNormale());   
        	entity.setLibelle(dto.getLibelle());   
		}
		
		return  entity;
    }
    /**
     * Convert list ModuleDto -> list ModuleEntity
     * @param List<ModuleDto>
     */
    public static List<ModuleEntity> dtosToEntities(List<ModuleDto> listDto){
		List<ModuleEntity> list = new ArrayList<>();
 		if(Functions.isNotEmpty(listDto)){
        	for(ModuleDto dto:listDto){
    			list.add(dtoToEntity(dto));
    		}
		}
        return list;
    }
    /**
     * Convert list ModuleEntity -> list ModuleDto
     * @param List<ModuleEntity>
     */
    public static List<ModuleDto> entitiesToDtos(List<ModuleEntity> listEntity){
		List<ModuleDto> list = new ArrayList<>();
		if(Functions.isNotEmpty(listEntity)){
        	for(ModuleEntity entity:listEntity){
    			list.add(entityToDto(entity));
    		}
		}
        return list;
    }
}