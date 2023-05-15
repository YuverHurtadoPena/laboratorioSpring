package com.crudproducto.controller;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

import com.crudproducto.dto.ProductoDto;
import com.crudproducto.dto.VentaDto;
import com.crudproducto.servicio.IProductoService;

import jakarta.servlet.http.HttpServletResponse;

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

	
	   @GetMapping("/personas")
	    public void descargarArchivoExcel(HttpServletResponse response) throws IOException {

	         
	        List<VentaDto> personas = (List<VentaDto>) service.productSinEntity().getBody();

	        // Crear una instancia de la clase Workbook (para un archivo de Excel de tipo XLSX)
	        Workbook workbook = new XSSFWorkbook();

	        // Crear una hoja de trabajo con un nombre específico
	        Sheet sheet = workbook.createSheet("Reporte de ventas");

	        
	        // crear el estilo de fuente para el encabezado
	        Font headerFont = workbook.createFont();
	        headerFont.setBold(true);
	        headerFont.setColor(IndexedColors.BLUE_GREY.getIndex());
	        
	        
	        
	        // Crear una fila de encabezado
	        Row headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("ID VENTA");
	        headerRow.createCell(1).setCellValue("NOMBRE");
	  
	        int rowNum = 1;
	        for (VentaDto persona : personas) {
	            Row row = sheet.createRow(rowNum++);
	            row.createCell(0).setCellValue(persona.getId());
	            row.createCell(1).setCellValue(persona.getNombre());
	     
	        }

	        // Configurar la respuesta HTTP para que el navegador descargue el archivo Excel
	        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	        response.setHeader("Content-Disposition", "attachment; filename=\"reporteventa.xlsx\"");

	        // Escribir el archivo de Excel en la respuesta HTTP
	        workbook.write(response.getOutputStream());

	        // Cerrar el workbook
	        workbook.close();
	    
	}
	   
	   @GetMapping("/export-csv")
	   public void exportCsv(HttpServletResponse response) throws IOException {
	       List<VentaDto> people = Arrays.asList(
	               new VentaDto(1, "Doe"),
	               new VentaDto(2, "Doe"),
	               new VentaDto(3, "Smith")
	       );

	       StringBuilder sb = new StringBuilder();
	       sb.append("Nombre,Apellido,Edad\n");
	       for (Person person : people) {
	           sb.append(person.getFirstName())
	             .append(",")
	             .append(person.getLastName())
	             .append(",")
	             .append(person.getAge())
	             .append("\n");
	       }

	       response.setContentType("text/csv");
	       response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"people.csv\"");
	       response.getOutputStream().write(sb.toString().getBytes(StandardCharsets.UTF_8));
	   }
}
