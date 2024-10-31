package org.back.src.shared.conversor;

import org.modelmapper.ModelMapper;

public class MapperConvert {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static <D, T> D convert(T entity, Class<D> newEntityClass) {
        return modelMapper.map(entity, newEntityClass);
    }
}