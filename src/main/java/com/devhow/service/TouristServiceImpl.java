package com.devhow.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devhow.dto.TouristDto;
import com.devhow.model.Tourist;
import com.devhow.repo.TouristRepository;
@Service
public class TouristServiceImpl extends GenericServiceImpl<Tourist, TouristDto, Long> implements TouristService {

	@Autowired
	private TouristRepository touristRepository;
	
	public List<Tourist> searchByLastName(String lastname) {
		return this.touristRepository.findByLastname(lastname);
	}


}
