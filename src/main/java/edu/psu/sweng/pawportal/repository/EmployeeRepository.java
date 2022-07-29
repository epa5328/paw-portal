package edu.psu.sweng.pawportal.repository;

import edu.psu.sweng.pawportal.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
