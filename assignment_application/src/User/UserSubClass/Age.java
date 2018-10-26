package User.UserSubClass;

import User.User;

public class Age {
    private int age;
    private String suffix;

    public Age(){
        this.age = 0;
        this.suffix = "";
    }

    public Age(int _age, String _suffix){
        this.age = _age;
        this.suffix = _suffix;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString(){
        return age + " " + suffix;
    }
}
