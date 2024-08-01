package com.nc1.newscron.mapper;

import org.mapstruct.MappingTarget;

/**
 * The interface Mapper.
 *
 * @param <D> the type parameter
 * @param <E> the type parameter
 */
public interface DataMapper<D, E> {

  E toEntity(D dto);

  D toDto(E entity);

  E updateEntity(D dto, @MappingTarget E entity);
}
