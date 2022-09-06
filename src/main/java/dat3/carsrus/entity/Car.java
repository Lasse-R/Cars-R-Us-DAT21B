package dat3.carsrus.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Car{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int pricePerDay;

    @Column(nullable = false)
    private int bestDiscount;

    @CreationTimestamp
    @Column(name = "created")
    private LocalDateTime timeCreated;

    @UpdateTimestamp
    @Column(name = "edited")
    private LocalDateTime timeEdited;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public void addReservation (Reservation reservation){
        reservations.add(reservation);
        reservation.setCar(this);
    }

    public Car(String brand, String model, int pricePerDay, int bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.bestDiscount = bestDiscount;
    }

    public Car(int id, String brand, String model, int pricePerDay, int bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.bestDiscount = bestDiscount;
    }

    public int getId() {
        return id;
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

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getBestDiscount() {
        return bestDiscount;
    }

    public void setBestDiscount(int bestDiscount) {
        this.bestDiscount = bestDiscount;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public LocalDateTime getTimeEdited() {
        return timeEdited;
    }

    public void setTimeEdited(LocalDateTime timeEdited) {
        this.timeEdited = timeEdited;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", bestDiscount=" + bestDiscount +
                '}';
    }
}
