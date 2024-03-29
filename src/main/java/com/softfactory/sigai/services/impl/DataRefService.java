/*
 * Be careful, do not modify this class, it is generated automatically.
 */
package com.softfactory.sigai.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softfactory.sigai.controllers.dto.EtatDto;
import com.softfactory.sigai.controllers.dto.StyleDto;
import com.softfactory.sigai.controllers.dto.TypeBienDto;
import com.softfactory.sigai.controllers.dto.TypeGarantDto;
import com.softfactory.sigai.controllers.dto.VueDto;
import com.softfactory.sigai.repository.IEtatRepository;
import com.softfactory.sigai.repository.ILocataireRepository;
import com.softfactory.sigai.repository.IStyleRepository;
import com.softfactory.sigai.repository.ITypeBienRepository;
import com.softfactory.sigai.repository.ITypeGarantRepository;
import com.softfactory.sigai.repository.IVueRepository;
import com.softfactory.sigai.services.IDataRefService;

/**
 * 
 * @author omarkourmou1
 *
 */
@Service
public class DataRefService implements IDataRefService {

	@Autowired
	ILocataireRepository locataireRespository;

	@Autowired
	ITypeBienRepository typeBienRepository;

	@Autowired
	ITypeGarantRepository typeGarantRepositort;

	@Autowired
	IStyleRepository styleRepository;
	
	@Autowired
	IVueRepository vueRepository;
	
	@Autowired
	IEtatRepository etatRepository;

	@Override
	public List<Object> getALlDataRef() {

		List<Object> dataRef = new ArrayList<>();

		List<TypeBienDto> tybiens = TypeBienDto.entitiesToDtos(typeBienRepository.findAll());
		List<TypeGarantDto> typegarants = TypeGarantDto.entitiesToDtos(typeGarantRepositort.findAll());
		List<StyleDto> styleDtos = StyleDto.entitiesToDtos(styleRepository.findAll());
		List<VueDto> vueDto = VueDto.entitiesToDtos(vueRepository.findAll());
		List<EtatDto> etatDto = EtatDto.entitiesToDtos(etatRepository.findAll());
		
		
		dataRef.add(tybiens);
		dataRef.add(typegarants);
		dataRef.add(styleDtos);
		dataRef.add(vueDto);
		dataRef.add(etatDto);
		return dataRef;
	}

}