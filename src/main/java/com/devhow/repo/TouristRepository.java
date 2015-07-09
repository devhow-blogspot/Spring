package com.devhow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.devhow.model.Tourist;

public interface TouristRepository extends JpaRepository<Tourist, Long> {

	public List<Tourist> findByLastname(@Param("lastName") String lastname);
}
