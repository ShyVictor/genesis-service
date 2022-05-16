package br.devshy.genesis.cashflowservice.controller;

import br.devshy.genesis.cashflowservice.model.Account;
import br.devshy.genesis.cashflowservice.repository.AccountRepository;
import br.devshy.genesis.cashflowservice.view.factory.ViewFactory;
import br.devshy.genesis.cashflowservice.view.model.View;
import net.dv8tion.jda.api.entities.TextChannel;

public class AccountController {
    AccountRepository accountRepository;
    public AccountController(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public void showAccountProfile(TextChannel textChannel, String accountName) {
        if (accountRepository.exists(accountName)) {
            final Account account = accountRepository.getAccount(accountName);
            ViewFactory.createView(View.PROFILE_VIEW, account, textChannel);
        } else {
            ViewFactory.createView(View.PROFILE_NOT_FOUND_VIEW, textChannel);
        }
    }
}
