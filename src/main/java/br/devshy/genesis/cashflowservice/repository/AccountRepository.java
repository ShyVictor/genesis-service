package br.devshy.genesis.cashflowservice.repository;

import br.devshy.genesis.cashflowservice.model.Account;
import br.devshy.genesis.cashflowservice.util.SerializeUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    JedisPool jedisPool;
    final static String USER_HASH = "accounts";

    public AccountRepository() {

    }
    public Boolean exists(String accountName) {
        final Jedis jedis = jedisPool.getResource();
        return jedis.hexists(USER_HASH, accountName);
    }
    public void setJedisPool(JedisPool jedisPool){
        this.jedisPool = jedisPool;
    }
    public void addAccount(Account account){
        final Jedis jedis = jedisPool.getResource();
        final String accountSerialize = SerializeUtil.serialize(account);
        jedis.hset(USER_HASH, account.getName(), accountSerialize);
    }

    public List<Account> getAllAccounts(){
        final List<Account> accountsList = new ArrayList<>();
        final Jedis jedis = jedisPool.getResource();
        jedis.hkeys(USER_HASH).forEach(key ->{
            accountsList.add(getAccount(key));
            }
        );
        return accountsList;
    }
    public void removeAccount(String accountName){
        final Jedis jedis = jedisPool.getResource();
        jedis.hdel(USER_HASH, accountName);
    }

    public Account getAccount(String accountName) {
        final Jedis jedis = jedisPool.getResource();
        final String accountSerialize = jedis.hget(USER_HASH, accountName);
        System.out.println(accountSerialize);
        final Account account = (Account) SerializeUtil.unserialize(accountSerialize);
        System.out.println(account.getName());
        return account;
    }

}
