import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Cars {
    Car car;
    public Cars(String model, int year, float motorVolume, int mileage) {
        this.car = new Car();
        this.car.model = model;
        this.car.year = year;
        this.car.motorVolume = motorVolume;
        this.car.mileageStart = mileage;

        this.car.money = new ArrayList<Integer>();
        this.car.liter = new ArrayList<Integer>();
        this.car.mileage = new ArrayList<Integer>();
    }

    public void addFuel(int money, int liter, int mileage) {
        this.car.money.add(money);
        this.car.liter.add(liter);
        this.car.mileage.add(mileage);
    }

    private int sum( ArrayList<Integer> arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        return sum;
    }

    public double calcFuelСonsumption() {
        int mileage = this.car.mileage.get( this.car.mileage.size() - 1 ) - this.car.mileageStart;
        double fuel = this.sum(this.car.liter);
        return (fuel / mileage) * 100;
    }

    public int sumMoney() {
        return this.sum(this.car.money);
    }

    public Car getCar(){
        return this.car;
    }
}
