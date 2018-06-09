package parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Currency;
import json.JsonRetriever;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denys_Hladkyi on 6/8/2018.
 */
public class MyJsonParser implements DocumentParser<List<Currency>, String> {

    @Override
    public List<Currency> parseDocument(String url) {
        JsonRetriever retriever = new JsonRetriever();
        String json = retriever.retrieveJson(url);
        List<Currency> currencies;
        currencies = getCurrency(json);
        return currencies;
    }

    private List<Currency> getCurrency(String json){
        JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();
        List<Currency> currencies = new ArrayList<>();
        JsonObject object;
        for(JsonElement jElement : jsonArray){
            object = jElement.getAsJsonObject();
            currencies.add(createCurrencyBean(object));
        }
        return currencies;
    }

    private Currency createCurrencyBean(JsonObject object){
        String currName = object.get("txt").getAsString();
        float rate = object.get("rate").getAsFloat();
        String currId = object.get("cc").getAsString();
        return new Currency(currName, rate, currId);
    }
}
