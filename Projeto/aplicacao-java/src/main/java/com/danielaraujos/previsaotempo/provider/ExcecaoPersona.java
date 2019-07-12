package com.danielaraujos.previsaotempo.provider;

public class ExcecaoPersona extends Exception {

    private int codigo;
    private String mensagem;

    public ExcecaoPersona(int codigo, String mensagem) {
        super("Erro: <Código>: "+ codigo+ " <Mensagem> :"+mensagem);
        this.setMensagem(mensagem);
        this.setCodigo(codigo);

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
