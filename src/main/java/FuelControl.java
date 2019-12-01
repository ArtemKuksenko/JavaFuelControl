import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class FuelControl {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(FuelControl.class, args);
//        ObjectMapper mapper = new ObjectMapper();
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
        Cars cars = new Cars();
        cars.addCar("taz",2006,1,110000,"o000oo123");
        cars.addFuel("o000oo123",500,10,110100);
        cars.addFuel("o000oo123",500,10,110200);
        cars.addFuel("o000oo123",500,10,110300);
        System.out.println("Расход");
        System.out.println(cars.calcFuelСonsumption("o000oo123"));

        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        try {
            mapper.writeValue(writer, cars.getCar("o000oo123"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = writer.toString();
        System.out.println(result);

        FileWork file= new FileWork();
        try {
            file.writeFile("o000oo123",result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = file.readFile("o000oo123");

        StringReader reader = new StringReader(result);
        try {
            Car car2 = mapper.readValue(reader, Car.class);
            System.out.println(car2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
