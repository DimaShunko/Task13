package example.service;

import example.domain.Mark;
import example.domain.Model;
import example.domain.Modific;
import example.repository.MarkRepository;
import example.repository.ModelRepository;
import example.repository.ModificRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    MarkRepository markRepository;

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    ModificRepository modificRepository;

    public List<Model> getModelByNameAndMark(String name, Mark mark) {
        return modelRepository.findModelByNameAndMark(name, mark);
    }

    public List<Modific> getModificByNameAndMark(String name, Model model) {
        return modificRepository.findModificByNameAndModel(name, model);
    }

    public List<Modific> getModificByBeginPeriodAndMark(int beginPeriod, Model model) {
        return modificRepository.findModificByBeginPeriodAndModel(beginPeriod, model);
    }

    public List<Modific> getModificByEndPeriodAndMark(int endPeriod, Model model) {
        return modificRepository.findModificByEndPeriodAndModel(endPeriod, model);
    }

    public List<Modific> getModificByNameAndBeginPeriodAndMark(String name, int beginPeriod, Model model) {
        return modificRepository.findModificByNameAndBeginPeriodAndModel(name, beginPeriod, model);
    }

    public List<Modific> getModificByNameAndEndPeriodAndMark(String name, int endPeriod, Model model) {
        return modificRepository.findModificByNameAndEndPeriodAndModel(name, endPeriod, model);
    }

    public List<Modific> getModificByBeginPeriodAndEndPeriodAndMark(int beginPeriod, int endPeriod, Model model) {
        return modificRepository.findModificByBeginPeriodAndEndPeriodAndModel(beginPeriod, endPeriod, model);
    }

    public List<Modific> getModificByNameAndBeginPeriodAndEndPeriodAndMark(String name, int beginPeriod, int endPeriod, Model model) {
        return modificRepository.findModificByNameAndBeginPeriodAndEndPeriodAndModel(name, beginPeriod, endPeriod, model);
    }

    public Mark getMarkByName(String name) {
        return markRepository.findMarkByName(name);
    }

    public Mark getMarkByNameAndModelName(String name, String modelName) {
        Mark mark = getMarkByName(name);
        mark.setModels(null);
        mark.setModels(getModelByNameAndMark(modelName, mark));
        if (mark.getModels().size() == 0) {
            mark = null;
        }
        return mark;
    }

    public Mark getMarkByNameAndModelNameAndModificName(String name, String modelName, String modificName) {
        Mark mark = getMarkByName(name);
        mark.setModels(null);
        List<Model> models = getModelByNameAndMark(modelName, mark);

        if(models.size() != 0) {
            for (Model model : models) {
                model.setModifications(null);
                model.setModifications(getModificByNameAndMark(modificName, model));
                System.out.println(model.getModifications());
                if (model.getModifications().size() == 0) {
                    mark = null;
                } else {
                    mark.setModels(models);
                }
            }
        }else {
            mark = null;
        }

        return mark;
    }

    public Mark getMarkByNameAndModelNameAndBeginPeriod(String name, String modelName, int beginPeriod) {
        Mark mark = getMarkByName(name);
        mark.setModels(null);
        List<Model> models = getModelByNameAndMark(modelName, mark);

        if(models.size() != 0) {
            for (Model model : models) {
                model.setModifications(null);
                model.setModifications(getModificByBeginPeriodAndMark(beginPeriod, model));
                if (model.getModifications().size() == 0) {
                    mark = null;
                } else {
                    mark.setModels(models);
                }
            }
        }else {
            mark = null;
        }

        return mark;
    }

    public Mark getMarkByNameAndModelNameAndEndPeriod(String name, String modelName, int endPeriod) {
        Mark mark = getMarkByName(name);
        mark.setModels(null);
        List<Model> models = getModelByNameAndMark(modelName, mark);

        if(models.size() != 0) {
            for (Model model : models) {
                model.setModifications(null);
                model.setModifications(getModificByEndPeriodAndMark(endPeriod, model));
                if (model.getModifications().size() == 0) {
                    mark = null;
                } else {
                    mark.setModels(models);
                }
            }
        }else {
            mark = null;
        }

        return mark;
    }

    public Mark getMarkByNameAndModelNameAndModificNameAndBeginPeriod(String name, String modelName, String modificName, int beginPeriod) {
        Mark mark = getMarkByName(name);
        mark.setModels(null);
        List<Model> models = getModelByNameAndMark(modelName, mark);

        if(models.size() != 0) {
            for (Model model : models) {
                model.setModifications(null);
                model.setModifications(getModificByNameAndBeginPeriodAndMark(modificName, beginPeriod, model));
                if (model.getModifications().size() == 0) {
                    mark = null;
                } else {
                    mark.setModels(models);
                }
            }
        }else {
            mark = null;
        }

        return mark;
    }

    public Mark getMarkByNameAndModelNameAndModificNameAndEndPeriod(String name, String modelName, String modificName, int endPeriod) {
        Mark mark = getMarkByName(name);
        mark.setModels(null);
        List<Model> models = getModelByNameAndMark(modelName, mark);

        if(models.size() != 0) {
            for (Model model : models) {
                model.setModifications(null);
                model.setModifications(getModificByNameAndEndPeriodAndMark(modificName, endPeriod, model));
                if (model.getModifications().size() == 0) {
                    mark = null;
                } else {
                    mark.setModels(models);
                }
            }
        }else {
            mark = null;
        }

        return mark;
    }

    public Mark getMarkByNameAndModelNameAndBeginPeriodAndEndPeriod(String name, String modelName, int beginPeriod, int endPeriod) {
        Mark mark = getMarkByName(name);
        mark.setModels(null);
        List<Model> models = getModelByNameAndMark(modelName, mark);

        if(models.size() != 0) {
            for (Model model : models) {
                model.setModifications(null);
                model.setModifications(getModificByBeginPeriodAndEndPeriodAndMark(beginPeriod, endPeriod, model));
                if (model.getModifications().size() == 0) {
                    mark = null;
                } else {
                    mark.setModels(models);
                }
            }
        }else {
            mark = null;
        }

        return mark;
    }

    public Mark getMarkByNameAndModelNameAndModificNameAndBeginPeriodAndEndPeriod(String name, String modelName, String modoficName, int beginPeriod, int endPeriod) {
        Mark mark = getMarkByName(name);
        mark.setModels(null);
        List<Model> models = getModelByNameAndMark(modelName, mark);

        if(models.size() != 0) {
            for (Model model : models) {
                model.setModifications(null);
                model.setModifications(getModificByNameAndBeginPeriodAndEndPeriodAndMark(modoficName, beginPeriod, endPeriod, model));
                if (model.getModifications().size() == 0) {
                    mark = null;
                } else {
                    mark.setModels(models);
                }
            }
        }else {
            mark = null;
        }

        return mark;
    }
}