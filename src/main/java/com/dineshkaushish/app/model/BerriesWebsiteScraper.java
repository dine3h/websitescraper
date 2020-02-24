package com.dineshkaushish.app.model;

import com.dineshkaushish.app.bean.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


/**
 * This class provides the core implementation of scraping the Sainsbury's Cherries and Berries webpage,
 * which is provided on Github as a test website.
 *
 * Created by dineshkaushish on 19/02/2020.
 */
public class BerriesWebsiteScraper extends WebsiteScraper {

    private static final String LIST_ITEM_CLASS_REF = "gridItem";
    private static final String DESCRIPTION_ID_TAG = "information";
    private static final String PRICE_PER_UNIT_CLASS_NAME = "pricePerUnit";

    private String description;
    private String price;

    @JsonInclude(Include.NON_NULL)
    private String nutritionalInfo;
    private String title;
    private List<Product> productList = new LinkedList<>();

    /**
     * Provides a result of description, price, nutritional info and product title in the form of JSON
     * @param link
     * @return JSON String with relevant information of products
     */
    public String scrapeWebsite(String link) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            Document document  = Jsoup.connect(link).get();
            Elements itemList = document.getElementsByClass(LIST_ITEM_CLASS_REF);         //Retrieving list of products

            if(itemList!=null) {
                if (itemList.size() != 0) {
                    for (Element item : itemList) {
                        Element anchorElement  = item.selectFirst("a");
                        String itemURL = anchorElement.attr("abs:href");
                        title = anchorElement.text();
                        if (title.toLowerCase().contains("cherry") || title.toLowerCase().contains("cherries") ||
                                title.toLowerCase().contains("berry") || title.toLowerCase().contains("berries")) {
                            Document itemDocument = Jsoup.connect(itemURL).get();
                            Element infoSection = itemDocument.getElementById(DESCRIPTION_ID_TAG);
                            Elements nutritionTable = infoSection.getElementsByClass("nutritionTable");
                            if (infoSection != null) {
                                description = infoSection.selectFirst("p").text();
                                if (nutritionTable.size()!=0){
                                    Elements nutritionalInfoTableRow = nutritionTable.get(0).selectFirst("tbody").getElementsByClass("tableRow0");
                                    if(nutritionalInfoTableRow.size()!=0) {
                                        nutritionalInfo = nutritionalInfoTableRow.get(0).selectFirst("td").text();
                                    }else{
                                        nutritionalInfo = nutritionTable.get(0).select("tr").get(2).selectFirst("td").text();
                                    }
                                }else{
                                    nutritionalInfo = "0";
                                }
                            }
                            if(nutritionalInfo.equals("0")) nutritionalInfo = null;
                            price = document.getElementsByClass(PRICE_PER_UNIT_CLASS_NAME).get(0).text();

                            productList.add(new Product(title, price, description, nutritionalInfo));
                        }
                    }
                }else{
                    System.out.println("List of items is empty");
                }
                json = mapper.writeValueAsString(productList);
            }else{
                throw new NullPointerException("List of items is null");
            }

        } catch (IOException e) {
            System.out.println("Link not found");
            e.printStackTrace();
        }

        return json;
    }
}
