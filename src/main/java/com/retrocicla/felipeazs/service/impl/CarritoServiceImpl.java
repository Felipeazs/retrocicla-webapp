package com.retrocicla.felipeazs.service.impl;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.exceptions.ClienteServiceException;
import com.retrocicla.felipeazs.exceptions.ProductoServiceException;
import com.retrocicla.felipeazs.io.entity.CarritoEntity;
import com.retrocicla.felipeazs.io.entity.ClienteEntity;
import com.retrocicla.felipeazs.io.entity.ProductoEntity;
import com.retrocicla.felipeazs.io.repository.CarritoRepository;
import com.retrocicla.felipeazs.io.repository.ClienteRepository;
import com.retrocicla.felipeazs.io.repository.ProductoRepository;
import com.retrocicla.felipeazs.model.CalculoTotalModel;
import com.retrocicla.felipeazs.model.dto.CarritoDto;
import com.retrocicla.felipeazs.service.CarritoService;
import com.retrocicla.felipeazs.ui.model.response.CarritoRest;
import com.retrocicla.felipeazs.ui.model.response.ErrorMessages;

@Service
public class CarritoServiceImpl implements CarritoService {

	@Autowired
	private CarritoRepository carritoRepo;

	@Autowired
	private ProductoRepository productoRepo;

	@Autowired
	private ClienteRepository clienteRepo;

	@Override
	public CarritoDto agregarProductoAlCarrito(String productoId, String clienteEmail) {

		CarritoDto returnValue = new CarritoDto();

		ClienteEntity clienteEntity = clienteRepo.findByEmail(clienteEmail);
		if (clienteEntity == null)
			throw new ClienteServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

		ProductoEntity productoEntity = productoRepo.findByProductoId(productoId);
		if (productoEntity == null)
			throw new ProductoServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

		try {
			CarritoEntity carritoEntity = carritoRepo.findByClienteAndProducto(clienteEntity, productoEntity);
			return actualizarProductoEnCarrito(carritoEntity, clienteEmail);

		} catch (NullPointerException ex) {

			CarritoEntity nuevoCarrito = new CarritoEntity();

			nuevoCarrito.setCliente(clienteEntity);
			nuevoCarrito.setProducto(productoEntity);
			nuevoCarrito.setCreatedAt(LocalDate.now());
			nuevoCarrito.setQuantity(1);

			int totalPrice = productoEntity.getPrice() * nuevoCarrito.getQuantity();
			nuevoCarrito.setPrice(totalPrice);
			nuevoCarrito.setTotalPrice(formatPrice(totalPrice));

			CarritoEntity carrito = carritoRepo.save(nuevoCarrito);

			BeanUtils.copyProperties(carrito, returnValue);

			return returnValue;
		}

	}

	@Override
	public List<CarritoDto> obtenerTodosPorCliente(String email) {
		
		List<CarritoDto> returnValue = new ArrayList<>();
		
		List<CarritoEntity> carritos = carritoRepo.findAllByClienteEmail(email);
		
		ModelMapper modelMapper = new ModelMapper();
		for (CarritoEntity carrito : carritos) {
			returnValue.add(modelMapper.map(carrito, CarritoDto.class));
		}
		
		
		return returnValue;
	}

	@Override
	public CarritoDto actualizarProductoEnCarrito(CarritoEntity carrito, String email) {

		CarritoDto returnValue = new CarritoDto();
		
		if (email == carrito.getCliente().getEmail()) {
			
			if (carrito.getQuantity() < carrito.getProducto().getStock()) {

				carrito.setQuantity(carrito.getQuantity() + 1);

				int totalPrice = carrito.getQuantity() * carrito.getPrice();
				System.out.println("precio: " + totalPrice);

				Locale clp = new Locale("es", "CL");
				NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
				String price = nf.format(totalPrice);
				carrito.setTotalPrice(price);

				carritoRepo.save(carrito);
			}

			BeanUtils.copyProperties(carrito, returnValue);

			
		}
		
		return returnValue;

	}

	@Override
	public List<CarritoDto> buscarTodosLosProductos(String clienteId) {

		List<CarritoDto> returnValue = new ArrayList<>();

		List<CarritoEntity> carritoEntities = carritoRepo.findAllByClienteClienteId(clienteId);

		ModelMapper modelMapper = new ModelMapper();
		for (CarritoEntity carritoEntity : carritoEntities) {
			returnValue.add(modelMapper.map(carritoEntity, CarritoDto.class));
		}

		return returnValue;
	}

	@Override
	public CalculoTotalModel calcularTotalCliente(String clienteEmail) {

		CalculoTotalModel total = new CalculoTotalModel();

		int total_quantity = 0;
		int total_price = 0;

		ClienteEntity clienteEntity = clienteRepo.findByEmail(clienteEmail);

		List<CarritoDto> carritosDto = buscarTodosLosProductos(clienteEntity.getClienteId());

		for (CarritoDto carritoDto : carritosDto) {
			total_quantity = total_quantity + carritoDto.getQuantity();
			total_price = total_price + (carritoDto.getPrice() * carritoDto.getQuantity());
			System.out.println("cantidad: " + total_quantity + " precio total: " + total_price);
		}

		total.setQuantity(total_quantity);
		total.setTotalprice(formatPrice(total_price));

		return total;

	}

	private String formatPrice(int price) {

		Locale clp = new Locale("es", "CL");
		NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
		String formattedPrice = nf.format(price);

		return formattedPrice;
	}

	

}
////
////	@Override
////	public void removeProduct(Integer productId, String email) {
////		
////		try {
////			Cart findProd = repo.findByProductIdAndClienteEmail(productId, email);
////			
////			if (findProd.getQuantity() > 1) {
////				findProd.setQuantity(findProd.getQuantity() - 1);		
////				
////				int totalPrice = findProd.getQuantity() * findProd.getPrice();
////				Locale clp = new Locale("es", "CL");
////				NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
////				String price = nf.format(totalPrice);		
////				findProd.setTotalPrice(price);
////				
////				repo.save(findProd);
////			} else {
////				deleteProduct(productId, email);
////			}
////						
////		} catch (NullPointerException ex) {
////			System.out.println(ex.getMessage());
////		}		
////	}
////
////	@Override
////	public void deleteProduct(Integer productId, String email) {
////		
////		try {
////			Cart product = repo.findByProductIdAndClienteEmail(productId, email);
////			repo.delete(product);
////		} catch (StaleStateException ex) {
////			ex.getMessage();
////		}
////		
////		
////	}
////
////
////	@Override
////	public List<Cart> getProductsByClienteId(String cliente) {
////		
////		return repo.findAllByClienteEmail(cliente);
////	}
////
////
////	@Override
////	public Cart getProductByIdAndEmail(int id, String email) {
////		
////		return repo.findByProductIdAndClienteEmail(id, email);
////	}
////
////
////	@Override
////	public List<Cart> listByClienteEmail(String email) {
////		
////		return repo.findAllByClienteEmail(email);
////	}
//
//}
