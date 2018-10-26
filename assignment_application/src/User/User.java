package User;

import UserEnums.Gender;
import UserEnums.Status;

public class User extends BaseUser {

    public User(){
        this.setNameAndSurName("");
        this.setAdress("");
        this.setAge(0);
        this.setCompanyName("");
        this.seteMailAdress("");
        this.setFinancialStatus(0);
        this.setGender(Gender.NONE);
        this.setId(0);
    }

    public User(int _id, Status _status, float _financialStatus, int _age, String _nameAndSurName, Gender _gender, String _companyName, String _email, String _telephoneNumber, String _adress){

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

}
