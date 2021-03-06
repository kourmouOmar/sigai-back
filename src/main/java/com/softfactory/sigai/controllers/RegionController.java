package com.softfactory.sigai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softfactory.sigai.config.AuthoritiesConstants;
import com.softfactory.sigai.config.SigaiResponse;
import com.softfactory.sigai.controllers.dto.RegionDto;
import com.softfactory.sigai.services.IRegionService;
import com.softfactory.sigai.util.Constants;

/**
 * Spring controller "Region"
 * 
 * @author : illass elbarhoumi
 * @creation : 08/11/20
 * @version : 1.0
 */
@RestController
@RequestMapping("/regions")
public class RegionController {

	@Autowired
	private IRegionService RegionService;

	@GetMapping(value = "/v0", headers = Constants.HEADERS)
	@PreAuthorize("hasRole('" + AuthoritiesConstants.ASSISTANTE + "')")
	public SigaiResponse getAllRegions() {
		/* get all Region */
		return new SigaiResponse(RegionService.getAllRegions(), HttpStatus.OK);
	}

	@GetMapping(value = "/v0/{id}", headers = Constants.HEADERS)
	@PreAuthorize("hasRole('" + AuthoritiesConstants.ASSISTANTE + "')")
	public SigaiResponse getRegionById(@PathVariable Long id) {
		/* return Region by id */
		return new SigaiResponse(RegionService.getRegionById(id), HttpStatus.OK);
	}

	@PostMapping(value = "/v0", headers = Constants.HEADERS)
	@PreAuthorize("hasRole('" + AuthoritiesConstants.ASSISTANTE + "')")
	public SigaiResponse addRegion(@RequestBody RegionDto RegionDto) {
		/* add Region */
		return new SigaiResponse(RegionService.addRegion(RegionDto), HttpStatus.OK);
	}

	@PutMapping(value = "/v0", headers = Constants.HEADERS)
	@PreAuthorize("hasRole('" + AuthoritiesConstants.ASSISTANTE + "')")
	public SigaiResponse updateRegion(@RequestBody RegionDto RegionDto) {
		/* update Region */
		return new SigaiResponse(RegionService.updateRegion(RegionDto), HttpStatus.OK);
	}

	@DeleteMapping(value = "/v0", headers = Constants.HEADERS)
	@PreAuthorize("hasRole('" + AuthoritiesConstants.ASSISTANTE + "')")
	public SigaiResponse deleteRegion(@PathVariable Long id) {
		/* delete Region */
		RegionService.deleteRegion(id);
		return new SigaiResponse(HttpStatus.OK);
	}

}
