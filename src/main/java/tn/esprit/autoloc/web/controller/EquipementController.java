package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IequipementService;

import java.util.List;

@SuppressWarnings("java:S4684")
@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
@Tag(name = "Equipements", description = "Gestion des équipements")
public class EquipementController {

    private final IequipementService equipementService;

    @Operation(summary = "Lister tous les équipements")
    @ApiResponse(responseCode = "200", description = "Liste des équipements récupérée avec succès")
    @GetMapping
    public List<Equipement> findAll() {
        return equipementService.getAll();
    }

    @Operation(summary = "Consulter un équipement")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Équipement trouvé"),
        @ApiResponse(responseCode = "404", description = "Équipement introuvable")
    })
    @GetMapping("/{id}")
    public Equipement findById(@Parameter(description = "Identifiant de l'équipement") @PathVariable Long id) {
        return equipementService.getById(id);
    }

    @Operation(summary = "Créer un nouvel équipement")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Équipement créé avec succès"),
        @ApiResponse(responseCode = "400", description = "Libellé vide ou quantité négative")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipement create(@RequestBody Equipement equipement) {
        return equipementService.addeq(equipement);
    }

    @Operation(summary = "Mettre à jour un équipement existant")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Équipement mis à jour avec succès"),
        @ApiResponse(responseCode = "404", description = "Équipement introuvable")
    })
    @PutMapping("/{id}")
    public Equipement update(@Parameter(description = "Identifiant de l'équipement") @PathVariable Long id, @RequestBody Equipement equipement) {
        equipement.setIdEquipement(id);
        equipementService.update(equipement);
        return equipement;
    }

    @Operation(summary = "Supprimer un équipement")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Équipement supprimé avec succès"),
        @ApiResponse(responseCode = "404", description = "Équipement introuvable")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Parameter(description = "Identifiant de l'équipement") @PathVariable Long id) {
        equipementService.remove(equipementService.getById(id));
    }
}
