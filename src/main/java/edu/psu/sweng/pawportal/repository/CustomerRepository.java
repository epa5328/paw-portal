package edu.psu.sweng.pawportal.repository;

import edu.psu.sweng.pawportal.models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    //This helps with repository search when a user is logging in
    @Query("SELECT u FROM Customer u WHERE u.email = ?1")
    Customer findByEmail(String email);
}
