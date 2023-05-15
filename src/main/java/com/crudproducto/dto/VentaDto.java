package com.crudproducto.dto;

 

public class VentaDto {
	
	 private Integer id;
	private String nombre;
	public Integer getId() {
		return id;
	}
	public VentaDto() {
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public VentaDto(Integer id, String nombre) {
		 
		this.id = id;
		this.nombre = nombre;
	}
	
	


	 
 
	

}
