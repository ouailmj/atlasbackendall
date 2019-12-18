package com.example.ebankingspg.java.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account extends AbstractAuditableEntity<User,Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_seq", allocationSize = 1)
    private Long id;
    private String rib;
    private double balance;
    private String typeaccount;
    private String blockedbalance;
    private Boolean accountvalidated;
    private Date activation_date;
    private Date desactivation_date;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Transaction> transaction;

    @JsonManagedReference
    @OneToOne(mappedBy="accountTarget",fetch = FetchType.LAZY,
              cascade =  CascadeType.ALL)
    private Transaction transactionTarget;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonBackReference
    private Client client;


    @ManyToOne
    @JoinColumn(name = "typecontratId")
    @JsonBackReference
    private TypeContrat typecontrat;


    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the rib
     */
    public String getRib() {
        return rib;
    }

    /**
     * @param rib the rib to set
     */
    public void setRib(String rib) {
        this.rib = rib;
    }

    /**
     * @return double return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return String return the typeaccount
     */
    public String getTypeaccount() {
        return typeaccount;
    }

    /**
     * @param typeaccount the typeaccount to set
     */
    public void setTypeaccount(String typeaccount) {
        this.typeaccount = typeaccount;
    }

    /**
     * @return String return the blockedbalance
     */
    public String getBlockedbalance() {
        return blockedbalance;
    }

    /**
     * @param blockedbalance the blockedbalance to set
     */
    public void setBlockedbalance(String blockedbalance) {
        this.blockedbalance = blockedbalance;
    }

    /**
     * @return Boolean return the accountvalidated
     */
    public Boolean isAccountvalidated() {
        return accountvalidated;
    }

    /**
     * @param accountvalidated the accountvalidated to set
     */
    public void setAccountvalidated(Boolean accountvalidated) {
        this.accountvalidated = accountvalidated;
    }

    /**
     * @return Date return the activation_date
     */
    public Date getActivation_date() {
        return activation_date;
    }

    /**
     * @param activation_date the activation_date to set
     */
    public void setActivation_date(Date activation_date) {
        this.activation_date = activation_date;
    }

    /**
     * @return Date return the desactivation_date
     */
    public Date getDesactivation_date() {
        return desactivation_date;
    }

    /**
     * @param desactivation_date the desactivation_date to set
     */
    public void setDesactivation_date(Date desactivation_date) {
        this.desactivation_date = desactivation_date;
    }

    /**
     * @return Set<Transaction> return the transaction
     */
    public Set<Transaction> getTransaction() {
        return transaction;
    }

    /**
     * @param transaction the transaction to set
     */
    public void setTransaction(Set<Transaction> transaction) {
        this.transaction = transaction;
    }

    /**
     * @return Transaction return the transactionTarget
     */
    public Transaction getTransactionTarget() {
        return transactionTarget;
    }

    /**
     * @param transactionTarget the transactionTarget to set
     */
    public void setTransactionTarget(Transaction transactionTarget) {
        this.transactionTarget = transactionTarget;
    }

    /**
     * @return Client return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return TypeContrat return the typecontrat
     */
    public TypeContrat getTypecontrat() {
        return typecontrat;
    }

    /**
     * @param typecontrat the typecontrat to set
     */
    public void setTypecontrat(TypeContrat typecontrat) {
        this.typecontrat = typecontrat;
    }

}
