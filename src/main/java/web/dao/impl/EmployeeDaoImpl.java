package web.dao.impl;


import org.springframework.stereotype.Repository;
import web.dao.abtr.EmployeeDao;
import web.model.Employee;

@Repository
public class EmployeeDaoImpl extends AbstrDaoImpl<Employee, Long> implements EmployeeDao {
}
