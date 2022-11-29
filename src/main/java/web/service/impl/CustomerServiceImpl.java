package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.abtr.CustomerDao;
import web.model.Customer;
import web.service.abstr.CustomerService;


@Service
public class CustomerServiceImpl extends AbstrServiceImpl<Customer, Long> implements CustomerService {

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        super(customerDao);
    }

}
