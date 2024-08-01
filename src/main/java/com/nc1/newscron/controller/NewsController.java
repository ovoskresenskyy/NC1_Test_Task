package com.nc1.newscron.controller;

import com.nc1.newscron.dto.NewsDto;
import com.nc1.newscron.service.NewsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing news.
 */
@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {

  private final NewsService newsService;

  /**
   * Retrieves all news.
   *
   * @return list of NewsDto
   */
  @GetMapping
  public List<NewsDto> getAllNews() {
    return newsService.getAllNews();
  }

  /**
   * Retrieves news by ID.
   *
   * @param id the ID of the news
   * @return NewsDto
   */
  @GetMapping("/{id}")
  public NewsDto getNewsById(@PathVariable Long id) {
    return newsService.getNewsById(id);
  }

  /**
   * Creates a new news entry.
   *
   * @param newsDto the NewsDto to create
   * @return NewsDto
   */
  @PostMapping
  public NewsDto create(@RequestBody NewsDto newsDto) {
    return newsService.save(newsDto);
  }

  /**
   * Deletes news by ID.
   *
   * @param id the ID of the news to delete
   */
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    newsService.deleteById(id);
  }
}
