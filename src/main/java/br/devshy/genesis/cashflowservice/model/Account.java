package br.devshy.genesis.cashflowservice.model;

import net.dv8tion.jda.api.entities.Member;

import java.io.Serializable;


public class Account implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getServer() {
        return server;
    }

    private String password;
    private String server;
    public Account(){

    }
    public Account(String name, String password, String server) {
        this.name = name;
        this.password = password;
        this.server = server;

    }
}
