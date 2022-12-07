package com.spartaglobal.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class CatConverter {
    public String objectToJson(Cat cat) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(cat);
    }
    public String objectToXml(Cat cat) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(cat);
    }

    public Cat jsonToObject(String s) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(s, Cat.class);
    }

    public Cat xmlToObject(String s) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(s, Cat.class);
    }
}
