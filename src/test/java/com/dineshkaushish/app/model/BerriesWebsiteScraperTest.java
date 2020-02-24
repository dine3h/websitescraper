package com.dineshkaushish.app.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Created by dineshkaushish on 23/02/2020.
 */
@RunWith(JUnit4.class)
public class BerriesWebsiteScraperTest {

    private BerriesWebsiteScraper berriesWebsiteScraper;

    @Before
    public void init(){
        berriesWebsiteScraper = new BerriesWebsiteScraper();
    }

    @Test
    public void scrapeWebsiteTestSuccess(){
        String result = berriesWebsiteScraper.scrapeWebsite("https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html?language=Java");
        assertEquals("hello", result);
    }
}