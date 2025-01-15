package fr.hb.car_rental.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String drivingLicence;

    @NotNull
    @Past
    private LocalDate birthDate;

    @NotBlank
    private String gender;

    private boolean blocked;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, String drivingLicence,
                    LocalDate birthDate, String gender, boolean blocked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.drivingLicence = drivingLicence;
        this.birthDate = birthDate;
        this.gender = gender;
        this.blocked = blocked;
    }

}