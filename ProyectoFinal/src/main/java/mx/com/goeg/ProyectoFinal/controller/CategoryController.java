package mx.com.goeg.ProyectoFinal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.goeg.ProyectoFinal.dto.CategoryDto;
import mx.com.goeg.ProyectoFinal.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	@PostMapping
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto dto){
		return new ResponseEntity<CategoryDto>(this.categoryService.createCategory(dto), HttpStatus.CREATED);
	}


	@GetMapping
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> categorys = this.categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(categorys, HttpStatus.OK);
	}
	
	
}
