package br.devshy.genesis.cashflowservice.view.model;

import br.devshy.genesis.cashflowservice.configuration.CashflowServiceDiscordConfiguration;
import br.devshy.genesis.cashflowservice.start.CashflowService;
import br.devshy.genesis.cashflowservice.view.model.DiscordView;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

public class DiscordViewImp extends EmbedBuilder implements DiscordView {
    final CashflowServiceDiscordConfiguration discordConfiguration = CashflowService.getApplication().getDiscordService().getCashflowServiceDiscordConfiguration();
    final String VIEW_TITLE = discordConfiguration.get("VIEW_TITLE");
    final String VIEW_THUMBNAIL_URL = discordConfiguration.get("VIEW_THUMBNAIL");

    public DiscordViewImp() {
        this.setTitle(VIEW_TITLE);
        this.setThumbnail(VIEW_THUMBNAIL_URL);
    }

    private MessageEmbed toMessageEmbed() {
        return this.build();
    }

    @Override
    public void renderView(TextChannel textChannel) {
        textChannel.sendMessageEmbeds(this.toMessageEmbed()).queue();
    }

}
