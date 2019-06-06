package pl.coderslab.carRefueling;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.carData.CarData;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Entity
@Table(name = "carRefueling")
public class CarRefueling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private CarData carData;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date; //data

    @NotBlank
    private String howManyLiters; // ile litrów zatankowano

    private String fuelType; // rodzaj paliwa

    private double total; // kwota za paliwo

    public CarRefueling() {
    }

    public CarRefueling(CarData carData, LocalDate date, @NotBlank String howManyLiters, String fuelType, double total) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    @Override
    public String toString() {
        return "CarRefueling{" +
                "id=" + id +
                ", carData=" + carData +
                ", date=" + date +
                ", howManyLiters='" + howManyLiters + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", total=" + total +
                '}';
    }
}
