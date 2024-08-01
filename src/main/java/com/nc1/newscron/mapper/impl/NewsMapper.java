package com.nc1.newscron.mapper.impl;

import com.nc1.newscron.dto.NewsDto;
import com.nc1.newscron.entity.News;
import com.nc1.newscron.mapper.DataMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Maps between NewsDto and News entities using MapStruct.
 */
@Mapper(componentModel = "spring")
public abstract class NewsMapper implements DataMapper<NewsDto, News> {

  @Mapping(target = "id", ignore = true)
  public abstract News toEntity(NewsDto dto);

  @Mapping(target = "id", ignore = true)
  public abstract News updateEntity(NewsDto dto, @MappingTarget News entity);
}
