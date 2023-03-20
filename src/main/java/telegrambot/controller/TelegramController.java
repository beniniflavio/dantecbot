package telegrambot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/Telegram")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost", "http://192.168.0.163:8089",
		"http://192.168.2.200:8089", "http://192.168.0.172", "http://192.168.2.200", "http://localhost:80" })
public class TelegramController {
	
	@GetMapping("/{id}")
	@ResponseBody
	public String  getAcessorios(@PathVariable(name = "id") String id) {
	

		return "ok";

	}


}
