package com.dineshkaushish.app;

import com.dineshkaushish.app.controller.WebsiteScraperController;
import com.dineshkaushish.app.model.WebsiteScraperFactorySelector;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        init();
    }

    public static void init(){
        WebsiteScraperFactorySelector websiteScraperFactorySelector = new WebsiteScraperFactorySelector();
        WebsiteScraperController websiteScraperController = new WebsiteScraperController(websiteScraperFactorySelector);
        websiteScraperController.processPage("Cherries and Berries");
    }
}
