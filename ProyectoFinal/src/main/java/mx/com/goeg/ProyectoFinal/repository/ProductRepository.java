package mx.com.goeg.ProyectoFinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import mx.com.goeg.ProyectoFinal.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	public Product findProductByName(String name);
	
	List<Product> findProductByEnabled(Boolean status);
	
	List<Product> findByCategory_IdCategory(Integer categoryId);
} 