package com.dineshkaushish.app.model;

import com.dineshkaushish.app.bean.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by dineshkaushish on 19/02/2020.
 */
public class BerriesWebsiteScraper extends WebsiteScraper {

    private static final String ITEM_LIST_CLASS_NAME = "productNameAndPromotions";
    private static final String DESCRIPTION_ID_TAG = "information";
    private static final String PRICE_PER_UNIT_CLASS_NAME = "pricePerUnit";

    private List<Product> productList = new LinkedList<>();

    public String scrapeWebsite(String link) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            String description = null;
            String price;
            String nutritionalInfo = null;
            String productTitle;

            Document document  = Jsoup.connect(link).get();
            Elements items = document.getElementsByClass(ITEM_LIST_CLASS_NAME);

            if(items!=null) {
                for (Element item : items) {
                    Element anchorElement = item.selectFirst("a");
                    String itemURL = anchorElement.attr("abs:href");
                    String itemText = anchorElement.text();
                    if (itemText.toLowerCase().contains("cherry") || itemText.toLowerCase().contains("cherries") ||
                            itemText.toLowerCase().contains("berry") || itemText.toLowerCase().contains("berries")) {
                        Document itemDocument = Jsoup.connect(itemURL).get();
                        Element infoSection = itemDocument.getElementById(DESCRIPTION_ID_TAG);
                        if (infoSection != null) {
                            description = infoSection.selectFirst("p").text();
                            nutritionalInfo = infoSection.getElementsByClass("nutritionTable").get(0).selectFirst("tbody").getElementsByClass("tableRow0").get(0).selectFirst("td").text();
                        }
                        productTitle = document.getElementsByClass("productTitleDescriptionContainer").get(0).selectFirst("h1").text();
                        price = document.getElementsByClass(PRICE_PER_UNIT_CLASS_NAME).get(0).text();

                        productList.add(new Product(productTitle, price, description, nutritionalInfo));
                    }
                }
                json = mapper.writeValueAsString(productList);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }
}
