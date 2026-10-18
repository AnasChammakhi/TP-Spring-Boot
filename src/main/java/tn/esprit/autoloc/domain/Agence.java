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
@Table(name = "Agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idAgence")
    @JsonAlias({"id", "idAgence", "id_agence"})
    private Long idAgence;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 50)
    private String ville;

    @Column(nullable = false, length = 50)
    private String adresse;

    @Column(nullable = false, length = 8)
    private Number telephone;

    @JsonIgnore
    @OneToMany (mappedBy = "agence", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employe> employees;

    @JsonIgnore
    @OneToMany (mappedBy = "agence", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vehicule> vehicules;

    public Long getId() {
        return idAgence;
    }

    public void setId(Long id) {
        this.idAgence = id;
    }
}
