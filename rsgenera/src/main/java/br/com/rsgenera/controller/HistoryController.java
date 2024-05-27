package br.com.rsgenera.controller;

import br.com.rsgenera.entity.History;
import br.com.rsgenera.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    @Autowired
    private HistoryService service;

    @GetMapping
    public List<History> getHistories() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<History> getHistoryById(@PathVariable Long id) {
        try {
            History history = service.findById(id).orElseThrow(() -> new RuntimeException("História não encontrada"));
            return ResponseEntity.ok(history);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public History addHistory(@RequestBody History history) {
        return service.save(history);
    }

    @PutMapping("/{id}")
    public ResponseEntity<History> updateHistory(@RequestBody History historyDetails, @PathVariable Long id) {
        try {
            History history = service.update(id, historyDetails);
            return ResponseEntity.ok(history);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteHistory(@PathVariable Long id) {
        service.delete(id);
    }
}
