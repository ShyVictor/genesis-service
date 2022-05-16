package br.devshy.genesis.cashflowservice.view.factory;

import br.devshy.genesis.cashflowservice.model.Account;
import br.devshy.genesis.cashflowservice.view.ProfileNotFoundView;
import br.devshy.genesis.cashflowservice.view.ProfileView;
import br.devshy.genesis.cashflowservice.view.model.DiscordViewImp;
import br.devshy.genesis.cashflowservice.view.model.View;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

public class ViewFactory {
    public static void createView(View view, TextChannel textChannel){
        DiscordViewImp discordViewImp = null;
        switch (view){
            case PROFILE_NOT_FOUND_VIEW:
                discordViewImp = new ProfileNotFoundView();
                break;
        }
        discordViewImp.renderView(textChannel);
    }
    public static void createView(View view, Account account, TextChannel textChannel){
        DiscordViewImp discordViewImp = null;
        switch (view){
            case PROFILE_VIEW:
               discordViewImp = new ProfileView(account);
               break;
        }
        discordViewImp.renderView(textChannel);
    }
}
