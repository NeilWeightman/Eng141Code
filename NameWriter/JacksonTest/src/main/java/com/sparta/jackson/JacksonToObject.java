package com.sparta.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JacksonToObject {
    public static Person convertfromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Person.class);
    }
    public static Person convertfromXml(String xml) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(xml, Person.class);
    }
}
