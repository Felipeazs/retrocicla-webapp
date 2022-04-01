package com.retrocicla.felipeazs.io.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.retrocicla.felipeazs.io.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
	
	List<ProductEntity> findAllByTypeOrderByWearAsc(String productType);
	
	@Query(value = "SELECT DISTINCT wear FROM productos WHERE NOT wear = 'indefinido' ORDER BY wear ASC", nativeQuery = true)
	ArrayList<String> getDistinctByWear();

	@Query(value = "SELECT DISTINCT style FROM productos WHERE NOT style = 'indefinido' ORDER BY style ASC", nativeQuery = true)
	ArrayList<String> getDistinctByStyle();

	@Query(value = "SELECT DISTINCT genre FROM productos WHERE NOT genre = 'indefinido' ORDER BY genre ASC", nativeQuery = true)
	ArrayList<String> getDistinctByGenre();

	@Query(value = "SELECT DISTINCT type FROM productos WHERE NOT type = 'indefinido' ORDER BY type ASC", nativeQuery = true)
	ArrayList<String> getDistinctByType();

	@Query(value = "SELECT DISTINCT material FROM productos WHERE NOT material = 'indefinido' ORDER BY material ASC", nativeQuery = true)
	ArrayList<String> getDistinctByMaterial();
	
	@Query(value = "SELECT DISTINCT color FROM productos WHERE NOT color = 'indefinido' ORDER BY color ASC", nativeQuery = true)
	ArrayList<String> getDistinctByColor();

	@Query(value = "SELECT DISTINCT size FROM productos WHERE NOT size = 'indefinido' AND NOT size LIKE '%x%' ORDER BY size ASC", nativeQuery = true)
	ArrayList<String> getDistinctByRopaSize();

	@Query(value = "SELECT DISTINCT size FROM productos WHERE NOT size = 'indefinido' AND size LIKE '%x%' ORDER BY size ASC", nativeQuery = true)
	ArrayList<String> getDistinctByTelaSize();

	@Query(value = "SELECT DISTINCT madeIn FROM productos WHERE NOT madeIn = 'indefinido' ORDER BY madeIn ASC", nativeQuery = true)
	ArrayList<String> getDistinctByMadeIn();

//	List<ProductEntity> findByTypeAndMaterialAndWearAndColorAndSizeAndStyleAndGenreAndSeasonAndMade(String type, String material, String wear, String color, String 
//			size, String style, String genre, String season, String madeIn);

	ProductEntity findById(String productId);

	ProductEntity findByImageUrl(String imageUrl);

	ProductEntity findByProductid(String poductos_id);
	
}
