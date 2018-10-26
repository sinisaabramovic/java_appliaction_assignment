package User;
import java.util.Locale;

import User.UserEnums.Gender;
import User.UserEnums.Status;
import User.UserSubClass.Account;
import User.UserSubClass.Adress;
import User.UserSubClass.Age;
import User.UserSubClass.Name;

public class User extends BaseUser {

    public User(){
        this.setNameAndSurName(new Name());
        this.setAdress(new Adress());
        this.setAge(new Age(0,""));
        this.setCompanyName("");
        this.seteMailAdress("");
        this.setFinancialStatus(new Account("HRK", "0.0"));
        this.setGender(Gender.NONE);
        this.setId(0);
        this.setStatus(Status.IDLE);
    }

    public User(int _id, Status _status, Account _financialStatus, Age _age, Name _nameAndSurName, Gender _gender, String _companyName, String _email, String _telephoneNumber, Adress _adress){

        this.setId(_id);
        this.setStatus(_status);
        this.setFinancialStatus(_financialStatus);
        this.setAge(_age);
        this.setNameAndSurName(_nameAndSurName);
        this.setGender(_gender);
        this.setCompanyName(_companyName);
        this.seteMailAdress(_email);
        this.setTelephoneNumber(_telephoneNumber);
        this.setAdress(_adress);

    }

    public boolean insertKeyValue(String key, String value){
        switch (key){
            case "id":
                try {
                    this.setId(Integer.parseInt(value));
                }catch (Exception ex){
                    System.out.println("Error in parse " + key);
                    System.out.println(ex.toString());
                    return false;
                }
                break;
            case "dob":
                try {
                    String[] parts = value.split(" ");
                    this.setAge(new Age(Integer.parseInt(parts[0]), parts[1]));
                }catch (Exception ex){
                    System.out.println("Error in parse " + key);
                    System.out.println(ex.toString());
                    return false;
                }
                break;
            case "stanje":
                try {
                    String[] financialStatusValue = value.split(" ");
                    this.setFinancialStatus(new Account(financialStatusValue[1], financialStatusValue[0]));
                }catch (Exception ex){
                    System.out.println("Error in parse " + key);
                    System.out.println(ex.toString());
                    return false;
                }
                break;
            case "status":
                try {
                    Status status = Status.IDLE;
                    if(value == "aktivan"){
                        status = Status.ACTIVE;
                    }else if(value == "ne aktivan"){
                        status = Status.NOACTIVE;
                    }else {
                        status = Status.IDLE;
                    }
                    this.setStatus(status);
                }catch (Exception ex){
                    System.out.println("Error in parse " + key);
                    System.out.println(ex.toString());
                    return false;
                }
                break;
            case "naziv":
                String[] parts = value.split(" ");
                try {
                    this.setNameAndSurName(new Name(parts[0], parts[1], parts[2]));
                }catch (Exception ex){
                    try {
                        this.setNameAndSurName(new Name(parts[0], "", parts[1]));
                    }catch (Exception exs){
                        System.out.println("Error in parse " + key);
                        System.out.println(ex.toString());
                        return false;
                    }
                }
                break;
            case "spol":
                try {
                    Gender gender = Gender.NONE;
                    if(value == "male"){
                        gender = Gender.MALE;
                    }else if(value == "female"){
                        gender = Gender.FEMALE;
                    }else {
                        gender = Gender.NONE;
                    }
                    this.setGender(gender);
                }catch (Exception ex){
                    System.out.println("Error in parse " + key);
                    System.out.println(ex.toString());
                    return false;
                }
                break;
            case "tvrtka":
                try {
                    this.setCompanyName(value);
                }catch (Exception ex){
                    System.out.println("Error in parse " + key);
                    System.out.println(ex.toString());
                    return false;
                }
                break;
            case "email":
                try {
                    this.seteMailAdress(value);
                }catch (Exception ex){
                    System.out.println("Error in parse " + key);
                    System.out.println(ex.toString());
                    return false;
                }
                break;
            case "telefon":
                try {
                    this.setTelephoneNumber(value);
                }catch (Exception ex){
                    System.out.println("Error in parse " + key);
                    System.out.println(ex.toString());
                    return false;
                }
                break;
            case "adresa":
                try {
                    String[] adressValue = value.split(",");
                    Adress adress = new Adress();
                    adress.setStreet(adressValue[0]);
                    adress.setCity(adressValue[1]);
                    adress.setState(adressValue[2]);
                    adress.setZipCode(adressValue[3]);

                    this.setAdress(adress);
                }catch (Exception ex){
                    System.out.println("Error in parse " + key);
                    System.out.println(ex.toString());
                    return false;
                }

                break;

        }

        return true;
    }

     @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        String extraSpace = " ";
        String eolStr = "\n";
        stringBuilder.append("User: " + eolStr);
        stringBuilder.append("id:" + extraSpace + getId() + eolStr);
        stringBuilder.append("status:" + extraSpace + getStatus().getValue() + eolStr);
        stringBuilder.append("stanje:" + extraSpace + getFinancialStatus().toString() + eolStr);
        stringBuilder.append("dob:" + extraSpace + getAge().toString() + eolStr);
        stringBuilder.append("naziv:" + extraSpace + getNameAndSurName().toString() + eolStr);
        stringBuilder.append("spol:" + extraSpace + getGender().getValue() + eolStr);
        stringBuilder.append("tvrtka:" + extraSpace + getCompanyName() + eolStr);
        stringBuilder.append("email:" + extraSpace + geteMailAdress() + eolStr);
        stringBuilder.append("telefon:" + extraSpace + getTelephoneNumber() + eolStr);
        stringBuilder.append("adresa:" + extraSpace + getAdress().toString() + eolStr);
        //stringBuilder.append("End of user data" + eolStr);

        return stringBuilder.toString();
    }

}
