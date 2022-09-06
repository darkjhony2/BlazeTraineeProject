package com.jquezada.blazetraineeproject.web.app.services.Impl;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Employee;
import com.jquezada.blazetraineeproject.web.app.repositories.EmployeeRepository;
import com.jquezada.blazetraineeproject.web.app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee findByUsername(String username) {
        Employee employee = null;
        try {
            employee = employeeRepository.findByUsername(username).orElse(null);
        } catch (Exception e){
            e.printStackTrace();
        }
        return employee;
    }
}
