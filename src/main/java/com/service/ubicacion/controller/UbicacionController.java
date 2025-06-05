package com.service.ubicacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.ubicacion.model.Ubicacion;
import com.service.ubicacion.service.UbicacionService;

@RestController
@RequestMapping("/api/v1/ubicaciones")
public class UbicacionController {
    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping
    public ResponseEntity<List<Ubicacion>> listar(){
        List<Ubicacion> ubicaciones = ubicacionService.findAll();
        if(ubicaciones.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ubicaciones);
    }

    @PostMapping
    public ResponseEntity<Ubicacion> guardar(@RequestBody Ubicacion ubicacion){
        Ubicacion nuevo = ubicacionService.save(ubicacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Ubicacion> buscar(@PathVariable Integer id){
        try{
            Ubicacion ubicacion = ubicacionService.findById(id);
            return ResponseEntity.ok(ubicacion);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Ubicacion> actualizar(@PathVariable Integer id, @RequestBody Ubicacion ubicacion){
        try{
            Ubicacion ubi = ubicacionService.findById(id);
            ubi.setId(id);
            ubi.setComuna(ubicacion.getComuna());
            ubi.setEstado(ubicacion.getEstado());
            ubi.setRegion(ubicacion.getRegion());

            ubicacionService.save(ubi);
            return ResponseEntity.ok(ubicacion);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try{
            ubicacionService.delete(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
