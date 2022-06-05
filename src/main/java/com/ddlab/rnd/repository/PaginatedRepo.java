package com.ddlab.rnd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.Tutorial;

@Repository
public interface PaginatedRepo extends PagingAndSortingRepository<Tutorial, Long> {

	@Query(value = "SELECT * FROM tutorials WHERE title = ?1",
			countQuery = "SELECT count(*) FROM tutorials WHERE title = ?1",
			nativeQuery = true)
	Page<Tutorial> getInfoByTitle(String title, Pageable pageable);
	
	Page<Tutorial> findByTitle(String title, Pageable pageable);
}
