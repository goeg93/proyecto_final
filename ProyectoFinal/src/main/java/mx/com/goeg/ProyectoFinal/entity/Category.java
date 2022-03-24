package mx.com.goeg.ProyectoFinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="category")
@Data
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategory;
	
	@Column (name = "name", length = 50, nullable = false)
	private String name;
	
	@Column (name = "description", length = 150, nullable = false)
	private String description;
	
	private boolean enable;
		
	
}
