package br.com.rsgenera.service;



import br.com.rsgenera.entity.Profissional;
import br.com.rsgenera.repository.ProfissionalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository repository;

    public Profissional save(Profissional profissional) {
        return repository.save(profissional);
    }

    public List<Profissional> findAll() {
        return repository.findAll();
    }

    public Optional<Profissional> findById(Long id) {
        return repository.findById(id);
    }
    @Transactional
    public Profissional update(Long id, Profissional profissionalDetails) {
        Profissional profissional = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
        profissional.setName(profissionalDetails.getName());
        profissional.setEmail(profissionalDetails.getEmail());
        profissional.setPicture(profissionalDetails.getPicture());
        profissional.setStatus(profissionalDetails.isStatus());

        return repository.save(profissional);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
