/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personal.balogness.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "passenger")
@NamedQueries({
    @NamedQuery(name = "Passenger.findAll", query = "SELECT p FROM Passenger p"),
    @NamedQuery(name = "Passenger.findByGivenNames", query = "SELECT p FROM Passenger p WHERE p.givenNames = :givenNames"),
    @NamedQuery(name = "Passenger.findBySurname", query = "SELECT p FROM Passenger p WHERE p.surname = :surname"),
    @NamedQuery(name = "Passenger.findByEmailAddress", query = "SELECT p FROM Passenger p WHERE p.emailAddress = :emailAddress")})
public class Passenger implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "GivenNames")
    private String givenNames;
    @Column(name = "Surname")
    private String surname;
    @Id
    @Basic(optional = false)
    @Column(name = "EmailAddress")
    private String emailAddress;
    @ManyToMany(mappedBy = "passengerList")
    private List<Flight> flightList;

    public Passenger() {
    }

    public Passenger(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getGivenNames() {
        return givenNames;
    }

    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailAddress != null ? emailAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passenger)) {
            return false;
        }
        Passenger other = (Passenger) object;
        if ((this.emailAddress == null && other.emailAddress != null) || (this.emailAddress != null && !this.emailAddress.equals(other.emailAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.personal.balogness.model.Passenger[ emailAddress=" + emailAddress + " ]";
    }
    
}
