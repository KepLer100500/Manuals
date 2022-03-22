package com.epam.rd.autotasks.house;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

class HouseTest {

    @Test
    void shouldCheckGenericTypeParameters() {
        Type[] houseTypes = House.class.getTypeParameters();
        Assertions.assertEquals(1, houseTypes.length, "You must parametrize the House class");
        String houseType = houseTypes[0].getTypeName();
        try {
            Field field = House.class.getDeclaredField("residents");
            Assertions.assertEquals(field.getGenericType().getTypeName(),
                    "java.util.List<" + houseType + ">",
                    "You must parametrize the House class");
        } catch (NoSuchFieldException e) {
            Assertions.fail("'House' class should contain 'residents' field");
        }
    }
}
