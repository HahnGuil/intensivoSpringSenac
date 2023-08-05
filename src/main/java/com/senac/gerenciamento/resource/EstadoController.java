package com.senac.gerenciamento.resource;


import com.senac.gerenciamento.model.Estado;
import com.senac.gerenciamento.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public List<Estado> listAll(){
        return repository.findAll();
    }

    @PostMapping
    public Estado create(@RequestBody Estado estado){
        return repository.save(estado);
    }

    @PutMapping("/{id}")
    public Estado update(@PathVariable(value = "id") Long estadoId, @RequestBody Estado estado){
        Estado estadoFind = repository.findById(estadoId).orElse(null);
        if(estadoFind != null){
            estadoFind.setId(estado.getId());
            estadoFind.setNome(estado.getNome());
            estadoFind.setSigla(estado.getSigla());
            estadoFind.setPopulacao(estado.getPopulacao());
            estadoFind.setPais(estado.getPais());

            return repository.save(estadoFind);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long estadoId){
        Estado estadoFind = repository.findById(estadoId).orElse(null);
        if (estadoFind != null){
            repository.delete(estadoFind);
        }

        return ResponseEntity.noContent().build();
    }
}
