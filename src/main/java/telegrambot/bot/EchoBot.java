package telegrambot.bot;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendContact;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import telegrambot.data.TelegramDto;
import telegrambot.model.Operacao;

import telegrambot.util.Tools;

public class EchoBot extends TelegramLongPollingBot {
		
	private static String operacao = "";

	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {

			var tlgDto = getTelegraUser(update);
			
			if (update.getMessage().getText().matches("[0-9]+")) {
								
				
			} else if (update.getMessage().getText().toLowerCase().contains("cont")) {
				var contato = sendContato(update.getMessage().getChatId().toString());
				try {
					execute(contato);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			} else if (update.getMessage().getText().toLowerCase().contains("localiz")) {
				var local = localizacao(update.getMessage().getChatId().toString());				
			} else if (update.getMessage().getText().toLowerCase().contains(Tools.removerAcentos("servico"))) {
				var mensagem = servico(update, tlgDto);
				
				try {
					execute(mensagem);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			} else {
				var mensagem = getbemvindo(update, tlgDto);
				try {
					execute(mensagem);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public String getBotUsername() {
		return DadosBot.BOT_USER_NAME;
	}

	public String getBotToken() {
		return DadosBot.BOT_TOKEN;
	}

	private SendMessage responder(Update update, TelegramDto u) {
		var textoMensagem = Tools.removerAcentos(update.getMessage().getText().toLowerCase());
		var chatId = update.getMessage().getChatId().toString();

		var resposta = "";

		if (textoMensagem.contains(Tools.removerAcentos("Ola"))) {
			resposta += u.getUltimoNome() + ", bom ver você aqui novamente\n";
			resposta += " temos algumas opções para você:\n "
					+ ". /servico \n"
					+ ". /contato \n"
					+ ". /localizacao";				
			
		} else {
			resposta = "";
		}

		return SendMessage.builder().text(resposta).parseMode("HTML").chatId(chatId).build();
	}
	
	private SendMessage servico(Update update, TelegramDto u) {
						
		var textoMensagem = Tools.removerAcentos(update.getMessage().getText().toLowerCase());
		var chatId = update.getMessage().getChatId().toString();
		var id = update.getMessage().getChat().getId().toString();
				
		
		var resposta = "";

		if (textoMensagem.contains(Tools.removerAcentos("Ola"))) {
			resposta += u.getUltimoNome() + " boa, informe o seu pin de 4 numeros? \n";				
			
		} else {
			resposta = "";
		}

		return SendMessage.builder().text(resposta).parseMode("HTML").chatId(chatId).build();
	}

	private SendContact sendContato(String chatid) {
		SendContact contato = new SendContact();
		contato.setFirstName("Dantec");
		contato.setLastName("Bot");
		contato.setPhoneNumber("+55 32 98448-0513");
		contato.setChatId(chatid);

		return contato;

	}

	private SendLocation localizacao(String chatid) {
		SendLocation maps = new SendLocation();

		maps.setLatitude(-21.7740625);
		maps.setLongitude(-43.3775202);
		maps.setChatId(chatid);
		return maps;

	}

	private String getData() {
		var formatter = new SimpleDateFormat("dd/MM/yyyy");
		return "A data atual é: " + formatter.format(new Date());
	}

	private String getContato() {
		return " Você pode " + " " + " nosso horário de funcionamento : \n\n"
				+ " Terça-feira a Domingo das 10:00 as 20:00\n\n" + " escolha uma das opções abaixo:\n"
				+ "    /Mesa_vaga\n" + "    /Localizacao\n" + "    /Cardapio\n";

	}

	private String getHora() {
		var formatter = new SimpleDateFormat("HH:mm:ss");
		return "A hora atual é: " + formatter.format(new Date());
	}

	private String getOla() {
		operacao = "celular";
		return " Como podemos te ajustar Hoje?\n" + " Digite o seu os quatro ultimos do seu celular?";
	}

	private SendMessage getbemvindo(Update update, TelegramDto u) {
		var textoMensagem = Tools.removerAcentos(update.getMessage().getText().toLowerCase());
		var chatId = update.getMessage().getChatId().toString();
		var id = update.getMessage().getChat().getId().toString();
		operacao = "servico";
		Operacao o = new Operacao();		

		var resposta = "";

		if (textoMensagem.contains(Tools.removerAcentos("Ola"))) {
			resposta += u.getUltimoNome() + " boa, informe o seu pin de 4 numeros? \n";				
			
		} else {
			resposta = "";
		}

		return SendMessage.builder().text(resposta).parseMode("HTML").chatId(chatId).build();

	}

	private TelegramDto getTelegraUser(Update update) {
		TelegramDto tlgDto = new TelegramDto();
		tlgDto.setIdTelegram(update.getMessage().getFrom().getId().toString());
		tlgDto.setPrimeiroNome(update.getMessage().getFrom().getFirstName());
		tlgDto.setNomeUsuario(update.getMessage().getFrom().getUserName());
		tlgDto.setUltimoNome(update.getMessage().getFrom().getLastName());
		tlgDto.setMensagem(update.getMessage().getChat().getId().toString());

		try {
			tlgDto = TelegramUser.getTelegramUser(tlgDto);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return tlgDto;
	}

}
