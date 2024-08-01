package com.nc1.newscron.service;

import com.nc1.newscron.dto.NewsDto;
import com.nc1.newscron.entity.News;
import com.nc1.newscron.exception.NewsNotFoundException;
import com.nc1.newscron.mapper.DataMapper;
import com.nc1.newscron.repository.NewsRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class for managing News entities.
 */
@Service
@RequiredArgsConstructor
public class NewsService {

  private final NewsRepository newsRepository;
  private final DataMapper<NewsDto, News> newsMapper;

  /**
   * Retrieves all news and maps them to DTOs.
   *
   * @return list of NewsDto
   */
  public List<NewsDto> getAllNews() {
    return newsRepository.findAll().stream()
        .map(newsMapper::toDto)
        .toList();
  }

  /**
   * Retrieves news by ID and maps it to a DTO.
   *
   * @param id the ID of the news
   * @return NewsDto
   * @throws NewsNotFoundException if news not found
   */
  public NewsDto getNewsById(Long id) {
    return newsRepository.findById(id)
        .map(newsMapper::toDto)
        .orElseThrow(() -> new NewsNotFoundException(id));
  }

  /**
   * Saves a news entity and maps it to a DTO.
   *
   * @param dto the NewsDto to save
   * @return NewsDto
   */
  public NewsDto save(NewsDto dto) {
    News news = newsMapper.toEntity(dto);
    return newsMapper.toDto(newsRepository.save(news));
  }

  /**
   * Deletes news by ID.
   *
   * @param id the ID of the news to delete
   */
  public void deleteById(Long id) {
    newsRepository.deleteById(id);
  }
}
