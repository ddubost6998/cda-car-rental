package fr.hb.car_rental.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "L'identifiant de l'équipe est obligatoire")
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String registration;

    @NotBlank
    private String model;

    @NotBlank
    private String brand;

    @NotBlank
    private String category;

    @NotBlank
    private String status;

    public Car() {
    }

    public Car(Long id, String registration, String model, String brand, String category, String status) {
        this.id = id;
        this.registration = registration;
        this.model = model;
        this.brand = brand;
        this.category = category;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
