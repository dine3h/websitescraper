package com.dineshkaushish.app.model;

/**
 * BerriesWebsiteScraperFactory is the concrete factory which is responsible for providing an instance of BerriesWebsiteScraper
 *
 * @Author Dinesh Kaushish
 * @Version 1.0
 * Date: 19/02/2020.
 */
public class BerriesWebsiteScraperFactory extends WebsiteScraperFactory {

    /**
     * Creates an instance for class BerriesWebsiteScraper
     * @return a runtime instance of BerriesWebsiteScraper
     */
    public WebsiteScraper createWebsiteScraper() {
        return new BerriesWebsiteScraper();
    }
}
