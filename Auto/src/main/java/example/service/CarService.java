package example.service;

import example.domain.Mark;
import example.domain.Model;
import example.domain.Modific;
import example.repository.MarkRepository;
import example.repository.ModelRepository;
import example.repository.ModificRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    MarkRepository markRepository;

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    ModificRepository modificRepository;

    public void getMark(Mark mark) {
        markRepository.save(mark);
    }

    public List getAllFindMark(){
        List marks = new ArrayList();
        markRepository.findAll().forEach(mark -> marks.add(mark));
        return marks;
    }

    public Mark getMarkById(long id){
        return markRepository.findById(id).get();
    }

    public Model getModelById(long id){
        return modelRepository.findById(id).get();
    }

    public void getModel(Model model, long id) {
        model.setMark(getMarkById(id));
        modelRepository.save(model);
    }

    public List getModelByIdM(long id){
        return getMarkById(id).getModels().stream().collect(Collectors.toList());
    }

    public void getModific(Modific modific, long id) {
        modific.setModel(getModelById(id));
        modificRepository.save(modific);
    }

    public List getModificByIdM(long id){
        return getModelById(id).getModifications().stream().collect(Collectors.toList());
    }

    public Modific getModificById(long id){
        return modificRepository.findById(id).get();
    }

}
