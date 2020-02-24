package com.dineshkaushish.app.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This class represents a registry for URL links for web scraping according to
 * the requirements of user input. In this example, a class is used as a cache for URL links
 * but in a more practical example perhaps a database call or storage in a properties file is more appropriate.
 *
 * @Author Dinesh Kaushish
 * @Version 1.0
 * Date: 19/02/19
 * Created by dineshkaushish on 23/02/2020.
 */
public class UrlRegistry {

    private static UrlRegistry instance;

    private Map<String, String> urlLookupMap = new HashMap<>();

    /**
     * A constructor which initialises the hashmap for url lookup
     */
    private UrlRegistry(){
        urlLookupMap.put("Cherries and Berries", "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html?language=Java");
    }

    /**
     * Provides an instance of Url Registry
     * @return UrlRegistry Singleton Class
     */
    public static UrlRegistry getInstance(){
        if(instance == null){
            instance = new UrlRegistry();
        }

        return instance;
    }

    /**
     * Fetches corresponding URL link according to Hashmap key.
     * @param productCategory
     * @return Optional<String> of URL link
     */
    public Optional<String> fetchUrlLink(String productCategory){
        return Optional.of(urlLookupMap.get(productCategory));
    }
}
