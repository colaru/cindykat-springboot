package com.colaru.cindykat.domain.newsfeed;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Item {

    private String title;
    private List<Tag> description;
    private String link;
    private String picture;

    private Date pubDate;
    private String pubDateAsString;

    private String approxTraffic;
    private Long approxTrafficAsNumber;

    private List<NewsItem> items;
    private Country country;

    public Date convertStringToDate(String pubDateAsString) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z"); // Wed, 21 Dec 2016 13:00:00 +0200
        return parser.parse(pubDateAsString);
    }

    public Long convertStringToLong(String approxTraffic) {
        return new Long(approxTraffic.toString().replaceAll(",", "").replace("+", ""));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getApproxTraffic() {
        return approxTraffic;
    }

    public void setApproxTraffic(String approxTraffic) {
        this.approxTraffic = approxTraffic;
    }

    public Long getApproxTrafficAsNumber() {
        return approxTrafficAsNumber;
    }

    public void setApproxTrafficAsNumber(Long approxTrafficAsNumber) {
        this.approxTrafficAsNumber = approxTrafficAsNumber;
    }

    public List<Tag> getDescription() {
        return description;
    }

    public void setDescription(List<Tag> description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDateAsString() {
        return pubDateAsString;
    }

    public void setPubDateAsString(String pubDateAsString) {
        this.pubDateAsString = pubDateAsString;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<NewsItem> getItems() {
        return items;
    }

    public void setItems(List<NewsItem> items) {
        this.items = items;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
