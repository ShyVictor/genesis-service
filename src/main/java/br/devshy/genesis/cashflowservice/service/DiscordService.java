package br.devshy.genesis.cashflowservice.service;

import br.devshy.genesis.cashflowservice.configuration.CashflowServiceDiscordConfiguration;
import br.devshy.genesis.cashflowservice.controller.AccountController;
import br.devshy.genesis.cashflowservice.manager.CommandManager;
import br.devshy.genesis.cashflowservice.start.CashflowService;
import br.devshy.genesis.cashflowservice.view.factory.ViewFactory;
import br.devshy.genesis.cashflowservice.view.model.View;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import javax.security.auth.login.LoginException;

public class DiscordService {
    final private CashflowServiceDiscordConfiguration cashflowServiceDiscordConfiguration = new CashflowServiceDiscordConfiguration();
    final private CommandManager commandManager = new CommandManager();
    final private String DISCORD_TOKEN;
    final private JDA jda = null;

    public DiscordService(){
        this.DISCORD_TOKEN = cashflowServiceDiscordConfiguration.get("DISCORD_TOKEN");
        //outras configurações
    }
    private void registerCommands() {
        commandManager.register("!search", ((member, event) ->
        {
            final TextChannel textChannel = event.getChannel();
            final String[] args = event.getMessage().getContentRaw().split(" ");
            final String accountName = args[1];
            CashflowService.getApplication().
                    getAccountController().
                    showAccountProfile(textChannel, accountName);
        }));
    }
    public void startService(){
        JDABuilder builder = JDABuilder.createDefault(DISCORD_TOKEN);
        try {
            builder.addEventListeners(commandManager);
            registerCommands();
            JDA buildJda = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public JDA getJDA() {
        return jda;
    }
    public CashflowServiceDiscordConfiguration getCashflowServiceDiscordConfiguration(){
        return cashflowServiceDiscordConfiguration;
    }
}
