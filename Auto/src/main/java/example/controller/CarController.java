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
    private void  addMark(@RequestBody Mark mark) {
        carService.getMark(mark);
    }

    @PostMapping("/mark/{id}/model")
    private void  addModel(@PathVariable("id") long id_mark,@RequestBody Model model) {
        carService.getModel(model,id_mark);
    }

    @PostMapping("/model/{id}/modific")
    private void  addModific(@RequestBody Modific modific, @PathVariable("id") long id_model) {
        carService.getModific( modific, id_model);
    }

}
