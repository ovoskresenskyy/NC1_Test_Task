package com.nc1.newscron.repository;

import com.nc1.newscron.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing News entities with CRUD operations.
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}
