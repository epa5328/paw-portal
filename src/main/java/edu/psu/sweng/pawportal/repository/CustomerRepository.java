package edu.psu.sweng.pawportal.repository;

import edu.psu.sweng.pawportal.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
