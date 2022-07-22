package edu.psu.sweng.pawportal.repository;

import edu.psu.sweng.pawportal.models.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
