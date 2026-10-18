package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IemployeService;

import java.util.List;

@SuppressWarnings("java:S4684")
@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
@Tag(name = "Employes", description = "Gestion des employés")
public class EmployeController {

    private final IemployeService employeService;

    @Operation(summary = "Lister tous les employés")
    @ApiResponse(responseCode = "200", description = "Liste des employés récupérée avec succès")
    @GetMapping
    public List<Employe> findAll() {
        return employeService.getAll();
    }

    @Operation(summary = "Consulter un employé")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Employé trouvé"),
        @ApiResponse(responseCode = "404", description = "Employé introuvable")
    })
    @GetMapping("/{id}")
    public Employe findById(@Parameter(description = "Identifiant de l'employé") @PathVariable Long id) {
        return employeService.getById(id);
    }

    @Operation(summary = "Créer un nouvel employé")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Employé créé avec succès"),
        @ApiResponse(responseCode = "400", description = "Données de l'employé invalides")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employe create(@RequestBody Employe employe) {
        return employeService.addemp(employe);
    }

    @Operation(summary = "Mettre à jour un employé existant")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Employé mis à jour avec succès"),
        @ApiResponse(responseCode = "404", description = "Employé introuvable")
    })
    @PutMapping("/{id}")
    public Employe update(@Parameter(description = "Identifiant de l'employé") @PathVariable Long id, @RequestBody Employe employe) {
        employe.setIdEmploye(id);
        employeService.update(employe);
        return employe;
    }

    @Operation(summary = "Supprimer un employé")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Employé supprimé avec succès"),
        @ApiResponse(responseCode = "404", description = "Employé introuvable")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Parameter(description = "Identifiant de l'employé") @PathVariable Long id) {
        employeService.remove(employeService.getById(id));
    }
}
