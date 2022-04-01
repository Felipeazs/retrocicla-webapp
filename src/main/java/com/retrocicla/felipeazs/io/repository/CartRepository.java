package com.retrocicla.felipeazs.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.io.entity.CartEntity;

//
//import java.util.List;
//
//import org.springframework.transaction.annotation.Transactional;
//
public interface CartRepository extends JpaRepository<CartEntity, Integer> {

	CartEntity findByClienteId(String cliente_id);

	CartEntity findByProductoProductid(String productId);

	
}

//
//	Cart findByProductId(int id);
//
//	Cart findByProductIdAndClienteEmail(int id, String email);
//
//	List<Cart> findAllByClienteEmail(String cliente);
//
//	@Transactional
//	void deleteAllByClienteId(int id);
//
//}
