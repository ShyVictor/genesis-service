package br.devshy.genesis.cashflowservice.manager;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiConsumer;

public class CommandManager extends ListenerAdapter {

    private final Map<String, BiConsumer<Member, GuildMessageReceivedEvent>> registeredCommands = new HashMap<>();

    public void register(String command, BiConsumer<Member, GuildMessageReceivedEvent> event) {
        registeredCommands.put(command.toLowerCase(), event);
    }

    public BiConsumer<Member, GuildMessageReceivedEvent> getEventConsumer(String command) {
        return registeredCommands.get(command);
    }

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String command = event.getMessage().getContentRaw().split(" ")[0].toLowerCase(Locale.ROOT);
        if (command.startsWith("!")) {
            try {
                BiConsumer<Member, GuildMessageReceivedEvent> eventConsumer = this.getEventConsumer(command);
                if (eventConsumer == null) {
                    return;
                }
                eventConsumer.accept(event.getMember(), event);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}