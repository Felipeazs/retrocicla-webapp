package com.retrocicla.felipeazs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.model.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {

	List<Region> findAllByOrderByNameAsc();

}
