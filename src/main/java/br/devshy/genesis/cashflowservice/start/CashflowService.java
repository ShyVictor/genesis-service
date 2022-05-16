package br.devshy.genesis.cashflowservice.start;

import br.devshy.genesis.cashflowservice.configuration.CashflowServiceDiscordConfiguration;
import br.devshy.genesis.cashflowservice.controller.AccountController;
import br.devshy.genesis.cashflowservice.model.Account;
import br.devshy.genesis.cashflowservice.repository.AccountRepository;
import br.devshy.genesis.cashflowservice.service.DiscordService;
import br.devshy.genesis.cashflowservice.service.JedisService;
import br.devshy.genesis.cashflowservice.manager.CommandManager;
import br.devshy.genesis.cashflowservice.view.factory.ViewFactory;
import br.devshy.genesis.cashflowservice.view.model.View;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;


public class CashflowService {

    final static CashflowService INSTANCE = new CashflowService();
    final private DiscordService discordService = new DiscordService();
    final private JedisService jedisService = new JedisService();
    final private AccountRepository accountRepository = new AccountRepository();
    final private AccountController accountController = new AccountController(accountRepository);

    public static CashflowService getApplication() {
        return INSTANCE;
    }

    public void startApplication() {
        discordService.startService();
        jedisService.startService();
        accountRepository.setJedisPool(jedisService.getJedisPool());
    }

    public DiscordService getDiscordService() {
        return discordService;
    }

    public JedisService getJedisService() {
        return jedisService;
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public AccountController getAccountController() {
        return accountController;
    }
}
