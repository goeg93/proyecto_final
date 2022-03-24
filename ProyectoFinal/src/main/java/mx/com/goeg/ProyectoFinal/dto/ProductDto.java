package mx.com.goeg.ProyectoFinal.dto;

import lombok.Data;
import mx.com.goeg.ProyectoFinal.entity.Category;

@Data
public class ProductDto {
	private Integer idProduct;
	private Category category;
	private String name;
	private String description;
	private double price;
	private boolean enabled;
}
