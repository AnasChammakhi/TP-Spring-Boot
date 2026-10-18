package tn.esprit.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idClient")
    @JsonAlias({"id", "idCient", "idClient"})
    private Long idCient;

    @Column(nullable = false, length = 20)
    private String nom;

    @Column(nullable = false, length = 20)
    private String prenom;

    @Column(nullable = false, length = 20)
    @JsonProperty("email")
    @JsonAlias({"email", "elmail"})
    private String elmail;

    @Column(nullable = false, length = 8)
    private Number telephone;

    @Column(nullable = false, length = 20)
    private Number numPermis;

    @Column(nullable = false)
    private Date dateInscription;

    @JsonIgnore
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public Long getId() {
        return idCient;
    }

    public void setId(Long id) {
        this.idCient = id;
    }

    public Long getIdClient() {
        return idCient;
    }

    public void setIdClient(Long idClient) {
        this.idCient = idClient;
    }

    public String getEmail() {
        return elmail;
    }

    public void setEmail(String email) {
        this.elmail = email;
    }
}

