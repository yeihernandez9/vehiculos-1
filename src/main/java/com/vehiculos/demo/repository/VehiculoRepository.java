package com.vehiculos.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehiculos.demo.entity.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo,Integer>{

	List<Vehiculo> findByMarca(String marca);

	List<Vehiculo> findByTipo(String tipo);

	List<Vehiculo> findByCategoria(int categoria);

}
