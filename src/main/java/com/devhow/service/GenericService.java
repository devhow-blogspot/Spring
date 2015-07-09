package com.devhow.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<E,D, ID extends Serializable> {

	D findById(ID id);

	List<E> getAll();

	D save(D entityDto);
	
}
