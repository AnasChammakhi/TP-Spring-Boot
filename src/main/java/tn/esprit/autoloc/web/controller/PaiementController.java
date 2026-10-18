package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IpaiementService;

import java.util.List;

@SuppressWarnings("java:S4684")
@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
@Tag(name = "Paiements", description = "Gestion des paiements")
public class PaiementController {

    private final IpaiementService paiementService;

    @Operation(summary = "Lister tous les paiements")
    @ApiResponse(responseCode = "200", description = "Liste des paiements récupérée avec succès")
    @GetMapping
    public List<Paiement> findAll() {
        return paiementService.getAll();
    }

    @Operation(summary = "Consulter un paiement")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Paiement trouvé"),
        @ApiResponse(responseCode = "404", description = "Paiement introuvable")
    })
    @GetMapping("/{id}")
    public Paiement findById(@Parameter(description = "Identifiant du paiement") @PathVariable Long id) {
        return paiementService.getById(id);
    }
}
