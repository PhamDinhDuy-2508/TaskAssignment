package com.task.assignment.Services.Converter;

import java.util.function.Function;
public interface Converter<SOURCE,TARGET> {
     TARGET convertToEntity(final SOURCE source) ;
     SOURCE convertToDTO(final TARGET target) ;


}
