package com.retrocicla.felipeazs.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.retrocicla.felipeazs.model.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{
	
	@Query(value = "SELECT id, name, region_id FROM ciudad ORDER BY name ASC", nativeQuery = true)
	List<Ciudad> findAllByNameOrderByNameAsc();

	List<Ciudad> findAllByRegionIdOrderByNameAsc(Integer regionid);

}
