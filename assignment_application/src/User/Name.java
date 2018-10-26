package User;

public class Name {
    private String name;
    private String surName;
    private String middleName;

    public Name(){
        this.name = "";
        this.middleName = "";
        this.surName = "";
    }

    public Name(String _name, String _middleName, String _surName){
        this.name = _name;
        this.middleName = _middleName;
        this.surName = _surName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String toString(){
        if(this.middleName.length() == 0){
            return this.name + " " + this.surName;
        }else {
            return this.name + " " + this.middleName + " " + this.surName;
        }

    }
}
