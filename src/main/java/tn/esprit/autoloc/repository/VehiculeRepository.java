package tn.esprit.autoloc.repository;

import tn.esprit.autoloc.domain.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    List<Vehicule> findByReservation_Contrat_IdContrat(Long idContrat);

    List<Vehicule> findByMaintenance_IdMaintenance(Long idMaintenance);
}