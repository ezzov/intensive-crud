package web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.Employee;
import web.service.abstr.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = {"Данные о работниках"})
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ApiOperation(value = "Список всех работников")
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @ApiOperation(value = "Инфомация о работнике")
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getById(id);}

    @ApiOperation(value = "Добавление нового работника")
    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee); }

    @ApiOperation(value = "Обновление работника")
    @PatchMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.update(employee); }

    @ApiOperation(value = "Удаление работника из базы данных")
    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.delete(id); }
}
