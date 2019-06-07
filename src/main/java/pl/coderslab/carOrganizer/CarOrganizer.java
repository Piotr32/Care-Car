package pl.coderslab.carOrganizer;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.carData.CarData;
import pl.coderslab.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "carOrganizer")
public class CarOrganizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CarData carData;

    @NotBlank
    private String event; // wydarzenie;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date; //data

    private double expenses; // wydatki

    private String notes; // notes

    @ManyToOne
    private User user;

    public CarOrganizer() {
    }

    public CarOrganizer(CarData carData, @NotBlank String event, LocalDate date, double expenses, String notes, User user) {
        this.carData = carData;
        this.event = event;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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