package web.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String brand;
    private int model;
    private int year;

    public Car(String brand, int model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setName(String name) {
        this.brand = name;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
