package br.devshy.genesis.cashflowservice.configuration;

import br.devshy.genesis.cashflowservice.exception.CashflowServiceException;
import br.devshy.genesis.cashflowservice.start.CashflowService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CashflowServiceDiscordConfiguration {
    Properties properties;
    public CashflowServiceDiscordConfiguration(){
        this.properties = new Properties();
        try (InputStream in = CashflowService.class.getResourceAsStream("/cashflowservice.properties")) {
            properties.load(in);
        } catch (IOException e) {
            throw new CashflowServiceException(e);
        }

    }
    public String get(String key){
        return properties.getProperty(key);
    }


}
