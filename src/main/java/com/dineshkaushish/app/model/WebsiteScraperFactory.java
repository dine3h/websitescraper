package com.dineshkaushish.app.model;

/**
 * This class is a base class for all WebsiteScraper concrete factories,
 * which the client class will produce as a compile time declaration and any concrete factories
 * as a runtime declaration.
 *
 * @Author Dinesh Kaushish
 * @Version 1.0
 * Date: 14/02/19
 */
public abstract class WebsiteScraperFactory {

    /**
     * Creates website scraper instance
     * @return The appropriate website scraper object according to user input.
     */
    public abstract WebsiteScraper createWebsiteScraper();
}

