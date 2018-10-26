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

        entityKeys.add("Broj tečajnice");
        entityKeys.add("Datum primjene");
        entityKeys.add("Država");
        entityKeys.add("Valuta");
        entityKeys.add("Jedinica");
        entityKeys.add("Kupovni za devize");
        entityKeys.add("Srednji za devize");
        entityKeys.add("Prodajni za devize");

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
                    BaseEntity entity = new BaseEntity();
                    JSONObject jsonObject = (JSONObject) o;

                    //for (String key : entityKeys) {
                    //    entity.key = key;
                    //    entity.value = (String) jsonObject.get(entity.key);
                    //}
                    entity.key = "Broj tečajnice";
                    entity.value = (String) jsonObject.get(entity.key);
                    currency.setCurrencyNum(entity);
                    entity.key = "Datum primjene";
                    entity.value = (String) jsonObject.get(entity.key);
                    currency.setDate(entity);
                    entity.key = "Država";
                    entity.value = (String) jsonObject.get(entity.key);
                    currency.setState(entity);
                    entity.key = "Valuta";
                    entity.value = (String) jsonObject.get(entity.key);
                    currency.setCurrencyCode(entity);
                    entity.key = "Jedinica";
                    entity.longValue = (Long) jsonObject.get(entity.key);
                    currency.setUnit(entity);
                    entity.key = "Kupovni za devize";
                    entity.value = (String) jsonObject.get(entity.key);
                    currency.setCurrencyForBuy(entity);
                    entity.key = "Srednji za devize";
                    entity.value = (String) jsonObject.get(entity.key);
                    currency.setMiddleForCurrency(entity);
                    entity.key = "Prodajni za devize";
                    entity.value = (String) jsonObject.get(entity.key);
                    currency.setSellForCurrency(entity);

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

}
