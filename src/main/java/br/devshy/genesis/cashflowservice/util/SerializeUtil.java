package br.devshy.genesis.cashflowservice.util;

import br.devshy.genesis.cashflowservice.model.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class SerializeUtil {


    public static String serialize(Object object) {
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object unserialize(String json) {
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, Account.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


