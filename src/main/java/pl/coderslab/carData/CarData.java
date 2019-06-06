package pl.coderslab.carData;

import pl.coderslab.carHistory.CarHistory;

import pl.coderslab.carOrganizer.CarOrganizer;
import pl.coderslab.carRefueling.CarRefueling;
import pl.coderslab.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "carData")
public class CarData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "carData", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CarHistory> carHistory = new HashSet<>();

    @OneToMany(mappedBy = "carData", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CarRefueling> carRefueling = new HashSet<>();

    @OneToMany(mappedBy = "carData", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CarOrganizer> carOrganizer = new HashSet<>();

    private String vehicleType; // rodzaj pojazdu, do wyboru Car, Motorbike

    @NotBlank
    private String vehicleName; // nazwa pojazdu

    @NotBlank
    private String brand; // Marka

    @NotBlank
    private String model; // Model


    private String fuelType; // Rodzaj paliwa, Petrol, Diesel, Gas (LPG), Electric, Hybrid, Petrol and Gas

    @NotBlank
    @Size(max = 17)
    private String vinNo; // numer Vin

    @NotBlank
    private String oilTankCapacity; // pojemnośc zbiornika oleju;


    private String typesOfOil; // rodzaj oleju;

    // Purchase (kupno), and Sale (sprzedaż)

    private String datePurchase; // data


    private int meterStatusPurchase; // stan licznika


    private BigDecimal howMuchWasItPurchase; // ile kosztował

    private String dateSale; // data


    private int meterStatusSale; // stan licznika


    private BigDecimal howMuchWasItSale; // ile kosztował

    public CarData() {
    }

    public CarData(User user, Set<CarHistory> carHistory, Set<CarRefueling> carRefueling, String vehicleType, @NotBlank String vehicleName, @NotBlank String brand, @NotBlank String model, String fuelType, @NotBlank @Size(max = 17) String vinNo, @NotBlank String oilTankCapacity, String typesOfOil, String datePurchase, int meterStatusPurchase, BigDecimal howMuchWasItPurchase, String dateSale, int meterStatusSale, BigDecimal howMuchWasItSale) {
        this.user = user;
        this.carHistory = carHistory;
        this.carRefueling = carRefueling;
        this.vehicleType = vehicleType;
        this.vehicleName = vehicleName;
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.vinNo = vinNo;
        this.oilTankCapacity = oilTankCapacity;
        this.typesOfOil = typesOfOil;
        this.datePurchase = datePurchase;
        this.meterStatusPurchase = meterStatusPurchase;
        this.howMuchWasItPurchase = howMuchWasItPurchase;
        this.dateSale = dateSale;
        this.meterStatusSale = meterStatusSale;
        this.howMuchWasItSale = howMuchWasItSale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<CarHistory> getCarHistory() {
        return carHistory;
    }

    public void setCarHistory(Set<CarHistory> carHistory) {
        this.carHistory = carHistory;
    }

    public Set<CarRefueling> getCarRefueling() {
        return carRefueling;
    }

    public void setCarRefueling(Set<CarRefueling> carRefueling) {
        this.carRefueling = carRefueling;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getVinNo() {
        return vinNo;
    }

    public void setVinNo(String vinNo) {
        this.vinNo = vinNo;
    }

    public String getOilTankCapacity() {
        return oilTankCapacity;
    }

    public void setOilTankCapacity(String oilTankCapacity) {
        this.oilTankCapacity = oilTankCapacity;
    }

    public String getTypesOfOil() {
        return typesOfOil;
    }

    public void setTypesOfOil(String typesOfOil) {
        this.typesOfOil = typesOfOil;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public int getMeterStatusPurchase() {
        return meterStatusPurchase;
    }

    public void setMeterStatusPurchase(int meterStatusPurchase) {
        this.meterStatusPurchase = meterStatusPurchase;
    }

    public BigDecimal getHowMuchWasItPurchase() {
        return howMuchWasItPurchase;
    }

    public void setHowMuchWasItPurchase(BigDecimal howMuchWasItPurchase) {
        this.howMuchWasItPurchase = howMuchWasItPurchase;
    }

    public String getDateSale() {
        return dateSale;
    }

    public void setDateSale(String dateSale) {
        this.dateSale = dateSale;
    }

    public int getMeterStatusSale() {
        return meterStatusSale;
    }

    public void setMeterStatusSale(int meterStatusSale) {
        this.meterStatusSale = meterStatusSale;
    }

    public BigDecimal getHowMuchWasItSale() {
        return howMuchWasItSale;
    }

    public void setHowMuchWasItSale(BigDecimal howMuchWasItSale) {
        this.howMuchWasItSale = howMuchWasItSale;
    }
}




