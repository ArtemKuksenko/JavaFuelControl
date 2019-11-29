import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class FuelControl {
    public static void main(String[] args) {
//        ObjectMapper mapper = new ObjectMapper();
        Cars car = new Cars("taz",2006,1,110000);
        car.addFuel(500,10,110100);
        car.addFuel(500,10,110200);
        car.addFuel(500,10,110300);
        System.out.println("Расход");
        System.out.println(car.calcFuelСonsumption());

        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        try {
            mapper.writeValue(writer, car.getCar());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = writer.toString();
        System.out.println(result);

        StringReader reader = new StringReader(result);
        try {
            Car car2 = mapper.readValue(reader, Car.class);
            System.out.println(car2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
