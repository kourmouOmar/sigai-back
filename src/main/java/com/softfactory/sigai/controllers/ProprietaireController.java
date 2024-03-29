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
import com.softfactory.sigai.controllers.dto.ProprietaireDto;
import com.softfactory.sigai.services.impl.ProprietaireService;
import com.softfactory.sigai.util.Constants;

/**
 * Spring controller "Proprietaire"
 * 
 * @author : illass elbarhoumi
 * @creation : 08/11/20
 * @version : 1.0
 */
@RestController
@RequestMapping("/proprietaires")
public class ProprietaireController {

	@Autowired
	private ProprietaireService proprietaireService;

	@GetMapping(value = "/v0", headers = Constants.HEADERS)
	// @PreAuthorize("hasRole('"+AuthoritiesConstants.GET_ALL_PROPREETAIRE+"')")
	public SigaiResponse getAllProprietaires() {
		/* get all Proprietaire */
		return new SigaiResponse(ProprietaireDto.entitiesToDtos(proprietaireService.getAllProprietaires()),
				HttpStatus.OK);
	}

	@GetMapping(value = "/v0/{id}", headers = Constants.HEADERS)
	// @PreAuthorize("hasRole('"+AuthoritiesConstants.GET_PROPREETAIRE_BY_ID+"')")
	public SigaiResponse getProprietaireById(@PathVariable Long id) {
		/* return Proprietaire by id */
		return new SigaiResponse(proprietaireService.getProprietaireById(id), HttpStatus.OK);
	}

	@PostMapping(value = "/v0", headers = Constants.HEADERS)
	// @PreAuthorize("hasRole('"+AuthoritiesConstants.SAVE_PROPREETAIRE+"')")
	public SigaiResponse addProprietaire(@RequestBody ProprietaireDto proprietaireDto) {
		/* add Proprietaire */
		return new SigaiResponse(proprietaireService.addProprietaire(proprietaireDto), HttpStatus.OK);
	}

	@PutMapping(value = "/v0", headers = Constants.HEADERS)
	// @PreAuthorize("hasRole('"+AuthoritiesConstants.UPDATE_PROPREETAIRE+"')")
	public SigaiResponse updateProprietaire(@RequestBody ProprietaireDto proprietaireDto) {
		/* update Proprietaire */
		return new SigaiResponse(proprietaireService.updateProprietaire(proprietaireDto), HttpStatus.OK);
	}

	@DeleteMapping(value = "/v0/{id}", headers = Constants.HEADERS)
	// @PreAuthorize("hasRole('"+AuthoritiesConstants.DELETE_PROPREETAIRE+"')")
	public SigaiResponse deleteProprietaire(@PathVariable Long id) {
		/* delete Proprietaire */
		proprietaireService.deleteProprietaire(id);
		return new SigaiResponse(HttpStatus.OK);
	}

}
