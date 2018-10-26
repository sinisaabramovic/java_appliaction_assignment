package User;
import java.util.Currency;
import java.util.Locale;

import User.UserEnums.Gender;
import User.UserEnums.Status;

public class User extends BaseUser {

    public User(){
        this.setNameAndSurName(new Name());
        this.setAdress(new Adress());
        this.setAge(0);
        this.setCompanyName("");
        this.seteMailAdress("");
        this.setFinancialStatus(new Account(Locale.US, 0.0));
        this.setGender(Gender.NONE);
        this.setId(0);
        this.setStatus(Status.IDLE);
    }

    public User(int _id, Status _status, Account _financialStatus, int _age, Name _nameAndSurName, Gender _gender, String _companyName, String _email, String _telephoneNumber, Adress _adress){

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

    /*
           "id": "_5",
           "status": "aktivan",
           "stanje": "4.271,55 HRK",
           "dob": "33 god",
           "naziv": "Juliette Lancaster",
           "spol": "female",
           "tvrtka": "QUARMONY",
           "email": "juliettelancaster@quarmony.com",
           "telefon": "+385 (809) 531-2704",
           "adresa": "339 Coffey Street, Neahkahnie, Virginia, 8640"
         */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        String extraSpace = " ";
        String eolStr = "\n";
        stringBuilder.append("User: " + eolStr);
        stringBuilder.append("id:" + extraSpace + getId() + eolStr);
        stringBuilder.append("status:" + extraSpace + getStatus().getValue() + eolStr);
        stringBuilder.append("stanje:" + extraSpace + getFinancialStatus().toString() + eolStr);
        stringBuilder.append("dob:" + extraSpace + getAge() + eolStr);
        stringBuilder.append("naziv:" + extraSpace + getNameAndSurName().toString() + eolStr);
        stringBuilder.append("spol:" + extraSpace + getGender().getValue() + eolStr);
        stringBuilder.append("tvrtka:" + extraSpace + getCompanyName() + eolStr);
        stringBuilder.append("email:" + extraSpace + geteMailAdress() + eolStr);
        stringBuilder.append("telefon:" + extraSpace + getTelephoneNumber() + eolStr);
        stringBuilder.append("adresa:" + extraSpace + getAdress().toString() + eolStr);
        stringBuilder.append("End of user data" + eolStr);

        return stringBuilder.toString();
    }

}
