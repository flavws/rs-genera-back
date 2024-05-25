package br.com.rsgenera.service;

import br.com.rsgenera.entity.History;
import br.com.rsgenera.repository.HistoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository repository;

    public History save(History history) {
        return repository.save(history);
    }

    public List<History> findAll() {
        return repository.findAll();
    }

    public Optional<History> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public History update(Long id, History historyDetails) {
        History history = repository.findById(id).orElseThrow(() -> new RuntimeException("História não encontrada"));
        history.setCreationDate(historyDetails.getCreationDate());
        history.setDescription(historyDetails.getDescription());
        history.setStatus(historyDetails.isStatus());
        return repository.save(history);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
