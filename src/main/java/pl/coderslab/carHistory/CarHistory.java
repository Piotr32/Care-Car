package pl.coderslab.carHistory;


import pl.coderslab.carData.CarData;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Table(name = "carHistory")
public class CarHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CarData carData;

    @NotBlank
    private String event; // wydarzenie;


    private String date; // data wydarzenia;

    private String howManyKmDriven; // ile kilometrów zostało przejechane;

    private double expenses; // wydatki

    private String notes; // notes

    public CarHistory() {
    }

    public CarHistory(CarData carData, @NotBlank String event, String date, String howManyKmDriven, double expenses, String notes) {
        this.carData = carData;
        this.event = event;
        this.date = date;
        this.howManyKmDriven = howManyKmDriven;
        this.expenses = expenses;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarData getCarData() {
        return carData;
    }

    public void setCarData(CarData carData) {
        this.carData = carData;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHowManyKmDriven() {
        return howManyKmDriven;
    }

    public void setHowManyKmDriven(String howManyKmDriven) {
        this.howManyKmDriven = howManyKmDriven;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

