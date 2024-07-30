package com.nc1.newscron.mapper.impl;

import com.nc1.newscron.dto.NewsDto;
import com.nc1.newscron.entity.News;
import com.nc1.newscron.mapper.DataMapper;
import org.mapstruct.Mapper;

/**
 * Maps between NewsDto and News entities using MapStruct.
 */
@Mapper(componentModel = "spring")
public abstract class NewsMapper implements DataMapper<NewsDto, News> {

}
