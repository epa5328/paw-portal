package edu.psu.sweng.pawportal.repository;

import edu.psu.sweng.pawportal.models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    //This helps with repository search when a user is logging in
    @Query("SELECT u FROM Customer u WHERE LOWER(u.email) = LOWER(?1)")
    Customer findByEmail(String email);

    @Query("SELECT u FROM Customer u WHERE u.id = ?1")
    Customer findById(long id);
}
