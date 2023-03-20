package telegrambot.model;

import java.io.Serializable;
import java.util.Date;

import telegrambot.data.TelegramDto;

public class Operacao implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private TelegramDto telegram;
	private String estagio;
	private String estadioData1;
	private String estadioData2;
	private String estadioData3;
	private String estadioData4;	
	private Date dtEstadioData1;
	private Date dtEstadioData2;
	private Date dtEstadioData3;
	private Date dtEstadioData4;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TelegramDto getTelegram() {
		return telegram;
	}
	public void setTelegram(TelegramDto telegram) {
		this.telegram = telegram;
	}
	public String getEstagio() {
		return estagio;
	}
	public void setEstagio(String estagio) {
		this.estagio = estagio;
	}
	public String getEstadioData1() {
		return estadioData1;
	}
	public void setEstadioData1(String estadioData1) {
		this.estadioData1 = estadioData1;
	}
	public String getEstadioData2() {
		return estadioData2;
	}
	public void setEstadioData2(String estadioData2) {
		this.estadioData2 = estadioData2;
	}
	public String getEstadioData3() {
		return estadioData3;
	}
	public void setEstadioData3(String estadioData3) {
		this.estadioData3 = estadioData3;
	}
	public String getEstadioData4() {
		return estadioData4;
	}
	public void setEstadioData4(String estadioData4) {
		this.estadioData4 = estadioData4;
	}
	public Date getDtEstadioData1() {
		return dtEstadioData1;
	}
	public void setDtEstadioData1(Date dtEstadioData1) {
		this.dtEstadioData1 = dtEstadioData1;
	}
	public Date getDtEstadioData2() {
		return dtEstadioData2;
	}
	public void setDtEstadioData2(Date dtEstadioData2) {
		this.dtEstadioData2 = dtEstadioData2;
	}
	public Date getDtEstadioData3() {
		return dtEstadioData3;
	}
	public void setDtEstadioData3(Date dtEstadioData3) {
		this.dtEstadioData3 = dtEstadioData3;
	}
	public Date getDtEstadioData4() {
		return dtEstadioData4;
	}
	public void setDtEstadioData4(Date dtEstadioData4) {
		this.dtEstadioData4 = dtEstadioData4;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
