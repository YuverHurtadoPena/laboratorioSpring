package com.crudproducto.dto;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
@SqlResultSetMapping(
		   name = "productDtoMapping",
		   classes = @ConstructorResult(
		      targetClass = productDto.class,
		      columns = {
		         @ColumnResult(name = "nombre", type = String.class),
		         @ColumnResult(name = "descripcion", type = String.class) 
		      }
		   )
		)

 
public class productDto {
	private String nombre;

	private String descripcion;

	 

	public productDto(String nombre, String descripcion ) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		 
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
