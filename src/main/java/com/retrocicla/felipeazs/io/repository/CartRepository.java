package com.retrocicla.felipeazs.io.repository;
//package com.retrocicla.felipeazs.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.retrocicla.felipeazs.model.Cart;
//
//public interface CartRepository extends JpaRepository<Cart, Integer> {
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
