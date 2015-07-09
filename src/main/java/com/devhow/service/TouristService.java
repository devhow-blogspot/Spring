package com.devhow.service;

import java.util.List;

import com.devhow.dto.TouristDto;
import com.devhow.model.Tourist;

public interface TouristService extends GenericService<Tourist, TouristDto, Long> {

	public List<Tourist> searchByLastName(String lastname);
}
