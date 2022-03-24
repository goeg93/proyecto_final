package mx.com.goeg.ProyectoFinal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.com.goeg.ProyectoFinal.dto.ProductDto;
import mx.com.goeg.ProyectoFinal.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping("/category/{categoryId}/product")
	public ResponseEntity<ProductDto> createProduct(@PathVariable(name="categoryId")Integer categoryId, @RequestBody ProductDto product){
		return new ResponseEntity<ProductDto>(this.productService.createProduct(product,categoryId), HttpStatus.CREATED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		return new ResponseEntity<List<ProductDto>>(this.productService.getAllProducts(),HttpStatus.OK);
	}
	
	
	@PutMapping("/products/{idProduct}")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable(name = "idProduct") Integer idProduct){
		ProductDto prod =  this.productService.updateProduct(productDto, idProduct);
		return new ResponseEntity<ProductDto>(prod, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/products/{idProduct}")
	public ResponseEntity<String> deleteProduct(@PathVariable(name = "idProduct") Integer idProduct){
		this.productService.deleteProductById(idProduct);
		return new ResponseEntity<String>("Delete success", HttpStatus.OK);
	}
	
	@GetMapping("/products/{idProduct}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "idProduct") Integer idProduct){
		return new ResponseEntity<ProductDto>(this.productService.getProductById(idProduct),HttpStatus.OK);
	}
	
	
	@GetMapping("/products/name/{name}")
	public ResponseEntity<ProductDto> getProductByName(@PathVariable(name = "name") String name){
		return new ResponseEntity<ProductDto>(this.productService.getProductByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/products/enabled")
	public ResponseEntity<List<ProductDto>> getProductByEnabled(){
		return new ResponseEntity<List<ProductDto>>(this.productService.getAllProductByEnableb(),HttpStatus.OK);
	}
	
	
/*	@GetMapping("/products/category/{idCategory}")
	public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable(name = "idCategory") Integer idCategory){
		return new ResponseEntity<List<ProductDto>>(this.productService.getAllProductByCategory(idCategory), HttpStatus.OK);
	}*/
	
	@GetMapping("/category/{idCategory}/products")
	public List<ProductDto> getAllProductByCategoryID(@PathVariable(name="idCategory") Integer idCategory){
		return this.productService.getProductsByCategoryId(idCategory);
	}
	
	
}
