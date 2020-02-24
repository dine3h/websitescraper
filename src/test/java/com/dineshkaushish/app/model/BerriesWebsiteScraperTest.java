package com.dineshkaushish.app.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

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

    //Required to condition JSON string into Java format however no time.
    @Test
    public void scrapeWebsiteTestSuccess(){
    }

    //Required
    @Test(expected = IOException.class)
    public void scrapeWebsiteFailIOExceptionThrown(){
        String link = "Invalid link";
        berriesWebsiteScraper.scrapeWebsite(link);
    }
}