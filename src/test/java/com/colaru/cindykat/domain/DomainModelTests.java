package com.colaru.cindykat.domain;

import com.colaru.cindykat.domain.newsfeed.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.*;

import static java.util.Calendar.*;

class DomainModelTests {

	private Item item;

	@BeforeEach
	void setUp() throws ParseException {

		item = new Item();
		item.setTitle("Women's World Cup 2019");

		// approx traffic
		String approxTraffic = "1,000,000+";
		item.setApproxTraffic(approxTraffic);
		item.setApproxTrafficAsNumber(item.convertStringToLong(approxTraffic));

		// pub date
		String pubDateAsString = "Mon, 10 Jun 2019 09:00:00 -0700";
		item.setPubDateAsString(pubDateAsString);
		item.setPubDate(item.convertStringToDate(pubDateAsString));

		item.setLink("https://trends.google.com/trends/trendingsearches/daily?geo=US#Women's%20World%20Cup%202019");
		item.setPicture("https://t2.gstatic.com/images?q=tbn:ANd9GcTW4UzPHNC9qjHRxBr6kCUEns71l8XK6HYcmLpJbhlfZWUbeBQPiia1GDzN3Ehl7nfD-HPbgnG_");

		// tags
		Tag tag = new Tag();
		tag.setName("Word cup");
		List<Tag> tags = new ArrayList<>();
		tags.add(tag);
		item.setDescription(tags);

		NewsItem newsItem = new NewsItem();
		// source
		Source source = new Source();
		source.setName("USA TODAY");
		newsItem.setSource(source);
		newsItem.setTitle("&lt;b&gt;2019 Women&amp;#39;s World Cup&lt;/b&gt; scores, highlights: Canada squeaks by, Japan underwhelms, Argentina gets historic point");
		List<NewsItem> items = new ArrayList<>();
		items.add(newsItem);
		item.setItems(items);

		// country
		Country country = new Country();
		country.setName("United States");
		country.setCountryCode("us");
		country.setLanguageCode("en");
		item.setCountry(country);

	}

	@Test
	void buildNewItemTest()  {
		Assert.assertEquals(1, item.getItems().size());
		Assert.assertEquals(1, item.getDescription().size());
	}

	@Test
	void convertStringToLongTest() {
		String approxTraffic = "900,000+";
		item.setApproxTraffic(approxTraffic);
		item.setApproxTrafficAsNumber(item.convertStringToLong(approxTraffic));

		Assert.assertEquals(900000, item.getApproxTrafficAsNumber().longValue());
	}

	@Test
	void convertStringToDateTest() {

		String pubDateAsString = "Mon, 1 Jun 2020 09:00:00 -0700";
		item.setPubDateAsString(pubDateAsString);
		try {
			item.setPubDate(item.convertStringToDate(pubDateAsString));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar cal = new Calendar.Builder().setCalendarType("iso8601")
				.setFields(YEAR, 2020, DAY_OF_MONTH, 1, MONTH, 5, HOUR, 18, MINUTE, 0, SECOND, 0)
				.build();
		Assert.assertEquals(cal.getTime(), item.getPubDate());
	}
}
