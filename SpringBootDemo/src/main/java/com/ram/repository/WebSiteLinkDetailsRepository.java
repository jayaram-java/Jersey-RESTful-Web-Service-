package com.ram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.model.WebSiteLinkDetails;

public interface WebSiteLinkDetailsRepository extends JpaRepository<WebSiteLinkDetails, Integer>{
	
	List<WebSiteLinkDetails> findByName(String name);

}
