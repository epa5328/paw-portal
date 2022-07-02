package edu.psu.sweng.pawportal.services;

import edu.psu.sweng.pawportal.models.Customer;
import edu.psu.sweng.pawportal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * By Kevin
 * Services will be where all of the database actions occur.
 * Updates to Customer info is handled by the save method.
 * May need to discuss how we want to set up the appointment scheduling.
 */
@Service
public class CustomerServices {
    @Autowired
    private CustomerRepository customerRepo;

    public void save(Customer customer){
        customerRepo.save(customer);
    }

    public Customer get(Long id){
        return customerRepo.findById(id).get();
    }

}
