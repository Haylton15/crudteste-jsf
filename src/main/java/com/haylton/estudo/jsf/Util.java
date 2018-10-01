package com.haylton.estudo.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {
    
    public static String getMensagemErro(Exception e){
        while(e.getCause() !=null){ //com esse la�o eu estou acessando o n�vel mais baixo de excess�o, pois uma cess�o pode ter outras encapsuladas nela.
            e = (Exception) e.getCause();
        }
        String retorno = e.getMessage();
        if(retorno.contains("Viola restri��o da chave estrangeira")){
            retorno = "Registro n�o pode ser exlu�do por possuir referencia no sistema";
        }
        
        return retorno;
    }
    
    public static void mensagemInformacao(String msg){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().getFlash().setKeepMessages(true); //as mensagens se perdem depois de um redirecionamento e se quero manter as mensagens mesmo depois de redirecionar as p�ginas
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
        facesContext.addMessage(null, mensagem);
    }
    
    public static void mensagemErro(String msg){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().getFlash().setKeepMessages(true); //as mensagens se perdem depois de um redirecionamento e se quero manter as mensagens mesmo depois de redirecionar as p�ginas
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "");
        facesContext.addMessage(null, mensagem);
    }
    
}