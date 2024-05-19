package com.example.k_dish.model.serializer;

import com.example.k_dish.model.dto.SpecialOfferDto;
import com.example.k_dish.model.entity.SpecialOffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class SpecialOfferDtoS extends StdSerializer<Set<SpecialOffer>> {

    public SpecialOfferDtoS() {
        this(null);
    }

    public SpecialOfferDtoS(Class<Set<SpecialOffer>> t) {
        super(t);
    }

    @Override
    public void serialize(Set<SpecialOffer> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        Set<SpecialOfferDto> dtoSet = value.stream().map(specialOffer -> {
            SpecialOfferDto dto = new SpecialOfferDto();
            dto.setId(specialOffer.getId());
            dto.setName(specialOffer.getName());
            dto.setDateOfAction(specialOffer.getDateOfAction());
            return dto;
        }).collect(Collectors.toSet());
        gen.writeObject(dtoSet);
    }
}
