package com.dineshkaushish.app.controller;

import com.dineshkaushish.app.model.*;

import java.util.Optional;
import java.util.function.BiPredicate;

/**
 * Created by dineshkaushish on 19/02/2020.
 */
public class WebsiteScraperController {

    private WebsiteScraperFactorySelector websiteScraperFactorySelector;

    private UrlRegistry urlRegistry = UrlRegistry.getInstance();

    public WebsiteScraperController(WebsiteScraperFactorySelector websiteScraperFactorySelector) {
        this.websiteScraperFactorySelector = websiteScraperFactorySelector;
    }

    public void processPage(String productType){
        Optional<String> urlLink = urlRegistry.fetchUrlLink(productType);
        Optional<WebsiteScraperFactory> websiteScraperFactory = websiteScraperFactorySelector.selectFactory(productType);
        BiPredicate<String,WebsiteScraperFactory> predicate = (s1, wsf) -> s1!=null && wsf!=null;

        if(predicate.test(urlLink.get(), websiteScraperFactory.get())){
            WebsiteScraper websiteScraper = websiteScraperFactory.get().createWebsiteScraper();
            String result = websiteScraper.scrapeWebsite(urlLink.get());
            System.out.println(result);
        } else{
                System.out.println("No results are returned.");
        }
    }


}
