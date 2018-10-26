package UserEnums;

public enum Gender {
    MALE("male"),
    FEMALE("female"),
    NONE("none");

    private String value;

    Gender(String _value){
        this.value = _value;
    }

    public String getValue(){
        return  value;
    }
}
