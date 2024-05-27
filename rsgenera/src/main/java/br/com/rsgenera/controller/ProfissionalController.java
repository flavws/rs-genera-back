package br.com.rsgenera.controller;

import br.com.rsgenera.entity.Profissional;
import br.com.rsgenera.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/profissional")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping
    public Profissional createProfissional(@RequestBody Profissional profissional) {
        return profissionalService.save(profissional);
    }

    @GetMapping
    public List<Profissional> getAllProfissionals() {
        return profissionalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissional> getProfissionalById(@PathVariable Long id) {
        try {
            Profissional profissional = profissionalService.findById(id).orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
            return ResponseEntity.ok(profissional);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profissional> updateProfissional(@PathVariable Long id, @RequestBody Profissional profissional) {
        try {
            Profissional personUpdated = profissionalService.update(id, profissional);
            return ResponseEntity.ok(personUpdated);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerfil(@PathVariable Long id) {
        try {
            profissionalService.findById(id).orElseThrow();
            profissionalService.delete(id);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
