package edu.psu.sweng.pawportal.repository;

import edu.psu.sweng.pawportal.models.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query("SELECT u FROM Dog u WHERE u.ownerId = ?1")
    Dog[] findByOwnerId(long id);
}
