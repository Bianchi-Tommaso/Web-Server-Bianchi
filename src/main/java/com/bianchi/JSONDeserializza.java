package com.bianchi;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONDeserializza 
{
    public roott DeserializzaJSON() throws JsonParseException, JsonMappingException, IOException
    {

        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("src/main/resources/puntiVendita.json");     //Lettura File json

        
        roott value = objectMapper.readValue(file, roott.class);     //Lettura Della Root json

        return value;
    }    
}
