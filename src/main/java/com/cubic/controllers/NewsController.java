package com.cubic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cubic.dtos.NewsDTO;
import com.cubic.service.NewsService;

@RestController
@RequestMapping(value = "/news")
public class NewsController {

	@Autowired
	private NewsService newService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public NewsDTO getNews(@PathVariable(value = "id") Long id) {
		return newService.getNewsById(id);
	}
	
//	@RequestMapping(value = "", method = RequestMethod.POST)
//	public void createNews(@RequestBody NewsDTO newsDTO) {
//		newService.saveNews(newsDTO);
//	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public void removeNews(@PathVariable(value = "id") Long id) {
//		newService.deleteNewsById(id);
//	}
//	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<NewsDTO> getNewsForCreator(@RequestParam(value = "creator") String creator) {
		return newService.getAllNewsForCreator(creator);
	}
}
