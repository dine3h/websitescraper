package com.dineshkaushish.app.model;

/**
 * This class is a base class for all WebsiteScraper concrete factories,
 * which the client class will produce as a compile time declaration and any concrete factories
 * as a runtime declaration
 *
 * Created by dineshkaushish on 19/02/2020.
 */
public abstract class WebsiteScraperFactory {

    private WebsiteScraper websiteScraper;

    public void createInstance(){
        websiteScraper = createWebsiteScraper();
    }

    public abstract WebsiteScraper createWebsiteScraper();
}

