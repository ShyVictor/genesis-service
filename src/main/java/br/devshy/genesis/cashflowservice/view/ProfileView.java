package br.devshy.genesis.cashflowservice.view;


import br.devshy.genesis.cashflowservice.model.Account;
import br.devshy.genesis.cashflowservice.view.model.DiscordViewImp;
import net.dv8tion.jda.api.entities.Member;

public class ProfileView extends DiscordViewImp {
    public ProfileView(Account account) {
        this.setAuthor(account.getName());
        this.setDescription(account.getPassword());
    }

}
