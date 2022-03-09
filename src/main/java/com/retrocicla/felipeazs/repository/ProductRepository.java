package com.retrocicla.felipeazs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.retrocicla.felipeazs.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findAllByTypeOrderByWearAsc(String productType);
	
	@Query(value = "SELECT DISTINCT wear FROM product WHERE NOT wear = 'indefinido' ORDER BY wear ASC", nativeQuery = true)
	List<String> getDistinctByWear();

	@Query(value = "SELECT DISTINCT style FROM product WHERE NOT style = 'indefinido' ORDER BY style ASC", nativeQuery = true)
	List<String> getDistinctByStyle();

	@Query(value = "SELECT DISTINCT genre FROM product WHERE NOT genre = 'indefinido' ORDER BY genre ASC", nativeQuery = true)
	List<String> getDistinctByGenre();

	@Query(value = "SELECT DISTINCT type FROM product WHERE NOT type = 'indefinido' ORDER BY type ASC", nativeQuery = true)
	List<String> getDistinctByType();

	@Query(value = "SELECT DISTINCT material FROM product WHERE NOT material = 'indefinido' ORDER BY material ASC", nativeQuery = true)
	List<String> getDistinctByMaterial();
	
	@Query(value = "SELECT DISTINCT color FROM product WHERE NOT color = 'indefinido' ORDER BY color ASC", nativeQuery = true)
	List<String> getDistinctByColor();

	@Query(value = "SELECT DISTINCT size FROM product WHERE NOT size = 'indefinido' AND NOT size LIKE '%x%' ORDER BY size ASC", nativeQuery = true)
	List<String> getDistinctByRopaSize();

	@Query(value = "SELECT DISTINCT size FROM product WHERE NOT size = 'indefinido' AND size LIKE '%x%' ORDER BY size ASC", nativeQuery = true)
	List<String> getDistinctByTelaSize();

	@Query(value = "SELECT DISTINCT made_in FROM product WHERE NOT made_in = 'indefinido' ORDER BY made_in ASC", nativeQuery = true)
	List<String> getDistinctByMadeIn();

	List<Product> findByTypeAndMaterialAndWearAndColorAndSizeAndStyleAndGenreAndSeasonAndMade(String type, String material, String wear, String color, String 
			size, String style, String genre, String season, String madeIn);

	Product findById(int id);
	
}
