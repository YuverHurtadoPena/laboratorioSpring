package com.crudproducto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudproducto.dto.ProductoDto;
import com.crudproducto.servicio.IProductoService;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class ProductoController {
	@Autowired
	private IProductoService service;

	@PutMapping("update")
	public ResponseEntity<?> actualizar(@RequestBody ProductoDto dto) {
		return service.ActualizarProducto(dto);
	}

	@PostMapping("save")
	public ResponseEntity<?> crearProducto(@RequestBody ProductoDto dto) {
		return service.insertProducto(dto);
	}

	@GetMapping("delete/{nombre}")
	public ResponseEntity<?> eliminarProducto(@PathVariable("nombre") String nombre) {
		return service.borrarProducto(nombre);
	}

	@GetMapping("listaProductos")
	public ResponseEntity<?> getListaProductos() {
		return service.getListaProductos();
	}

	@GetMapping("get_productos_baratos_Caros/{criterio}")
	public ResponseEntity<?> getProductosBaratosOrCaros(@PathVariable("criterio") Integer criterio) {
		return service.getProductosBaratosOrCaros(criterio);
	}
	@GetMapping("sinEntity")
	public ResponseEntity<?> getProductoSe() {
		return service.productSinEntity();
	}

}
