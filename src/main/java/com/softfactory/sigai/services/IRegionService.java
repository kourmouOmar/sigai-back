/*
 * Be careful, do not modify this class, it is generated automatically.
 */
package com.softfactory.sigai.service;
/**
 * Spring service "Region"
 * 
 * @author : illass elbarhoumi
 * @creation : 08/11/20
 * @version : 1.0
 */
public interface IRegionService{

/**
	 * Get Region by Id
	 * 
	 * @param idRegion
	 * @return RegionEntity
	 */
	RegionEntity getRegionById(Long idRegion);

	/**
	 * get all Region
	 *
	 * @return List<RegionEntity>
	 */
	List<RegionEntity> getAllRegions();

	/**
	 * add Region
	 *
	 * @param RegionDto
	 * @return RegionEntity
	 */
	RegionEntity addRegion(RegionDto RegionDto);

	/**
	 * update Region
	 *
	 * @param RegionDto
	 * @return RegionEntity
	 */
	RegionEntity updateRegion(RegionDto RegionDto);

	/**
	 * delete Region
	 *
	 * @param idRegion
	 * @return RegionEntity
	 */
	void deleteRegion(Long idRegion);

}