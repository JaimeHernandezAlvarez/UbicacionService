package com.service.ubicacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ubicacion.model.Ubicacion;
import com.service.ubicacion.repository.UbicacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UbicacionService {
    @Autowired
    private UbicacionRepository ubicacionRepository;

    //Listar animales
    public List<Ubicacion> findAll(){
        return ubicacionRepository.findAll();
    }

    //Listar animal por id
    public Ubicacion findById(long id){
        return ubicacionRepository.findById(id).get();
    }

    //Guardar Animal
    public Ubicacion save(Ubicacion ubicacion){
        return ubicacionRepository.save(ubicacion);
    }

    //Eliminar animal (por id)
    public void delete(long id){
        ubicacionRepository.deleteById(id);
    }
}
