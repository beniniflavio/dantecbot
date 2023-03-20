package telegrambot.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ResponseWrapper implements Serializable {

	private static final long serialVersionUID = 2175919931775829591L;
	private String method;
    private String result;
    private List<OrdemServicoDto> MsgSaida;
    private List<ErrorItem> erros;
    
    public ResponseWrapper() {
    	MsgSaida = new ArrayList<OrdemServicoDto>(); 
    	erros = new ArrayList<ErrorItem>();
    			
	}


    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<OrdemServicoDto> getMsgSaida() {
        return this.MsgSaida;
    }

    public void setMsgSaida(List<OrdemServicoDto> MsgSaida) {
        this.MsgSaida = MsgSaida;
    }

    public List<ErrorItem> getErros() {
        return this.erros;
    }

    public void setErros(List<ErrorItem> erros) {
        this.erros = erros;
    }

}
