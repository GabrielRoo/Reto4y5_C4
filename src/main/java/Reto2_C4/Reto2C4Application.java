package Reto2_C4;

import Reto2_C4.Interfaces.UserInterface;
import Reto2_C4.Interfaces.CleaningProductsInterface;
import Reto2_C4.Interfaces.OrderInterface;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto2C4Application implements CommandLineRunner {
        @Autowired
        private CleaningProductsInterface cleaningProductsInterface;
        @Autowired
        private UserInterface userInterface;
        @Autowired
        private OrderInterface orderInterface;
        @Autowired
        private UserInterface userRepository;
        @Autowired
        private OrderInterface orderRepository;
        @Autowired
        private MongoTemplate mongoTemplate;
        
            public static void main(String[] args) {
                    SpringApplication.run(Reto2C4Application.class, args);
	}
        @Override
        public void run (String... args) throws Exception{
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        cleaningProductsInterface.deleteAll();
        userInterface.deleteAll();
        orderInterface.deleteAll();
        }

}
