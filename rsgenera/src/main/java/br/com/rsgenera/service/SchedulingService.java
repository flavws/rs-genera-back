package br.com.rsgenera.service;

import br.com.rsgenera.entity.Scheduling;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingService repository;

    public Scheduling save(Scheduling scheduling) {
        return repository.save(scheduling);
    }

    public List<Scheduling> findAll() {
        return repository.findAll();
    }

    public Optional<Scheduling> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Scheduling update(Long id, Scheduling schedulingDetails) {
        Scheduling scheduling = repository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
        scheduling.setDate(schedulingDetails.getDate());
        scheduling.setStatus(schedulingDetails.isStatus());
        scheduling.setPerson(schedulingDetails.getPerson());
        scheduling.setProfissional(schedulingDetails.getProfissional());
        scheduling.setObservation(schedulingDetails.getObservation());
        return repository.save(scheduling);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
