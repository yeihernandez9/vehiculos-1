package com.vehiculos.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehiculos.demo.entity.Vehiculo;
import com.vehiculos.demo.service.VehiculoService;

@RestController
public class VehiculoController {
	
	@Autowired
	private VehiculoService  service;
	
	@PostMapping("/addVehiculo")
	public Map<String, Object> addVehiculo(@RequestBody Vehiculo vehiculo) {
		
		return service.saveVehiculo(vehiculo);
	}
	
	@PostMapping("/addVehiculos")
	public List<Vehiculo> addVehiculos(@RequestBody List<Vehiculo> vehiculo){
		
		return service.saveVehiculos(vehiculo);
	}
	
	@GetMapping("/getVehiculos")
	public List<Vehiculo> getVehiculo() {
		
		return service.getVehiculo();
	}
	
	@GetMapping("/getVehiculo/{id}")
	public Vehiculo getVehiculo(@PathVariable int id) {
		return service.getVehiculoId(id);
		
	}
	
	@GetMapping("/vehiculoMarca/{marca}")
	public List<Vehiculo>  findVehiculoByMarca(@PathVariable String marca) {
		
		return service.getVehiculoByMarca(marca);
	}
	
	@GetMapping("/vehiculoTipo/{tipo}")
	public List<Vehiculo>  findVehiculoByTipo(@PathVariable String tipo) {
		
		return service.getVehiculoByTipo(tipo);
	}
	
	@GetMapping("/vehiculoCategoria/{categoria}")
	public List<Vehiculo>  findVehiculoByCategoria(@PathVariable int categoria) {
		
		return service.getVehiculoByCategoria(categoria);
	}
	
	@PutMapping("/update")
	public Vehiculo updateVehiculo(@RequestBody Vehiculo vehiculo) {
		
		return service.updateVehiculo(vehiculo);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteVehiculo(@PathVariable int id) {
		
		return service.deleteVehiculo(id);
	}
	

}
