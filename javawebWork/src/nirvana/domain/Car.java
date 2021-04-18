package nirvana.domain;

import java.util.List;

/**
 * @author YJL
 */
public class Car{
    private int id;
    private Integer seat;
    private String brand;
    private int perRent;
    private String type;
    private String number;
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPerRent() {
        return perRent;
    }

    public void setPerRent(int perRent) {
        this.perRent = perRent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Car() {
    }

    public Car(int id, Integer seat, String brand, int perRent, String type, String number,String model) {
        this.id = id;
        this.seat = seat;
        this.brand = brand;
        this.perRent = perRent;
        this.type = type;
        this.number = number;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", seat=" + seat +
                ", brand='" + brand + '\'' +
                ", perRent=" + perRent +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
