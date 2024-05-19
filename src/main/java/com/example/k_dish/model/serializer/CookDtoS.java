package com.example.k_dish.model.serializer;

import com.example.k_dish.model.dto.CookDto;
import com.example.k_dish.model.entity.Cook;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class CookDtoS extends StdSerializer<Set<Cook>> {

    public CookDtoS() {
        this(null);
    }

    public CookDtoS(Class<Set<Cook>> t) {
        super(t);
    }

    @Override
    public void serialize(Set<Cook> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        Set<CookDto> dtoSet = value.stream().map(cook -> {
            CookDto dto = new CookDto();
            dto.setId(cook.getId());
            dto.setName(cook.getName());
            dto.setPhone(cook.getPhone());
            return dto;
        }).collect(Collectors.toSet());
        gen.writeObject(dtoSet);
    }
}
