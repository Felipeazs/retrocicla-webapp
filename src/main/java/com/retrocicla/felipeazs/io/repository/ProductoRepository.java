package com.retrocicla.felipeazs.io.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.retrocicla.felipeazs.io.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {
	
	@Query(value = "SELECT DISTINCT prenda FROM productos WHERE NOT prenda = 'indefinido' ORDER BY prenda ASC", nativeQuery = true)
	ArrayList<String> getDistinctByPrenda();

	@Query(value = "SELECT DISTINCT estilo FROM productos WHERE NOT estilo = 'indefinido' ORDER BY estilo ASC", nativeQuery = true)
	ArrayList<String> getDistinctByEstilo();

	@Query(value = "SELECT DISTINCT genero FROM productos WHERE NOT genero = 'indefinido' ORDER BY genero ASC", nativeQuery = true)
	ArrayList<String> getDistinctByGenero();

	@Query(value = "SELECT DISTINCT tipo FROM productos WHERE NOT tipo = 'indefinido' ORDER BY tipo ASC", nativeQuery = true)
	ArrayList<String> getDistinctByTipo();

	@Query(value = "SELECT DISTINCT material FROM productos WHERE NOT material = 'indefinido' ORDER BY material ASC", nativeQuery = true)
	ArrayList<String> getDistinctByMaterial();
	
	@Query(value = "SELECT DISTINCT color FROM productos WHERE NOT color = 'indefinido' ORDER BY color ASC", nativeQuery = true)
	ArrayList<String> getDistinctByColor();

	@Query(value = "SELECT DISTINCT tamano FROM productos WHERE NOT tamano = 'indefinido' AND NOT tamano LIKE '%x%' ORDER BY size ASC", nativeQuery = true)
	ArrayList<String> getDistinctByRopaTamano();

	@Query(value = "SELECT DISTINCT tamano FROM productos WHERE NOT tamano = 'indefinido' AND tamano LIKE '%x%' ORDER BY size ASC", nativeQuery = true)
	ArrayList<String> getDistinctByTelaTamano();

	@Query(value = "SELECT DISTINCT hechoEn FROM productos WHERE NOT hechoEn = 'indefinido' ORDER BY hechoEn ASC", nativeQuery = true)
	ArrayList<String> getDistinctByHechoEn();

//	List<ProductEntity> findByTypeAndMaterialAndWearAndColorAndSizeAndStyleAndGenreAndSeasonAndMade(String type, String material, String wear, String color, String 
//			size, String style, String genre, String season, String madeIn);

	ProductoEntity findById(String productId);

	ProductoEntity findByImageUrl(String imageUrl);

	ProductoEntity findByProductoId(String productoId);
	

	List<ProductoEntity> findAllByTipoOrderByPrendaAsc(String productType);
	
	List<ProductoEntity> findAllByEstiloOrderByPrendaAsc(String productType);

	List<ProductoEntity> findAllByPrendaAndGeneroOrderByPrendaAsc(String wear, String genre);

	List<ProductoEntity> findAllByFibra(String productType);

	List<ProductoEntity> findAllByMaterial(String productType);

	
	
}
