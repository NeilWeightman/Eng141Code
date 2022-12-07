package com.spartaglobal.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//{"name":"Archie","dob":"2015-03-05","priority":1}
//<Cat><name>Archie</name><dob>2015-03-05</dob><priority>1</priority></Cat>
public class CatDriver {
    public static void main(String[] args) {
        Cat angel = new Cat("Angel", LocalDate.of(2015, 3, 5), 0);
        System.out.println(angel);
        CatConverter conv = new CatConverter();
        try {
            System.out.println(conv.objectToJson(angel));
            System.out.println(conv.objectToXml(angel));
            System.out.println(conv.jsonToObject("{\"name\":\"Archie\",\"dob\":\"2015-03-05\",\"priority\":1}"));
            Cat archie = conv.xmlToObject("<Cat><name>Archie</name><dob>2015-03-05</dob><priority>1</priority></Cat>");
            System.out.println(archie);
            List<Cat> cats = new ArrayList<>();
            cats.add(angel);
            cats.add(archie);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(cats));
            System.out.println(
                    mapper.readValue(
                            "[{\"name\":\"Angel\",\"dob\":\"2015-03-05\",\"priority\":0},{\"name\":\"Archie\",\"dob\":\"2015-03-05\",\"priority\":1}]",
                            List.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
