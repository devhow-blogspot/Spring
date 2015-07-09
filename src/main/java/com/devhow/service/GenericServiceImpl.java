package com.devhow.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class GenericServiceImpl<E, D, ID extends Serializable> implements GenericService<E,D, ID > {
	
	@Autowired
	private JpaRepository<E, ID> jpaRepository;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	protected Class<E> clazzEntity;
	
	protected Class<D> clazzDto;
	
	@SuppressWarnings("unchecked")
	public GenericServiceImpl() {
		ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
		this.clazzEntity = (Class<E>) genericSuperClass.getActualTypeArguments()[0];
		this.clazzDto = (Class<D>) genericSuperClass.getActualTypeArguments()[1];
	}
	
	public D findById(ID id) {
		E entityId = this.jpaRepository.findOne(id);
		if(entityId != null){
			return mapper.map(entityId, clazzDto);
		}
		return null;
	}

	public List<E> getAll() {
		return this.jpaRepository.findAll();
	}

	public D save(D entityDto) {
		E entityMapped = mapper.map(entityDto, clazzEntity);
		entityMapped = this.jpaRepository.save(entityMapped);
		D remapDto = mapper.map(entityMapped, clazzDto);
		return remapDto;
	}

}
