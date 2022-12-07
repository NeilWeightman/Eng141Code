package com.sparta.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDate;

public class JacksonRunner {
    public static void main(String[] args) {
        Person p = new Person("Archibald", LocalDate.of(2015,3,4));
        try {
            System.out.println(JacksonFromObject.convertToJson(p));
            System.out.println(JacksonFromObject.convertToXml(p));
            System.out.println(JacksonToObject.convertfromJson("{\"firstName\":\"Archibald\",\"dob\":\"2015-03-04\"}"));
            System.out.println(JacksonToObject.convertfromXml("<Person><firstName>Archibald</firstName><dob>2015-03-04</dob></Person>"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
