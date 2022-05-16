package br.devshy.genesis.cashflowservice.view;

import br.devshy.genesis.cashflowservice.model.Account;
import br.devshy.genesis.cashflowservice.view.model.DiscordViewImp;

public class ProfileNotFoundView extends DiscordViewImp {
    public ProfileNotFoundView() {
        this.setAuthor("Não existe nenhuma conta com esse nome, verifique novamente.");
    }
}
