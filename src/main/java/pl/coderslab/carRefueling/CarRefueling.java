package pl.coderslab.carRefueling;

import pl.coderslab.carData.CarData;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "carRefueling")
public class CarRefueling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private CarData carData;

    private String date; //data

    @NotBlank
    private String howManyLiters; // ile litrów zatankowano

    private String fuelType; // rodzaj paliwa

    private double total; // kwota za paliwo

    public CarRefueling() {
    }

    public CarRefueling(CarData carData, String date, @NotBlank String howManyLiters, String fuelType, double total) {
        this.carData = carData;
        this.date = date;
        this.howManyLiters = howManyLiters;
        this.fuelType = fuelType;
        this.total = total;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHowManyLiters() {
        return howManyLiters;
    }

    public void setHowManyLiters(String howManyLiters) {
        this.howManyLiters = howManyLiters;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
