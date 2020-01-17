package com.zipcode.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
public class AmbassadorRequest {
    //AmbassadorRequest Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @NotBlank(message = "Please enter a valid first name")
    private String firstName;
    @NotBlank(message = "Please enter a valid last name")
    private String lastName;

    //The city, state, and zip will all be in Wilmington.  We need a way to double check people are in the designated zone.

    @NotNull
    private String pickUpLocation;
    @NotBlank(message = "PLease enter a valid destination address")
    @NotNull
    private String dropOffLocation;
    @NotNull
    @NotBlank(message = "Please enter a valid phone number")
    private String phoneNumber;
    @Email
    @NotNull
    @NotBlank(message = "Please enter a valid email")
    private String email;
    private LocalDate date = LocalDate.now();
    private Long ambassadorId;



    public AmbassadorRequest() {
    }

    public AmbassadorRequest(String firstName, String lastName, String pickUpLocation, String dropOffLocation, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public AmbassadorRequest(String firstName, String lastName, String pickUpLocation, String dropOffLocation, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getAmbassadorId() {
        return ambassadorId;
    }

    public void setAmbassadorId(Long ambassadorId) {
        this.ambassadorId = ambassadorId;
    }
}
