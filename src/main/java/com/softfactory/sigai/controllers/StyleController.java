package com.softfactory.sigai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softfactory.sigai.config.SigaiResponse;
import com.softfactory.sigai.controllers.dto.StyleDto;
import com.softfactory.sigai.services.IStyleService;
import com.softfactory.sigai.util.Constants;

/**
 * Spring controller "Style"
 * 
 * @author : illass elbarhoumi
 * @creation : 08/11/20
 * @version : 1.0
 */
@RestController
@RequestMapping("/styles")
public class StyleController {

	@Autowired
	private IStyleService styleService;

	@GetMapping(value = "/v0", headers = Constants.HEADERS)
	//@PreAuthorize("hasRole('" + AuthoritiesConstants.GET_ALL_STYLE + "')")
	public SigaiResponse getAllStyles() {
		/* get all Style */
		return new SigaiResponse(StyleDto.entitiesToDtos(styleService.getAllStyles()), HttpStatus.OK);
	}

	@GetMapping(value = "/v0/{id}", headers = Constants.HEADERS)
	//@PreAuthorize("hasRole('" + AuthoritiesConstants.GET_STYLE_BY_ID + "')")
	public SigaiResponse getStyleById(@PathVariable Long id) {
		/* return Style by id */
		return new SigaiResponse(styleService.getStyleById(id), HttpStatus.OK);
	}

	@PostMapping(value = "/v0", headers = Constants.HEADERS)
	//@PreAuthorize("hasRole('" + AuthoritiesConstants.SAVE_STYLE + "')")
	public SigaiResponse addStyle(@RequestBody StyleDto StyleDto) {
		/* add Style */
		return new SigaiResponse(styleService.addStyle(StyleDto), HttpStatus.OK);
	}

	@PutMapping(value = "/v0", headers = Constants.HEADERS)
	//@PreAuthorize("hasRole('" + AuthoritiesConstants.UPDATE_STYLE + "')")
	public SigaiResponse updateStyle(@RequestBody StyleDto StyleDto) {
		/* update Style */
		return new SigaiResponse(styleService.updateStyle(StyleDto), HttpStatus.OK);
	}

	@DeleteMapping(value = "/v0/{id}", headers = Constants.HEADERS)
	//@PreAuthorize("hasRole('" + AuthoritiesConstants.DELETE_STYLE + "')")
	public SigaiResponse deleteStyle(@PathVariable Long id) {
		/* delete Style */
		styleService.deleteStyle(id);
		return new SigaiResponse(HttpStatus.OK);
	}

}
