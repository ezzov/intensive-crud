package web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.Customer;
import web.model.Employee;
import web.model.Position;
import web.model.Project;
import web.service.abstr.CustomerService;
import web.service.abstr.EmployeeService;
import web.service.abstr.PositionService;
import web.service.abstr.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminRestController {

    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final PositionService positionService;
    private final ProjectService projectService;

    @Autowired
    public AdminRestController(CustomerService customerService, EmployeeService employeeService,
                               PositionService positionService, ProjectService projectService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.positionService = positionService;
        this.projectService = projectService;
    }

    @ApiOperation(value = "Список всех заказчиков")
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @ApiOperation(value = "Список всех работников")
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @ApiOperation(value = "Список всех позиций")
    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.getAll();
    }

    @ApiOperation(value = "Список всех проектов")
    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.getAll();
    }

    @ApiOperation(value = "Инфомация о заказчике")
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id) {
        return customerService.getById(id);}

    @ApiOperation(value = "Инфомация о работнике")
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getById(id);}

    @ApiOperation(value = "Инфомация о позиции")
    @GetMapping("/positions/{id}")
    public Position getPositionById(@PathVariable("id") Long id) {
        return positionService.getById(id);}

    @ApiOperation(value = "Инфомация о проекте")
    @GetMapping("/projects/{id}")
    public Project getProjectById(@PathVariable("id") Long id) {
        return projectService.getById(id);}

    @ApiOperation(value = "Добавление нового заказчика")
    @PostMapping("/customers")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.save(customer); }

    @ApiOperation(value = "Добавление нового работника")
    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee); }

    @ApiOperation(value = "Добавление новой позиции")
    @PostMapping("/positions")
    public void addPosition(@RequestBody Position position) {
        positionService.save(position); }

    @ApiOperation(value = "Добавление нового проекта")
    @PostMapping("/projects")
    public void addProject(@RequestBody Project project) {
        projectService.save(project); }

    @ApiOperation(value = "Обновление заказчика")
    @PatchMapping("/customers")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.update(customer); }

    @ApiOperation(value = "Обновление работника")
    @PatchMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.update(employee); }

    @ApiOperation(value = "Обновление позиции")
    @PatchMapping("/positions")
    public void updatePosition(@RequestBody Position position) {
        positionService.update(position); }

    @ApiOperation(value = "Обновление проекта")
    @PatchMapping("/projects")
    public void updateProject(@RequestBody Project project) {
        projectService.update(project); }

    @ApiOperation(value = "Удаление заказчика из базы данных")
    @DeleteMapping("/customers/{id}")
    public void deleteCustomerById(@PathVariable("id") Long id) {
        customerService.delete(customerService.getById(id)); }

    @ApiOperation(value = "Удаление работника из базы данных")
    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.delete(employeeService.getById(id)); }

    @ApiOperation(value = "Удаление позиции из базы данных")
    @DeleteMapping("/positions/{id}")
    public void deletePositionById(@PathVariable("id") Long id) {
        positionService.delete(positionService.getById(id)); }

    @ApiOperation(value = "Удаление проекта из базы данных")
    @DeleteMapping("/projects/{id}")
    public void deleteProjectById(@PathVariable("id") Long id) {
        projectService.delete(projectService.getById(id)); }
}
