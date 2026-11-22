package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.ImaintenanceService;

import java.util.List;

@SuppressWarnings("java:S4684")
@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
@Tag(name = "Maintenances", description = "Gestion des maintenances")
public class MaintenanceController {

    private final ImaintenanceService maintenanceService;

    @Operation(summary = "Lister toutes les maintenances")
    @ApiResponse(responseCode = "200", description = "Liste des maintenances récupérée avec succès")
    @GetMapping
    public List<Maintenance> findAll() {
        return maintenanceService.getAll();
    }

    @Operation(summary = "Consulter une maintenance")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Maintenance trouvée"),
        @ApiResponse(responseCode = "404", description = "Maintenance introuvable")
    })
    @GetMapping("/{id}")
    public Maintenance findById(@Parameter(description = "Identifiant de la maintenance") @PathVariable Long id) {
        return maintenanceService.getById(id);
    }

    @Operation(summary = "Créer une nouvelle maintenance")
    @ApiResponse(responseCode = "201", description = "Maintenance créée avec succès")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Maintenance create(@RequestBody Maintenance maintenance) {
        return maintenanceService.addm(maintenance);
    }

    @Operation(summary = "Mettre à jour une maintenance existante")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Maintenance mise à jour avec succès"),
        @ApiResponse(responseCode = "404", description = "Maintenance introuvable")
    })
    @PutMapping("/{id}")
    public Boolean update(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        maintenance.setIdMaintenance(id);
        return maintenanceService.update(maintenance);
    }

    @Operation(summary = "Supprimer une maintenance")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Maintenance supprimée avec succès"),
        @ApiResponse(responseCode = "404", description = "Maintenance introuvable")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Parameter(description = "Identifiant de la maintenance") @PathVariable Long id) {
        maintenanceService.remove(maintenanceService.getById(id));
    }

    @Operation(summary = "Lister les maintenances par Id véhicule")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Liste des maintenances du véhicule récupérée avec succès"),
        @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    @GetMapping("/vehicule/{idVehicule}")
    public List<Maintenance> findByIdVehicule(
            @Parameter(description = "Identifiant du véhicule") @PathVariable Long idVehicule) {
        return maintenanceService.findByIdVehicule(idVehicule);
    }
}
