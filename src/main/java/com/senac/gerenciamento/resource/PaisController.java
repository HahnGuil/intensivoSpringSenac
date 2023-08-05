package com.senac.gerenciamento.resource;

import com.senac.gerenciamento.model.Pais;
import com.senac.gerenciamento.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
public class PaisController {


    @Autowired
    private PaisRepository repository;

    @GetMapping
    public List<Pais> listAll(){
        return repository.findAll();
    }

    @PostMapping
    public Pais create(@RequestBody Pais pais){
        return repository.save(pais);
    }

    @PutMapping("/{id}")
    public Pais update(@PathVariable(value = "id") Long paisId, @RequestBody Pais pais){
        Pais paisFind = repository.findById(paisId).orElse(null);
        if(paisFind != null){
            paisFind.setId(pais.getId());
            paisFind.setNome(pais.getNome());
            paisFind.setSigla(pais.getSigla());
            paisFind.setPopulacao(pais.getPopulacao());

            return repository.save(paisFind);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long paisId){
        Pais paisFind = repository.findById(paisId).orElse(null);
        if (paisFind != null){
            repository.delete(paisFind);
        }

        return ResponseEntity.noContent().build();
    }

}
