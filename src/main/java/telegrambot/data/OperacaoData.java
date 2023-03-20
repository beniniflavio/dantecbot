package telegrambot.data;

import java.util.Date;

public class OperacaoData {
	
	private String chave;
	private String telegram;
	private String operacao;
	private String estagio;
	private String estagiodata;
	private Date estagiodate;
	
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getTelegram() {
		return telegram;
	}
	public void setTelegram(String telegram) {
		this.telegram = telegram;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public String getEstagio() {
		return estagio;
	}
	public void setEstagio(String estagio) {
		this.estagio = estagio;
	}
	public String getEstagiodata() {
		return estagiodata;
	}
	public void setEstagiodata(String estagiodata) {
		this.estagiodata = estagiodata;
	}
	public Date getEstagiodate() {
		return estagiodate;
	}
	public void setEstagiodate(Date estagiodate) {
		this.estagiodate = estagiodate;
	} 
	
	
	

}
