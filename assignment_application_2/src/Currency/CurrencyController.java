package Currency;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import Currency.Currency;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CurrencyController {
    private static CurrencyController ourInstance = new CurrencyController();

    public static CurrencyController getInstance() {
        return ourInstance;
    }

    private List<String> entityKeys;
    private String urlData;
    private List<Currency> currencies;
    private JSONParser parser;

    private void addCurrency(Currency currency){
        currencies.add(currency);
    }

    private CurrencyController() {
        entityKeys = new ArrayList<String>();
        currencies = new ArrayList<Currency>();
        parser = new JSONParser();

        //entityKeys.add("Broj tečajnice");
        //entityKeys.add("Datum primjene");
        //entityKeys.add("Država");
        //entityKeys.add("Valuta");
        //entityKeys.add("Jedinica");
        //entityKeys.add("Kupovni za devize");
        //entityKeys.add("Srednji za devize");
        //entityKeys.add("Prodajni za devize");

    }

    public void importCurrencies(String url){
        urlData = url;

        try{
            URL urlObject = new URL(urlData);
            URLConnection request;
            request = urlObject.openConnection();
            request.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine = "";
            Currency currency = new Currency();
            while ((inputLine = in.readLine()) != null) {
                JSONArray a = (JSONArray) parser.parse(inputLine);

                for (Object o : a) {
                    JSONObject jsonObject = (JSONObject) o;

                    currency.setCurrencyNum(new BaseEntity("Broj tečajnice", (String) jsonObject.get("Broj tečajnice"), null));
                    currency.setDate(new BaseEntity("Datum primjene", (String) jsonObject.get("Datum primjene"), null));
                    currency.setState(new BaseEntity("Država", (String) jsonObject.get("Država"), null));
                    currency.setCurrencyCode(new BaseEntity("Valuta", (String) jsonObject.get("Valuta"), null));
                    currency.setUnit(new BaseEntity("Jedinicae", (Long) jsonObject.get("Jedinica")));
                    currency.setCurrencyForBuy(new BaseEntity("Kupovni za devize", (String) jsonObject.get("Kupovni za devize"), null));
                    currency.setMiddleForCurrency(new BaseEntity("Srednji za devize", (String) jsonObject.get("Srednji za devize"), null));
                    currency.setSellForCurrency(new BaseEntity("Prodajni za devize", (String) jsonObject.get("Prodajni za devize"), null));

                    addCurrency(currency);
                }
            }

            in.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void printCurrencies(){
        for (Currency currency : currencies) {
            System.out.println(currency.toString());
        }
    }
}
