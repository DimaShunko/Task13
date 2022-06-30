package example.domain;

public class VariantsSearch {
    private String car;
    private String model;
    private String modific;
    private int beginPeriod;
    private int endPeriod;

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModific() {
        return modific;
    }

    public void setModific(String modific) {
        this.modific = modific;
    }

    public int getBeginPeriod() {
        return beginPeriod;
    }

    public void setBeginPeriod(int beginPeriod) {
        this.beginPeriod = beginPeriod;
    }

    public int getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(int endPeriod) {
        this.endPeriod = endPeriod;
    }

    public static int numberNotNullObjects(VariantsSearch variantsSearch){
        int count = 0;
        if(variantsSearch.getCar() != null){
            count++;
        }
        if(variantsSearch.getModel() != null){
            count++;
        }
        if(variantsSearch.getModific() != null){
            count++;
        }
        if(variantsSearch.getBeginPeriod() != 0){
            count++;
        }
        if(variantsSearch.getEndPeriod() != 0){
            count++;
        }

        return count;
    }
}
