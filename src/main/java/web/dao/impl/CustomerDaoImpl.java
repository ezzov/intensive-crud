package web.dao.impl;

import org.springframework.stereotype.Repository;
import web.dao.abtr.CustomerDao;
import web.model.Customer;

@Repository
public class CustomerDaoImpl extends AbstrDaoImpl<Customer, Long> implements CustomerDao {

}
