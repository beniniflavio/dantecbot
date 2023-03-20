package telegrambot.data;

public class TelegramDto {
	
		private String chave;	
		private String idTelegram;	    
		private String primeiroNome;			    
		private String ultimoNome;			
		private String nomeUsuario;
		private String situacao;	
		private String mensagem;
				
		
		public String getChave() {
			return chave;
		}
		public void setChave(String id) {
			this.chave = id;
		}
		public String getIdTelegram() {
			return idTelegram;
		}
		public void setIdTelegram(String idTelegram) {
			this.idTelegram = idTelegram;
		}

		public String getPrimeiroNome() {
			return primeiroNome;
		}

		public void setPrimeiroNome(String primeiroNome) {
			this.primeiroNome = primeiroNome;
		}

		public String getUltimoNome() {
			return ultimoNome;
		}

		public void setUltimoNome(String ultimoNome) {
			this.ultimoNome = ultimoNome;
		}

		public String getNomeUsuario() {
			return nomeUsuario;
		}

		public void setNomeUsuario(String nomeUsuario) {
			this.nomeUsuario = nomeUsuario;
		}

		public String getSituacao() {
			return situacao;
		}

		public void setSituacao(String situacao) {
			this.situacao = situacao;
		}
		public String getMensagem() {
			return mensagem;
		}
		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}
							

}
