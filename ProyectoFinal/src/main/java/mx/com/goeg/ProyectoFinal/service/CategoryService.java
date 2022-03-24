package mx.com.goeg.ProyectoFinal.service;

import java.util.List;

import mx.com.goeg.ProyectoFinal.dto.CategoryDto;

public interface CategoryService {
 
	CategoryDto createCategory(CategoryDto category);
	
	List<CategoryDto> getAllCategory();
}
