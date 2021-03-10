package com.vehiculos.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiculos.demo.entity.Vehiculo;
import com.vehiculos.demo.repository.VehiculoRepository;
import com.vehiculos.demo.util.RHilo;
import com.vehiculos.demo.util.THilo;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

@Service
public class VehiculoService {
	
	@Autowired
	private VehiculoRepository  repository;
	
	private static final Log logger = LogFactory.getLog(VehiculoService.class);
	
	
	public Map<String, Object> saveVehiculo(Vehiculo vehiculo) {
		final long start = System.currentTimeMillis();
		
		try {
			
			Thread hilo2 = new Thread(new RHilo(2));
			hilo2.start();
			logger.info("inico de hilo");
			repository.save(vehiculo);
			
			Map<String, Object> vehiculos = new HashMap<>();
			vehiculos.put("Status", "Ok");
			vehiculos.put("Message", "Vehiculo Creado");
			vehiculos.put("code", 200);
			vehiculos.put("Data",repository.findById(vehiculo.getId()));
			
			logger.info("Elapsed time: {}"+ (System.currentTimeMillis() - start));
			
			return vehiculos;
			
		}catch(Exception e) {
				logger.error("ERROR CREATE USER");
				Map<String, Object> vehiculos = new HashMap<>();
				vehiculos.put("Status", "Error");
				vehiculos.put("code", 400);
				vehiculos.put("Message", e.getMessage());
				return (Map<String, Object>) vehiculos;
		}
		
	}
	
	public List<Vehiculo> saveVehiculos(List<Vehiculo> vehiculos){
		Thread hilo2 = new Thread(new RHilo(2));
		try {
			Thread.sleep(3000);
			hilo2.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return repository.saveAll(vehiculos);
	}
	
	public List<Vehiculo>  getVehiculo(){
		return repository.findAll();
	}
	
	
	public Vehiculo getVehiculoId(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Vehiculo>  getVehiculoByMarca(String marca) {
		return repository.findByMarca(marca);
	}
	
	public List<Vehiculo>  getVehiculoByTipo(String tipo) {
		return repository.findByTipo(tipo);
	}
	
	public List<Vehiculo>  getVehiculoByCategoria(int categoria) {
		return repository.findByCategoria(categoria);
	}
	
	public String deleteVehiculo(int id) {
		repository.deleteById(id);
		return "Vehiculo Eliminado con el ID "+id; 
	}
	
	public Vehiculo updateVehiculo(Vehiculo vehiculo) {
		Thread hilo2 = new Thread(new RHilo(2));
		hilo2.start();
		Vehiculo existiVehiculo=repository.findById(vehiculo.getId()).orElse(null);
		existiVehiculo.setCombustible(vehiculo.getCombustible());
		existiVehiculo.setMarca(vehiculo.getMarca());
		existiVehiculo.setTipo(vehiculo.getTipo());
		existiVehiculo.setVelocidad(vehiculo.getVelocidad());
		return repository.save(existiVehiculo);
	}

}
