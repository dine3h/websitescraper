package com.dineshkaushish.app.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by dineshkaushish on 23/02/2020.
 */

@RunWith(JUnit4.class)
public class WebsiteScraperFactorySelectorTest {

    private WebsiteScraperFactorySelector websiteScraperFactorySelector;

    @Before
    public void init(){
        websiteScraperFactorySelector = new WebsiteScraperFactorySelector();
    }

    @Test
    public void selectFactorySuccess() throws Exception {
        String productType = "Cherries and Berries";
        Optional<WebsiteScraperFactory> websiteScraperFactory = websiteScraperFactorySelector.selectFactory(productType);
        assertTrue(websiteScraperFactory.isPresent());
    }

    @Test
    public void selectFactoryUnexpectedArgs(){
        String productType = "Teddy Bears";
        Optional<WebsiteScraperFactory> websiteScraperFactory = websiteScraperFactorySelector.selectFactory(productType);
        assertFalse(websiteScraperFactory.isPresent());
    }

    @Test
    public void selectFactoryArgsIsNull(){
        String productType = null;
        Optional<WebsiteScraperFactory> websiteScraperFactory = websiteScraperFactorySelector.selectFactory(productType);
        assertFalse(websiteScraperFactory.isPresent());
    }


}