package example.controller;

import example.domain.Mark;
import example.domain.VariantsSearch;
import example.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {

    @Autowired
    SearchService searchService;

    @PostMapping("/search")
    private Mark getAllMarks(@RequestBody VariantsSearch variantsSearch) {
        Mark mark = null;
        int count = VariantsSearch.numberNotNullObjects(variantsSearch);

        if(count == 1 && variantsSearch.getCar() != null){

            return searchService.getMarkByName(variantsSearch.getCar());

        }else if(count == 2 && variantsSearch.getCar() != null && variantsSearch.getModel() != null){

            return searchService.getMarkByNameAndModelName(variantsSearch.getCar(), variantsSearch.getModel());

        }else if(count == 3){
            if(variantsSearch.getCar() != null && variantsSearch.getModel() != null && variantsSearch.getModific() != null){
                return searchService.getMarkByNameAndModelNameAndModificName(variantsSearch.getCar(), variantsSearch.getModel(), variantsSearch.getModific());
            }

            if(variantsSearch.getCar() != null && variantsSearch.getModel() != null && variantsSearch.getBeginPeriod() != 0){
                return searchService.getMarkByNameAndModelNameAndBeginPeriod(variantsSearch.getCar(), variantsSearch.getModel(), variantsSearch.getBeginPeriod());
            }

            if(variantsSearch.getCar() != null && variantsSearch.getModel() != null && variantsSearch.getEndPeriod() != 0){
                return searchService.getMarkByNameAndModelNameAndEndPeriod(variantsSearch.getCar(), variantsSearch.getModel(), variantsSearch.getEndPeriod());
            }
        }else if(count == 4){
            if(variantsSearch.getCar() != null && variantsSearch.getModel() != null && variantsSearch.getModific() != null && variantsSearch.getBeginPeriod() != 0){
                return searchService.getMarkByNameAndModelNameAndModificNameAndBeginPeriod(variantsSearch.getCar(), variantsSearch.getModel(), variantsSearch.getModific(), variantsSearch.getBeginPeriod());
            }

            if(variantsSearch.getCar() != null && variantsSearch.getModel() != null && variantsSearch.getModific() != null && variantsSearch.getEndPeriod() != 0){
                return searchService.getMarkByNameAndModelNameAndModificNameAndEndPeriod(variantsSearch.getCar(), variantsSearch.getModel(), variantsSearch.getModific(), variantsSearch.getEndPeriod());
            }

            if(variantsSearch.getCar() != null && variantsSearch.getModel() != null && variantsSearch.getBeginPeriod() != 0 && variantsSearch.getEndPeriod() != 0){
                return searchService.getMarkByNameAndModelNameAndBeginPeriodAndEndPeriod(variantsSearch.getCar(), variantsSearch.getModel(), variantsSearch.getBeginPeriod(), variantsSearch.getEndPeriod());
            }
        }else if(count == 5){
            return searchService.getMarkByNameAndModelNameAndModificNameAndBeginPeriodAndEndPeriod(variantsSearch.getCar(), variantsSearch.getModel(), variantsSearch.getModific(), variantsSearch.getBeginPeriod(), variantsSearch.getEndPeriod());
        }else{
            return mark;
        }

        return searchService.getMarkByName(variantsSearch.getCar());
    }
}
