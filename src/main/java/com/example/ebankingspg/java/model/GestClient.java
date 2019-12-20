package com.example.ebankingspg.java.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GestClient extends User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gestclient_seq")
    @SequenceGenerator(name = "gestclient_seq", sequenceName = "gestclient_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agencyId")
    @JsonBackReference
    private Agency agency;

    @Builder
    public GestClient(Long id, String password, String firstname, String lastname, String email, String numtel, boolean isValid, String adress, String status, String token, Set<Role> roles, Agency agency) {
        super(id, password, firstname, lastname, email, numtel, isValid, adress, status, token, roles);
        this.agency = agency;
    }

    public GestClient(String firstname, String lastname, String numtel, String email, String adress, String password){
        super(firstname, lastname, numtel, email , adress, password);
    }



}
