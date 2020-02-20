package com.dineshkaushish.app.model;

/**
 * BerriesWebsiteScraperFactory is the concrete factory which is responsible for providing an instance of BerriesWebsiteScraper
 * Created by dineshkaushish on 19/02/2020.
 */
public class BerriesWebsiteScraperFactory extends WebsiteScraperFactory {

    public WebsiteScraper createWebsiteScraper() {
        return new BerriesWebsiteScraper();
    }
}
