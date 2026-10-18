package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;

@Service
public class PaiementServiceImpl implements IpaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    @Override
    public Paiement getById(long id) {
        return paiementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Paiement> getAll() {
        return paiementRepository.findAll();
    }

    @Override
    public Boolean update(Paiement p) {
        paiementRepository.save(p);
        return true;
    }

    @Override
    public Boolean remove(Paiement p) {
        paiementRepository.delete(p);
        return true;
    }

    @Override
    public Paiement addp(Paiement p) {
        return paiementRepository.save(p);
    }
}
