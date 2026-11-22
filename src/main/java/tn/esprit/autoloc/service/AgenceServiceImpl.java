package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
public class AgenceServiceImpl implements IagenceService {

    @Autowired
    private AgenceRepository agenceRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

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

    @Override
    public Vehicule assignVehiculeToAgence(Long idVehicule, Long idAgence) {
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new ResourceNotFoundException("Agence", idAgence));
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", idVehicule));

        vehicule.setAgence(agence);
        if (agence.getVehicules() != null && !agence.getVehicules().contains(vehicule)) {
            agence.getVehicules().add(vehicule);
        }
        return vehiculeRepository.save(vehicule);
    }
}
