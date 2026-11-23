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
public class VehiculeServiceImpl implements VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private AgenceRepository agenceRepository;

    @Override
    public Vehicule getById(long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vehicule> getAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Boolean update(Vehicule v) {
        vehiculeRepository.save(v);
        return true;
    }

    @Override
    public Boolean remove(Vehicule v) {
        vehiculeRepository.delete(v);
        return true;
    }

    @Override
    public Vehicule addv(Vehicule v) {
        return vehiculeRepository.save(v);
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

    @Override
    public List<Vehicule> findByIdContrat(Long idContrat) {
        return vehiculeRepository.findByReservation_Contrat_IdContrat(idContrat);
    }

    @Override
    public List<Vehicule> findByIdMaintenance(Long idMaintenance) {
        return vehiculeRepository.findByMaintenanceId(idMaintenance);
    }
}
