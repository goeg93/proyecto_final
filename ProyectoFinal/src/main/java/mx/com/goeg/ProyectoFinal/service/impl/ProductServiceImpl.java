package mx.com.goeg.ProyectoFinal.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import mx.com.goeg.ProyectoFinal.dto.ProductDto;
import mx.com.goeg.ProyectoFinal.entity.Category;
import mx.com.goeg.ProyectoFinal.entity.Product;
import mx.com.goeg.ProyectoFinal.repository.CategoryRepository;
import mx.com.goeg.ProyectoFinal.repository.ProductRepository;
import mx.com.goeg.ProyectoFinal.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ModelMapper modelMapper;
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	
	

	public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository,
			CategoryRepository categoryRepository) {
		this.modelMapper = modelMapper;
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public ProductDto createProduct(ProductDto product, Integer idCategory) {
	 	Product prod =  mapDtoToEntity(product);	 	
	 	Category  cat= this.categoryRepository.findById(idCategory).orElseThrow();
	 	prod.setCategory(cat);
	 	Product prodNew = this.productRepository.save(prod);
	 	return mapEntityToDto(prodNew);
	}

	@Override
	public List<ProductDto> getAllProducts() {
	
		 List<Product> productos = this.productRepository.findAll();
		 
		 List<ProductDto> listDto = productos.stream().map(product -> mapEntityToDto(product)).collect(Collectors.toList());
		 
		 return listDto;
	}

	@Override
	public ProductDto getProductById(Integer idProduct) {
		Product product = this.productRepository.getById(idProduct);
		return mapEntityToDto(product);
	}

	@Override
	public ProductDto getProductByName(String name) {
		Product product= this.productRepository.findProductByName(name);
		return mapEntityToDto(product);
	}

	@Override
	public ProductDto updateProduct(ProductDto dto, Integer idProduct) {
		Product product = this.productRepository.findById(idProduct).orElseThrow();
		product.setDescription(dto.getDescription());
		product.setPrice(dto.getPrice());
		product.setCategory(dto.getCategory());
		product.setName(dto.getName());
		product.setEnabled(dto.isEnabled());
		Product newProduct = this.productRepository.save(product);
		return mapEntityToDto(newProduct);
	}

	@Override
	public void deleteProductById(Integer idProduct) {
		Product prod =  this.productRepository.findById(idProduct).orElseThrow();
		this.productRepository.delete(prod);
	}

	@Override
	public List<ProductDto> getAllProductByEnableb() {
		List<Product> products= this.productRepository.findAll();
		
		List<ProductDto> dtos = products.stream().map(prod -> mapEntityToDto(prod)).collect(Collectors.toList());
		
		return dtos.stream().filter(prod -> !prod.isEnabled()).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getProductsByCategoryId(Integer idCategory) {
		List<Product> products= this.productRepository.findByCategory_IdCategory(idCategory);
		List<ProductDto> listDto = products.stream().map(prod -> mapEntityToDto(prod)).collect(Collectors.toList());
		return listDto;
	}



	public ProductDto mapEntityToDto(Product product) {
		ProductDto dto = this.modelMapper.map(product, ProductDto.class);
		return dto;
	}

	
	public Product mapDtoToEntity(ProductDto dto) {
		Product product = this.modelMapper.map(dto, Product.class);
		return product;
	}

}
