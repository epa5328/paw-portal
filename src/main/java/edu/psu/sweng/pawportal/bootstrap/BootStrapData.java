package edu.psu.sweng.pawportal.bootstrap;

import edu.psu.sweng.pawportal.models.Customer;
import edu.psu.sweng.pawportal.models.Dog;
import edu.psu.sweng.pawportal.repository.CustomerRepository;
import edu.psu.sweng.pawportal.repository.DogRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DogRespository dogRespository;

    public BootStrapData(CustomerRepository customerRepository, DogRespository dogRespository) {
        this.customerRepository = customerRepository;
        this.dogRespository = dogRespository;
    }

    @Override
    public void run(String... args) throws Exception {
        Customer john = new Customer("John", "Johnson", "3239892345", "someGuy@skymail.com", "Timbuktu");
        Dog lily = new Dog("Lily", john, "Golden Retriever", 3, 60.0, "Golden Yellow", 1, "N/a");
        Dog sam = new Dog("Sam", john, "Pug", 1, 15.0, "Tan", 2, "Likes to lick everything");
        john.getDogs().add(lily);
        john.getDogs().add(sam);
        customerRepository.save(john);
        dogRespository.save(lily);
        dogRespository.save(sam);
        System.out.println("Testing from bootstrap");
        System.out.println("Number of customers: " + customerRepository.count());
        System.out.println("Number of dogs: " + dogRespository.count());
    }
}
