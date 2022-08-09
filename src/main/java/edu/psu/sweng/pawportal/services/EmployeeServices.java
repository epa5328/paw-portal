package edu.psu.sweng.pawportal.services;

import edu.psu.sweng.pawportal.models.Employee;
import edu.psu.sweng.pawportal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepo;

    public void save(Employee employee) {
        employeeRepo.save(employee);
    }

    public Employee get(long id) {
        return employeeRepo.findById(id).get();
    }
}
