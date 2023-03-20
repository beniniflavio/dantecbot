package telegrambot.service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import telegrambot.data.OperacaoData;
import telegrambot.data.OperacaoDto;
import telegrambot.data.OrdemServicoDto;
import telegrambot.data.ResponseWrapper;
import telegrambot.data.TelegramDto;
import telegrambot.model.Operacao;

public class DosService {
			

	private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
			.connectTimeout(Duration.ofSeconds(10)).build();
	
	public static void back() {

		HttpRequest request = HttpRequest.newBuilder().GET()
				.uri(URI.create("http://192.168.0.172:8881/api/v1/OrdemServicos"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();

		CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request,
				HttpResponse.BodyHandlers.ofString());

		try {
			String result = response.thenApply(HttpResponse::body).get(50, TimeUnit.SECONDS);
			ObjectMapper mapper = new ObjectMapper();

			ResponseWrapper map = mapper.readValue(result, ResponseWrapper.class);

			System.out.println(result);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static TelegramDto getTelegramDto(String idTelegram) {

		TelegramDto tlg = null;

		HttpRequest request = HttpRequest.newBuilder().GET()
				.uri(URI.create("http://192.168.0.172:8881/api/v1/Telegram/" + idTelegram))
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();

		CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request,
				HttpResponse.BodyHandlers.ofString());

		try {
			String result = response.thenApply(HttpResponse::body).get(50, TimeUnit.SECONDS);
			ObjectMapper mapper = new ObjectMapper();

			tlg = mapper.readValue(result, TelegramDto.class);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tlg;

	}

	public static TelegramDto addTelegramUserDto(TelegramDto t) throws IOException, InterruptedException {
		Gson gson = new Gson();
		String json = gson.toJson(t);

		HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(json))
				.uri(URI.create("http://192.168.0.172:8881/api/v1/Telegram/Novo"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
				.header("Content-Type", "application/json").build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		// print status code
		System.out.println(response.statusCode());

		// print response body
		System.out.println(response.body());
		return null;
	}

	public OperacaoDto prssOperacao (Update update, TelegramDto u) {
				
			
		OperacaoData opd = new OperacaoData();
		
		opd.setOperacao("servico");
		opd.setEstagiodate(new Date());
		opd.setEstagio("1");
		opd.setEstagiodata(update.getMessage().getText());
		opd.setEstagiodata(update.getMessage().getText());
		opd.setTelegram(update.getMessage().getFrom().getId().toString());

		return null;
	}

	public static TelegramDto addTelegramUser(TelegramDto t) throws IOException, InterruptedException {

		Map<Object, Object> data = new HashMap<>();
		data.put("chave", "");
		data.put("idTelegram", t.getIdTelegram());
		data.put("nomeUsuario", t.getNomeUsuario());
		data.put("primeiroNome", t.getNomeUsuario());
		data.put("ultimoNome", t.getUltimoNome());
		data.put("situacao", "");

		Gson gson = new Gson();
		String json = gson.toJson(data);

		HttpRequest request = HttpRequest.newBuilder().POST(ofFormData(data))
				.uri(URI.create("http://192.168.0.172:8881/api/v1/Telegram/Novo"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
				.header("Content-Type", "application/x-www-form-urlencoded").build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		// print status code
		System.out.println(response.statusCode());

		// print response body
		System.out.println(response.body());

		return null;
	}

	public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
		var builder = new StringBuilder();
		for (Map.Entry<Object, Object> entry : data.entrySet()) {
			if (builder.length() > 0) {
				builder.append("&");
			}
			builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
			builder.append("=");
			builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
		}
		return HttpRequest.BodyPublishers.ofString(builder.toString());
	}

	public static HttpRequest.BodyPublisher ofFormDataTelegramDTo(Map<Object, Object> data) {
		var builder = new StringBuilder();
		for (Map.Entry<Object, Object> entry : data.entrySet()) {
			if (builder.length() > 0) {
				builder.append("&");
			}
			builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
			builder.append("=");
			builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
		}
		return HttpRequest.BodyPublishers.ofString(builder.toString());
	}

}
