package com.example.ebankingspg.java.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client extends User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", sequenceName = "client_seq", allocationSize = 1)
    private Long id;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Account> account;

    @ManyToOne
    @JoinColumn(name = "agencyId")
    @JsonBackReference
    private Agency agency;

    @Builder
    public Client(String firstname, String lastname, String email, String numtel, String adress, String password,  String token, Set<Account> account, Agency agency) {
        super(firstname, lastname, email, numtel, adress, password, token);
        this.account = account;
        this.agency = agency;
    }

    @OneToMany(mappedBy = "client")
    Set<Beneficiary> beneficiaries;

}
