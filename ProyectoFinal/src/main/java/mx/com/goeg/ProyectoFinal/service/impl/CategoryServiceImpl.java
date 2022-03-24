package mx.com.goeg.ProyectoFinal.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import mx.com.goeg.ProyectoFinal.dto.CategoryDto;
import mx.com.goeg.ProyectoFinal.entity.Category;
import mx.com.goeg.ProyectoFinal.repository.CategoryRepository;
import mx.com.goeg.ProyectoFinal.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private ModelMapper modelMapper;
	private CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(ModelMapper modelMapper, CategoryRepository categoryRepository) {
		this.modelMapper = modelMapper;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public CategoryDto createCategory(CategoryDto category) {
		 Category categoryEntity  = mapDtoToEntity(category);
		 Category categoryNew =  categoryRepository.save(categoryEntity);
		 CategoryDto dto = mapEntityToDto(categoryNew);
		return dto;
	}

	@Override
	public List<CategoryDto> getAllCategory() {
	
		List<Category> listCategory = categoryRepository.findAll();
		
		List<CategoryDto> listDto =  listCategory.stream()
				                                 .map(category -> mapEntityToDto(category))
				                                 .collect(Collectors.toList());
		return listDto;
	}
	

	public CategoryDto mapEntityToDto(Category category) {
		CategoryDto dto = this.modelMapper.map(category, CategoryDto.class);
		return dto;
	}

	
	public Category mapDtoToEntity(CategoryDto dto) {
		Category category = this.modelMapper.map(dto, Category.class);
		return category;
	}

	
}
