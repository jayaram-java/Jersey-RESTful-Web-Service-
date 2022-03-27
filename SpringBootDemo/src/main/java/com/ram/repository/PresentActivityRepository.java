package com.ram.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.model.PresentActivity;

@Repository
public interface PresentActivityRepository extends JpaRepository<PresentActivity, Long> {
	
	
	
	Optional<PresentActivity> findById(Long id);
	

}
