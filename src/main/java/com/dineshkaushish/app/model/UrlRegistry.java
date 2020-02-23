package com.dineshkaushish.app.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by dineshkaushish on 23/02/2020.
 */
public class UrlRegistry {

    private static UrlRegistry instance;

    private Map<String, String> urlLookupMap = new HashMap<>();

    private UrlRegistry(){
        urlLookupMap.put("Cherries and Berries", "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html?language=Java");
    }

    public static UrlRegistry getInstance(){
        if(instance == null){
            instance = new UrlRegistry();
        }

        return instance;
    }

    public Optional<String> fetchUrlLink(String productCategory){
        return Optional.of(urlLookupMap.get(productCategory));
    }
}
