package com.nc1.newscron.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

/**
 * Data Transfer Object for news data.
 */
@Builder
@Getter
public class NewsDto {

  private String headline;
  private String description;
  private LocalDateTime publicationTime;
}
