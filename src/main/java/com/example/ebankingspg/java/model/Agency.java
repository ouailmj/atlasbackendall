package com.example.ebankingspg.java.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Agency extends AbstractAuditableEntity<User, Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agence_seq")
    @SequenceGenerator(name = "agence_seq", sequenceName = "agence_seq", allocationSize = 1)
    private Long id;
    private String Nom;
    private String address;
    private String numtel;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private Set<Client> client;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private Set<GestClient> gestClients;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private Set<GestTransac> gestTransacs;

}
