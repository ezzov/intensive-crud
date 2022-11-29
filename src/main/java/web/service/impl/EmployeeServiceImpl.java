package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.abtr.AbstrDao;
import web.dao.abtr.EmployeeDao;
import web.model.Employee;
import web.service.abstr.EmployeeService;


@Service
public class EmployeeServiceImpl extends AbstrServiceImpl<Employee, Long> implements EmployeeService {

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        super(employeeDao);
    }
}
