package tn.esprit.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idEquipement")
    @JsonAlias({"id", "idEquipement"})
    private Long idEquipement;

    @Column(nullable = false, length = 80)
    @JsonProperty("libelle")
    @JsonAlias({"Libelle", "libelle"})
    private String libelle;

    @Column(nullable = true)
    private Integer quantite;

    @JsonIgnore
    @ManyToMany
    private List<Vehicule> vehicules;

    public Long getId() {
        return idEquipement;
    }

    public void setId(Long id) {
        this.idEquipement = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}

