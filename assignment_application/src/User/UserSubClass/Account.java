package User.UserSubClass;
import User.User;

import java.util.Currency;
import java.util.Locale;

public class Account {
    private String locale;
    private Currency currency;
    private String amount;

    public void Account(){
        this.locale = "";
        this.currency = null;
        this.amount = "0.0";
    }

    public Account(String _local, String _amount){
        this.locale = _local;
        this.amount = _amount;
        //this.currency = Currency.getInstance(locale);
    }

    public String getAmount(){
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getLocale(){
        return this.locale;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString(){
        return amount.toString() + " " + locale;
    }
}
