package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;

@Service
public class AgenceServiceImpl implements IagenceService {

    @Autowired
    private AgenceRepository agenceRepository;

    @Override
    public Agence getById(long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Agence> getAll() {
        return agenceRepository.findAll();
    }

    @Override
    public Boolean update(Agence a) {
        agenceRepository.save(a);
        return true;
    }

    @Override
    public Boolean remove(Agence a) {
        agenceRepository.delete(a);
        return true;
    }

    @Override
    public Agence addag(Agence a) {
        return agenceRepository.save(a);
    }
}
