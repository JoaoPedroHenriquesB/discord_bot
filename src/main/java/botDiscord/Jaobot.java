package botDiscord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Jaobot extends ListenerAdapter {
    public static void main(String[] args) {
        String token = System.getenv("DISCORD_BOT_TOKEN");
		if (token == null || token.isEmpty()) {
		    System.out.println("defina a variável de ambiente.");
		    return;
		}


		JDA jda = JDABuilder.createDefault(token)
		        .enableIntents(GatewayIntent.MESSAGE_CONTENT)
		        .addEventListeners(new Jaobot())
		        .build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) {
            return;
        }


        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannelUnion channel = event.getChannel();

        if (content.equalsIgnoreCase("!ping")) {
            channel.sendMessage("Pong!").queue();
        }
        
        if (content.equalsIgnoreCase("!treze")) {
            channel.sendMessage("Esse treze é um Ganso mesmo.").queue();
        }

        if (content.equalsIgnoreCase("!hello")) {
            String user = event.getAuthor().getName();
            channel.sendMessage("Olá, " + user + "!").queue();
        }
        
        if (content.equalsIgnoreCase("!java")) {
            channel.sendMessage("Eu vou bater o recorde de codar em java, vou ser o homen que mais coda em java no globo terrestre!").queue();
        }

        if (content.equalsIgnoreCase("!help")) {
            String helpMessage = "**Comandos disponíveis:**\n"
                    + "`!ping` - Responde com 'Pong!'\n"
                    + "`!hello` - Diz olá para você\n"
                    + "`!help` - Mostra esta mensagem de ajuda";
            channel.sendMessage(helpMessage).queue();
        }
        
        else {
			channel.sendMessage("Comando inválido, digite !help para ver os comandos.");
		}
    }
}