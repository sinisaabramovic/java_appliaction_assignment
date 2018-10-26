package Currency;

// To ensure key - value pairs for single interface property

public class BaseEntity{
    public String key;
    public String value;
    public Long longValue;

    public BaseEntity(){

    }

    public BaseEntity(String _key, String _value, Long _longValue){
        this.value = _value;
        this.key = _key;
        this.longValue = _longValue;
    }

    public BaseEntity(String _key, Long _value){
        this.value = "";
        this.key = _key;
        this.longValue = _value;
    }
}
