package User.UserSubClass;
import User.User;

import java.util.Currency;
import java.util.Locale;

public class Account {
    private Locale locale;
    private Currency currency;
    private Double amount;

    public void Account(){
        this.locale = null;
        this.currency = null;
        this.amount = 0.0;
    }

    public Account(Locale _local, Double _amount){
        this.locale = _local;
        this.amount = _amount;
        this.currency = Currency.getInstance(locale);
    }

    public Double getAmount(){
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Locale getLocale(){
        return this.locale;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString(){
        return amount.toString() + " " + currency.getCurrencyCode().toString();
    }
}
