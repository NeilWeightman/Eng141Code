package com.sparta.sakilajpa.junit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.sakilajpa.entities.Actor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

public class APITests {
    @Test
    void testGetActor(){
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();;
        Actor result = null;
        try {
            result = mapper.readValue(new URL("http://localhost:8080/sakila/actors/123"), Actor.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
        Assertions.assertEquals("JULIANNE", result.getFirstName());
    }
}
