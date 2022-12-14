package web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.Position;
import web.service.abstr.PositionService;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
@Api(tags = {"Данные о позициях"})
public class PositionRestController {

    private final PositionService positionService;

    @Autowired
    public PositionRestController(PositionService positionService) {
        this.positionService = positionService;
    }

    @ApiOperation(value = "Список всех позиций")
    @GetMapping("/")
    public List<Position> getAllPositions() {
        return positionService.getAll();
    }

    @ApiOperation(value = "Инфомация о позиции")
    @GetMapping("/{id}")
    public Position getPositionById(@PathVariable("id") Long id) {
        return positionService.getById(id);}

    @ApiOperation(value = "Добавление новой позиции")
    @PostMapping("/")
    public void addPosition(@RequestBody Position position) {
        positionService.save(position); }

    @ApiOperation(value = "Обновление позиции")
    @PatchMapping("/")
    public void updatePosition(@RequestBody Position position) {
        positionService.update(position); }

    @ApiOperation(value = "Удаление позиции из базы данных")
    @DeleteMapping("/{id}")
    public void deletePositionById(@PathVariable("id") Long id) {
        positionService.delete(id); }

}
