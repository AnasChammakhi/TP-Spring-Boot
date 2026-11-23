package tn.esprit.autoloc.repository;

import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.domain.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    List<Vehicule> findByReservation_Contrat_IdContrat(Long idContrat);

    // SQL :
    // SELECT v.* FROM maintenance m
    // JOIN vehicule v ON v.id_vehicule = m.vehicule_id_vehicule
    // WHERE m.id_maintenance = ?
    @Query("SELECT m.vehicule FROM Maintenance m WHERE m.idMaintenance = :idMaintenance")
    List<Vehicule> findByMaintenanceId(@Param("idMaintenance") Long idMaintenance);
}