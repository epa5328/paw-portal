package edu.psu.sweng.pawportal.services;

import edu.psu.sweng.pawportal.models.Dog;
import edu.psu.sweng.pawportal.repository.DogRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogServices {
    @Autowired
    private DogRespository dogRepo;

    public void save(Dog dog) {
        dogRepo.save(dog);
    }

    public Dog get(Long id) {
        return dogRepo.findById(id).get();
    }
}
