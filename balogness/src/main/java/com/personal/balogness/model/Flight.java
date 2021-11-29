/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personal.balogness.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "flight")
@NamedQueries({
    @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f"),
    @NamedQuery(name = "Flight.findByFlightNumber", query = "SELECT f FROM Flight f WHERE f.flightNumber = :flightNumber"),
    @NamedQuery(name = "Flight.findByFrom", query = "SELECT f FROM Flight f WHERE f.from = :from"),
    @NamedQuery(name = "Flight.findByTo", query = "SELECT f FROM Flight f WHERE f.to = :to"),
    @NamedQuery(name = "Flight.findByDepartureDate", query = "SELECT f FROM Flight f WHERE f.departureDate = :departureDate"),
    @NamedQuery(name = "Flight.findByDepartureTime", query = "SELECT f FROM Flight f WHERE f.departureTime = :departureTime"),
    @NamedQuery(name = "Flight.findByArrivalDate", query = "SELECT f FROM Flight f WHERE f.arrivalDate = :arrivalDate"),
    @NamedQuery(name = "Flight.findByArrivalTime", query = "SELECT f FROM Flight f WHERE f.arrivalTime = :arrivalTime")})
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FlightNumber")
    private String flightNumber;
    @Column(name = "From")
    private String from;
    @Column(name = "To")
    private String to;
    @Column(name = "DepartureDate")
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    @Column(name = "DepartureTime")
    @Temporal(TemporalType.TIME)
    private Date departureTime;
    @Column(name = "ArrivalDate")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    @Column(name = "ArrivalTime")
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;
    @JoinTable(name = "booking", joinColumns = {
        @JoinColumn(name = "FlightNumber", referencedColumnName = "FlightNumber")}, inverseJoinColumns = {
        @JoinColumn(name = "EmailAddress", referencedColumnName = "EmailAddress")})
    @ManyToMany
    private List<Passenger> passengerList;
    @JoinColumn(name = "RegistrationNumber", referencedColumnName = "RegistrationNumber")
    @ManyToOne
    private Airplane registrationNumber;

    public Flight() {
    }

    public Flight(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public Airplane getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Airplane registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightNumber != null ? flightNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.flightNumber == null && other.flightNumber != null) || (this.flightNumber != null && !this.flightNumber.equals(other.flightNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.personal.balogness.model.Flight[ flightNumber=" + flightNumber + " ]";
    }
    
}
