package com.cubic.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cubic.application.Application;
import com.cubic.entities.NewsEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class NewsServiceTest {
	
	@Autowired
	private NewsService newsService;
	
	private NewsEntity newsEntity;
	
	@Before
	public void setup() {
		newsEntity = new NewsEntity();
		newsEntity.setCreatorName("Abinash");
		newsEntity.setContent("This is the content");
	}
	
	@Test
	public void testCalculateTax() {
		
		// mockito mvc contoller
		Assert.assertEquals(1400, newsService.calculateTax(20000));
		Assert.assertEquals(6150, newsService.calculateTax(60000));
		Assert.assertEquals(3150, newsService.calculateTax(45000));
		Assert.assertEquals(0, newsService.calculateTax(0));
	}
	
	@Test
	public void testNewsByCreator() throws JsonProcessingException {
		// test cases 1. there is no news for that creator, 2. there is list of news for a creator
		String expectedJson = "[{\"title\":\"This is my second news\",\"content\":\"NewYork — asdadasdsadfasdfasdfasf sfsaf asfasf asfaf afaf af\","
				+ "\"creatorName\":\"Abinash Bastola\",\"tags\":[\"newyork\",\"usa\",\"new york times\"],\"createdAt\":1540858560000},"
				+ "{\"title\":\"This is my partner news- fox news\",\"content\":\"I am greatest partner ever\",\"creatorName\":\"Abinash Bastola\","
				+ "\"tags\":[\"pittsburg\",\"shooting\",\"new york times\"],\"createdAt\":1541029125000},"
				+ "{\"title\":\"This is my first news\",\"content\":\"PITTSBURGH — Wearing a sweatshirt and sweatpants, shackled and with a vacant expression, Robert Bowers sat before a federal judge in a downtown courtroom on Monday afternoon. Mr. Bowers, the man accused of killing 11 congregants in a hate-filled attack on a Pittsburgh synagogue named Tree of Life, arrived in a wheelchair pushed by a United States marshal.\",\"creatorName\":\"Abinash Bastola\",\"tags\":[\"pittsburg\",\"usa\",\"shooting\",\"new york times\"],"
				+ "\"createdAt\":1541029895000}]";
		Assert.assertEquals(expectedJson,new ObjectMapper().writeValueAsString(newsService.getAllNewsForCreator("Abinash Bastola")));
		//System.out.println(new ObjectMapper().writeValueAsString(newsService.getAllNewsForCreator("jpt")));
		Assert.assertEquals("[]",new ObjectMapper().writeValueAsString(newsService.getAllNewsForCreator("jpt")));
	}
	
	@Test
	public void testConvertNewsEntityToNewsDto() {
			Assert.assertEquals(null, newsService.convert(null));
			Assert.assertEquals("Abinash", newsService.convert(newsEntity).getCreatorName());
			//todo 100% code coverage
	}

}
