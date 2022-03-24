package mx.com.goeg.ProyectoFinal.dto;

import lombok.Data;

@Data
public class CategoryDto {
	private Integer idCategory;	
	private String name;	
	private String description;
	private boolean enable;
}
