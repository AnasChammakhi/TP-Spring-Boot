package tn.esprit.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "vehicule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idVehicule")
    @JsonAlias({"id", "idVehicule"})
    private Long idVehicule;

    @Column(nullable = false, unique = true, length = 20)
    private String immatriculation;

    @Column(nullable = false, length = 50)
    private String marque;

    @Column(nullable = false, length = 50)
    private String modele;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CategorieVehicule categorie;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutVehicule statut;

    @ManyToOne (fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"employees", "vehicules"})
    private Agence agence;

    @JsonIgnore
    @OneToMany(mappedBy = "vehicule",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Maintenance> maintenance;

    @JsonIgnore
    @ManyToMany(mappedBy = "vehicules",  fetch = FetchType.LAZY)
    private List<Equipement> equipment;

    @JsonIgnore
    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservation;

    public Long getId() {
        return idVehicule;
    }

    public void setId(Long id) {
        this.idVehicule = id;
    }
}