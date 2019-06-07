package pl.coderslab.carHistory;

import pl.coderslab.carData.CarData;
import pl.coderslab.user.User;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "carHistory")
public class CarHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CarData carData;

    @NotBlank
    private String event;


    private String date;

    private String howManyKmDriven;

    private double expenses;

    private String notes;

    @ManyToOne
    private User user;


    public CarHistory() {
    }

    public CarHistory(CarData carData, @NotBlank String event, String date, String howManyKmDriven, double expenses, String notes, User user) {
        this.carData = carData;
        this.event = event;
        this.date = date;
        this.howManyKmDriven = howManyKmDriven;
        this.expenses = expenses;
        this.notes = notes;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

