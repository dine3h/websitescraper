package com.dineshkaushish.app.controller;

import com.dineshkaushish.app.model.BerriesWebsiteScraperFactory;
import com.dineshkaushish.app.model.WebsiteScraper;
import com.dineshkaushish.app.model.WebsiteScraperFactory;

/**
 * Created by dineshkaushish on 19/02/2020.
 */
public class WebsiteScraperController {

    private WebsiteScraperFactory websiteScraperFactory = new BerriesWebsiteScraperFactory();

    public void processBerriesPage(){
        WebsiteScraper websiteScraper = websiteScraperFactory.createWebsiteScraper();

    }


}
