package Currency;

import java.util.ArrayList;
import java.util.List;
import Currency.Currency;
import org.json.simple.parser.JSONParser;

public class CurrencyController {
    private static CurrencyController ourInstance = new CurrencyController();

    public static CurrencyController getInstance() {
        return ourInstance;
    }

    private String urlData;
    private List<Currency> currencies;
    private JSONParser parser;

    private void addCurrency(Currency currency){
        currencies.add(currency);
    }

    private CurrencyController() {
        currencies = new ArrayList<Currency>();
        parser = new JSONParser();
    }
}
