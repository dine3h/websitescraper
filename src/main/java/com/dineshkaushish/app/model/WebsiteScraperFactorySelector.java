package com.dineshkaushish.app.model;

import java.util.Optional;

/**
 * Created by dineshkaushish on 23/02/2020.
 */
public class WebsiteScraperFactorySelector {

    public Optional<WebsiteScraperFactory> selectFactory(String factoryType){
        if(factoryType!=null) {
            switch (factoryType) {
                case "Cherries and Berries":
                    WebsiteScraperFactory berriesWebsiteScraperFactory = new BerriesWebsiteScraperFactory();
                    return Optional.of(berriesWebsiteScraperFactory);
                default:
                    System.out.println("A factory has not been selected");
            }
        }else{
            System.out.println("Factory type cannot be null");
        }

        return Optional.empty();
    }
}
