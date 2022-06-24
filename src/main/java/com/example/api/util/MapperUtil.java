package com.example.api.util;

import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperUtil {

    private final ModelMapper modelMapper = new ModelMapper();

    public <D> D convertTo(Object bean, Class<D> dto){
        return modelMapper.map(bean, dto);
    }

    public <S,T> List<T> mapList(@NotNull List<S> source, Class<T> target){
        return source.stream().map(element -> modelMapper.map(element, target)).collect(Collectors.toList());
    }
}