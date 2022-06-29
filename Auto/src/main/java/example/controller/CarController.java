package example.controller;

import example.domain.Mark;
import example.domain.Model;
import example.domain.Modific;
import example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/mark")
    private List getAllMarks() {
        return carService.getAllFindMark();
    }

    @GetMapping("/findMarkById/{id}")
    private Mark findMarkById(@PathVariable("id") long id) {
        return carService.getMarkById(id);
    }

    @GetMapping("/findModelByIdMark/{id}")
    private List findModelByIdMark(@PathVariable("id") long id) {
        return carService.getModelByIdM(id);
    }

    @GetMapping("/findModelById/{id}")
    private Model findModelById(@PathVariable("id") long id) {
        return carService.getModelById(id);
    }

    @GetMapping("/findModificByIdModel/{id}")
    private List findModificByIdModel(@PathVariable("id") long id) {
        return carService.getModificByIdM(id);
    }

    @GetMapping("/findModificById/{id}")
    private Modific findModificById(@PathVariable("id") long id) {
        return carService.getModificById(id);
    }

    @PostMapping("/mark")
    private void  addMark(@RequestParam(value = "name", defaultValue = "null") String name, @RequestParam(value = "caption", defaultValue = "null") String caption, @RequestParam(value = "active", defaultValue = "null") Boolean active) {
        carService.getMark(name, caption, active);
    }

    @PostMapping("/mark/{id}/model")
    private void  addModel(@RequestParam(value = "name", defaultValue = "null") String name, @RequestParam(value = "caption", defaultValue = "null") String caption, @RequestParam(value = "active", defaultValue = "null") Boolean active, @PathVariable("id") long id_mark) {
        carService.getModel(name, caption, active,id_mark);
    }

    @PostMapping("/model/{id}/modific")
    private void  addModific(@RequestParam(value = "name", defaultValue = "null") String name, @RequestParam(value = "caption", defaultValue = "null") String caption, @RequestParam(value = "active", defaultValue = "null") Boolean active, @PathVariable("id") long id_model) {
        carService.getModific(name, caption, active,id_model);
    }

}
