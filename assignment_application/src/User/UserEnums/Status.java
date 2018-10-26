package User.UserEnums;

public enum Status {
    ACTIVE("aktivan"),
    NOACTIVE("ne aktivan"),
    IDLE("idle");

    private String value;

    Status(String _value){
        this.value = _value;
    }
    public  String getValue(){
        return value;
    }
}
