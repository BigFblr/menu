package com.example.k_dish.model.serializer;

import com.example.k_dish.model.dto.MenuDto;
import com.example.k_dish.model.entity.Menu;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class MenuDtoS extends StdSerializer<Set<Menu>> {

    public MenuDtoS() {
        this(null);
    }

    public MenuDtoS(Class<Set<Menu>> t) {
        super(t);
    }

    @Override
    public void serialize(Set<Menu> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        Set<MenuDto> dtoSet = value.stream().map(menu -> {
            MenuDto dto = new MenuDto();
            dto.setId(menu.getId());
            dto.setName(menu.getName());
            dto.setTimeOfAction(menu.getTimeOfAction());
            return dto;
        }).collect(Collectors.toSet());
        gen.writeObject(dtoSet);
    }
}
