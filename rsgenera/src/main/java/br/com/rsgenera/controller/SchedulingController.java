package br.com.rsgenera.controller;

import br.com.rsgenera.entity.Scheduling;
import br.com.rsgenera.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scheduling")
public class SchedulingController {

    @Autowired
    private SchedulingService service;

    @GetMapping
    public List<Scheduling> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scheduling> getById(@PathVariable Long id) {
        try {
            Scheduling scheduling = service.findById(id)
                    .orElseThrow(() -> new RuntimeException("História não encontrada"));
            return ResponseEntity.ok(scheduling);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Scheduling save(@RequestBody Scheduling scheduling) {
        return service.save(scheduling);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scheduling> update(@PathVariable Long id, @RequestBody Scheduling schedulingDetails) {
        try {
            Scheduling scheduling = service.update(id, schedulingDetails);
            return ResponseEntity.ok(scheduling);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
