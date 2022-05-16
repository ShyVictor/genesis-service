package br.devshy.genesis.cashflowservice.service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class JedisService {
    private final String REDIS_HOST = "localhost";
    private final Integer REDIS_PORT = 6379;
    private final JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    private final JedisPool jedisPool = new JedisPool();
    public JedisService() {
        jedisPoolConfig.setMaxTotal(128);
        jedisPoolConfig.setMaxIdle(128);
        jedisPoolConfig.setMinIdle(16);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPoolConfig.setNumTestsPerEvictionRun(3);
        jedisPoolConfig.setBlockWhenExhausted(true);
    }
    public void startService(){
        jedisPool.setConfig(jedisPoolConfig);
    }
    public JedisPool getJedisPool() {
        return this.jedisPool;
    }
}
