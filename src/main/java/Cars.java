
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cars {

    private Map<String,Car> cars;

    public Cars() {
        this.cars = new HashMap<String, Car>();
    }

    public void addCar(String model, int year, float motorVolume, int mileage, String number ) {
        if (this.cars.containsKey(number)) {
            System.out.println("Такая тачка есть уже");
            return;
        }
        Car car = new Car();
        car.model = model;
        car.year = year;
        car.motorVolume = motorVolume;
        car.mileageStart = mileage;

        car.money = new ArrayList<Integer>();
        car.liter = new ArrayList<Integer>();
        car.mileage = new ArrayList<Integer>();

        this.cars.put(number,car);

    }

    public void addFuel(String number,int money, int liter, int mileage) {
        Car car = this.cars.get(number);
        car.money.add(money);
        car.liter.add(liter);
        car.mileage.add(mileage);
    }

    private int sum( ArrayList<Integer> arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        return sum;
    }

    public double calcFuelСonsumption(String number) {
        Car car = this.cars.get(number);
        int mileage = car.mileage.get( car.mileage.size() - 1 ) - car.mileageStart;
        double fuel = this.sum(car.liter);
        return (fuel / mileage) * 100;
    }

    public int sumMoney(Car car) {
        return this.sum(car.money);
    }

    public Car getCar(String number){
        return this.cars.get(number);
    }

    public Set<String> getNumbers() {
        return this.cars.keySet();
    }

//    public dumpCarJSON
}
