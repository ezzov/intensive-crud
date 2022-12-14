package web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.Project;
import web.service.abstr.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@Api(tags = {"Данные о проектах"})
public class ProjectRestController {

    private final ProjectService projectService;

    @Autowired
    public ProjectRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ApiOperation(value = "Список всех проектов")
    @GetMapping("/")
    public List<Project> getAllProjects() {
        return projectService.getAll();
    }

    @ApiOperation(value = "Инфомация о проекте")
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id") Long id) {
        return projectService.getById(id);}

    @ApiOperation(value = "Добавление нового проекта")
    @PostMapping("/")
    public void addProject(@RequestBody Project project) {
        projectService.save(project); }

    @ApiOperation(value = "Обновление проекта")
    @PatchMapping("/")
    public void updateProject(@RequestBody Project project) {
        projectService.update(project); }

    @ApiOperation(value = "Удаление проекта из базы данных")
    @DeleteMapping("/{id}")
    public void deleteProjectById(@PathVariable("id") Long id) {
        projectService.delete(id); }

}
