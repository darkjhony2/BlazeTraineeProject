package com.jquezada.blazetraineeproject.web.app.services;

import com.jquezada.blazetraineeproject.web.app.domain.entity.Employee;

public interface EmployeeService {
    Employee findByUsername(String username);
}
