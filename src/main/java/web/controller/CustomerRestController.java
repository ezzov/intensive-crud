package web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.Customer;
import web.service.abstr.CustomerService;


import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Api(tags = {"Данные о заказчиках"})
public class CustomerRestController {

    private final CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Список всех заказчиков")
    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @ApiOperation(value = "Инфомация о заказчике")
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id) {
        return customerService.getById(id);}

    @ApiOperation(value = "Добавление нового заказчика")
    @PostMapping("/")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.save(customer); }

    @ApiOperation(value = "Обновление заказчика")
    @PatchMapping("/")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.update(customer); }

    @ApiOperation(value = "Удаление заказчика из базы данных")
    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable("id") Long id) {
        customerService.delete(id); }

}
