package com.cubic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cubic.entities.NewsEntity;

public interface NewsRepository extends CrudRepository<NewsEntity, Long>  {

	public List<NewsEntity> findByCreatorName(String creatorName);
	
}
