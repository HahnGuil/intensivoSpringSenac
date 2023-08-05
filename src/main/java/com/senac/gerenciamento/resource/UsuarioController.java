package com.senac.gerenciamento.resource;

import com.senac.gerenciamento.model.Pais;
import com.senac.gerenciamento.model.Usuario;
import com.senac.gerenciamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> lisAll(){
        return repository.findAll();
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario){
        return repository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable(value = "id") Long usuariId, @RequestBody Usuario usuario){
        Usuario usuarioFind = repository.findById(usuariId).orElse(null);
        if(usuarioFind != null){
            usuarioFind.setNome(usuario.getNome());
            usuarioFind.setSenha(usuario.getSenha());
            return repository.save(usuarioFind);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long usuarioId){
        Usuario usuarioFind = repository.findById(usuarioId).orElse(null);
        if (usuarioFind != null){
            repository.delete(usuarioFind);
        }

        return ResponseEntity.noContent().build();
    }
}
