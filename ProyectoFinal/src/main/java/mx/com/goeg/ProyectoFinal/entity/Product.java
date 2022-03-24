package mx.com.goeg.ProyectoFinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="producto")
@Data
public class Product {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer idProduct;
		
		@ManyToOne
		@JoinColumn(name="id_category", nullable = false)
		private Category category;
		
		@Column(length = 50, nullable = false)
		private String name;
		
		@Column(length = 150, nullable = false)
		private String description;
		
		@Column(columnDefinition = "decimal(5,2)", nullable = false)
		private double price;
		
		private boolean enabled;
}
