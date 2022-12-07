package com.sparta.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JacksonFromObject {
    public static String convertToJson(Person p) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(p);
    }
    public static String convertToXml(Person p) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(p);
    }
}
