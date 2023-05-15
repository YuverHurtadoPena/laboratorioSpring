package com.crudproducto.servicio;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crudproducto.dto.ProductoDto;
import com.crudproducto.dto.VentaDto;
import com.crudproducto.dto.productDto;

public interface IProductoService {

	/**
	 * actualiza un producto en la base datos
	 * 
	 * @param dto
	 */
	public ResponseEntity<?> ActualizarProducto(ProductoDto dto);

	/**
	 * borra un producto en la base datos
	 * 
	 * @param dto
	 */
	public ResponseEntity<?> borrarProducto(String nombre);


	/**
	 * retorna todos los productos
	 * 
	 * @return lista de productos
	 */
	public ResponseEntity<?> getListaProductos();
	
	/**
	 * sirve para obtener los productos baratos o caros
	 * 
	 * @param criterio
	 * @return lista de productos
	 */
	public ResponseEntity<?> getProductosBaratosOrCaros(Integer criterio);
	
	

	/**
	 * Guardar un producto en la base datos
	 * 
	 * @param dto
	 */
	public ResponseEntity<?> insertProducto(ProductoDto dto);
	
	public ResponseEntity<?>productSinEntity( );
 
}
