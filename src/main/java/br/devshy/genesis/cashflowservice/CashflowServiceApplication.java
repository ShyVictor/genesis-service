package br.devshy.genesis.cashflowservice;


import br.devshy.genesis.cashflowservice.model.Account;
import br.devshy.genesis.cashflowservice.start.CashflowService;
import br.devshy.genesis.cashflowservice.util.SerializeUtil;
import redis.clients.jedis.Jedis;

public final class CashflowServiceApplication {


    public static void main(String[] args){
        CashflowService.getApplication().startApplication();
    }

}
