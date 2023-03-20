package telegrambot.bot;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import telegrambot.data.TelegramDto;
import telegrambot.service.DosService;

@Service
public class TelegramUser {
	
	@Autowired
	static
	DosService service;

	public static TelegramDto getTelegramUser(TelegramDto t) throws IOException, InterruptedException {
		var tlgDto = service.getTelegramDto(t.getIdTelegram());
		if ( tlgDto == null) {
			tlgDto = service.addTelegramUserDto(t);
			
		}			
		return tlgDto;
	}
	
	public TelegramDto addTelegramUser(TelegramDto t ) {
		return null;
	}
}
