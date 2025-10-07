package domain;

public class categoryDomain {
    
    private int categoryId;
    private String categoryName;

    public categoryDomain(){
    }

    public categoryDomain(int id, String name) {
        this.categoryId = id;
        this.categoryName = name;

    }

    public int getCategoryId(){
        return categoryId;
    };

    public String getCategoryName(){
        return categoryName;
    };

    public void setCategoryId(int id){
        this.categoryId = id;
    };

    public void setCategoryName(String name){
        this.categoryName = name;
    };

    @Override
    public String toString() {
        return "ID: " + categoryId + " | Nombre: " + categoryName;
    }

}
