package com.softfactory.sigai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softfactory.sigai.config.AuthoritiesConstants;
import com.softfactory.sigai.config.SigaiResponse;
import com.softfactory.sigai.controllers.dto.LocationDto;
import com.softfactory.sigai.services.impl.LocationService;
import com.softfactory.sigai.util.Constants;

/**
 * Spring controller "Location"
 * 
 * @author : illass elbarhoumi
 * @creation : 08/11/20
 * @version : 1.0
 */
@RestController
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	private LocationService LocationService;

	@RequestMapping(value = "/v0", headers = Constants.HEADERS)
	@PreAuthorize("hasRole('" + AuthoritiesConstants.ASSISTANTE + "')")
	public SigaiResponse getAllLocations() {
		/* get all Location */
		return new SigaiResponse(LocationService.getAllLocations(), HttpStatus.OK);
	}

	@RequestMapping(value = "/v0/{id}", headers = Constants.HEADERS)
	@PreAuthorize("hasRole('" + AuthoritiesConstants.ASSISTANTE + "')")
	public SigaiResponse getLocationById(@PathVariable Long id) {
		/* return Location by id */
		return new SigaiResponse(LocationService.getLocationById(id), HttpStatus.OK);
	}

	@PostMapping(value = "/v0", headers = Constants.HEADERS)
	@PreAuthorize("hasRole('" + AuthoritiesConstants.ASSISTANTE + "')")
	public SigaiResponse addLocation(@RequestBody LocationDto LocationDto) {
		/* add Location */
		return new SigaiResponse(LocationService.addLocation(LocationDto), HttpStatus.OK);
	}

	@PutMapping(value = "/v0", headers = Constants.HEADERS)
	@PreAuthorize("hasRole('" + AuthoritiesConstants.ASSISTANTE + "')")
	public SigaiResponse updateLocation(@RequestBody LocationDto LocationDto) {
		/* update Location */
		return new SigaiResponse(LocationService.updateLocation(LocationDto), HttpStatus.OK);
	}

	@DeleteMapping(value = "/v0", headers = Constants.HEADERS)
	@PreAuthorize("hasRole('" + AuthoritiesConstants.ASSISTANTE + "')")
	public SigaiResponse deleteLocation(@PathVariable Long id) {
		/* delete Location */
		LocationService.deleteLocation(id);
		return new SigaiResponse(HttpStatus.OK);
	}

}
