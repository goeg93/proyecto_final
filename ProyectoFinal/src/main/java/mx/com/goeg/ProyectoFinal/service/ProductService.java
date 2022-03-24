package mx.com.goeg.ProyectoFinal.service;

import java.util.List;


import mx.com.goeg.ProyectoFinal.dto.ProductDto;
public interface ProductService {

	ProductDto createProduct(ProductDto product, Integer idCategory);

	List<ProductDto> getAllProducts();
	
	ProductDto getProductById(Integer idProduct);
	
	ProductDto getProductByName(String name);
	
	ProductDto updateProduct(ProductDto dto, Integer idProduct);
	
	void deleteProductById(Integer idProduct);
	
	List<ProductDto> getAllProductByEnableb();
	
	List<ProductDto> getProductsByCategoryId(Integer idCategory);
	//getCommentsByPostId
}
