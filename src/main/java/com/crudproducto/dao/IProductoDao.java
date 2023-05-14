package com.crudproducto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crudproducto.dto.VentaDto;
import com.crudproducto.dto.productDto;

import com.crudproducto.entity.Producto;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;

@Repository
public interface IProductoDao extends JpaRepository<Producto, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM producto where nombre=?1", nativeQuery = true)
	public void deleteProducto(String nombre);
	
	@Transactional
	@Query(value = "SELECT * FROM producto WHERE precio<(SELECT AVG(precio) FROM producto) ORDER BY nombre ASC", nativeQuery = true)
	public List<Producto> getProductoBaratos();
	
	@Transactional
	@Query(value = "SELECT * FROM producto WHERE precio>(SELECT AVG(precio) FROM producto) ORDER BY nombre ASC", nativeQuery = true)
	public List<Producto> getProductoCaros();
	
	@Transactional
	@Query(value = "SELECT nombre from producto where nombre=?1 order by nombre", nativeQuery = true)
	public String isProduct(String nombre);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE producto SET descripcion=?1, precio=?2 WHERE nombre=?3", nativeQuery = true)
	public void updateProducto( String descripcion, double use, String nombre);

	@Query(value = "SELECT  new com.crudproducto.dto.VentaDto(v.id, p.nombre) FROM Venta v  inner JOIN Producto p ON p.id = v.idProduc ", nativeQuery = false)
	public  List<VentaDto>productSinEntity();
	
	
	 @Query(value="SELECT v.id, p.nombre FROM venta v INNER JOIN producto p ON p.id = v.producto_id", nativeQuery=true)
	  List<Object[]> findVentasAndProductos();
	  

	  

}
