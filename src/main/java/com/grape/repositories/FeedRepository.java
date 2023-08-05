package com.grape.repositories;

import com.grape.model.Feed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
    Page<Feed> findAll(Specification<Feed> spec, Pageable pageable);
}
