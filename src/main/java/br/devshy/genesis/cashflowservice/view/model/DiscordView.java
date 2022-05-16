package br.devshy.genesis.cashflowservice.view.model;

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

public interface DiscordView {


    public void renderView(TextChannel textChannel);
}
