package com.example.k_dish.model.serializer;

import com.example.k_dish.model.dto.DishDto;
import com.example.k_dish.model.entity.Dish;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class DishDtoS extends StdSerializer<Set<Dish>> {

    public DishDtoS() {
        this(null);
    }

    public DishDtoS(Class<Set<Dish>> t) {
        super(t);
    }

    @Override
    public void serialize(Set<Dish> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        Set<DishDto> dtoSet = value.stream().map(dish -> {
            DishDto dto = new DishDto();
            dto.setId(dish.getId());
            dto.setName(dish.getName());
            dto.setCost(dish.getCost());
            return dto;
        }).collect(Collectors.toSet());
        gen.writeObject(dtoSet);
    }
}
