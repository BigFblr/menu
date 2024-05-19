package com.example.k_dish.model.serializer;

import com.example.k_dish.model.dto.IngredientsDto;
import com.example.k_dish.model.entity.Ingredients;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class IngredientsDtoS extends StdSerializer<Set<Ingredients>> {

    public IngredientsDtoS() {
        this(null);
    }

    public IngredientsDtoS(Class<Set<Ingredients>> t) {
        super(t);
    }

    @Override
    public void serialize(Set<Ingredients> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        Set<IngredientsDto> dtoSet = value.stream().map(ingredients -> {
            IngredientsDto dto = new IngredientsDto();
            dto.setId(ingredients.getId());
            dto.setName(ingredients.getName());
            dto.setQuantity(ingredients.getQuantity());
            return dto;
        }).collect(Collectors.toSet());
        gen.writeObject(dtoSet);
    }
}
