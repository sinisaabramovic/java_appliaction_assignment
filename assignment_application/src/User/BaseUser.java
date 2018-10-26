package User;
import java.util.Currency;
import User.UserEnums.Gender;
import User.UserEnums.Status;

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
class BaseUser {

    private int id = 0;
    private Status status;
    private Account financialStatus;
    private int age = 0;
    private String nameAndSurName = "";
    private Gender gender = Gender.NONE;
    private String companyName = "";
    private String eMailAdress = "";
    private String telephoneNumber = "";
    private String Adress = "";

    public int getId() {
        return id;
    }
    public void setId(int id) {
            this.id = id;
        }
    public Status getStatus() {
            return status;
        }
    public void setStatus(Status status) {
            this.status = status;
        }
    public Account getFinancialStatus() {
            return financialStatus;
        }
    public void setFinancialStatus(Account financialStatus) {
            this.financialStatus = financialStatus;
        }
    public int getAge() {
            return age;
        }
    public void setAge(int age) {
            this.age = age;
        }
    public String getNameAndSurName() {
            return nameAndSurName;
        }
    public void setNameAndSurName(String nameAndSurName) {
            this.nameAndSurName = nameAndSurName;
        }
    public Gender getGender() {
            return gender;
        }
    public void setGender(Gender gender) {
            this.gender = gender;
    }
    public String getCompanyName() {
            return companyName;
        }
    public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }
    public String geteMailAdress() {
            return eMailAdress;
        }
    public void setAdress(String adress) {
            Adress = adress;
        }
    public String getTelephoneNumber() {
            return telephoneNumber;
        }
    public void setTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
        }
    public String getAdress() {
            return Adress;
        }
    public void seteMailAdress(String eMailAdress) {
            this.eMailAdress = eMailAdress;
        }

    public void Account(){

    }

}

