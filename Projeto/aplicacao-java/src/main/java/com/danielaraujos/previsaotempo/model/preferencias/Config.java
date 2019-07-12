package com.danielaraujos.previsaotempo.model.preferencias;


/**
 * Classe representa o modelo das configurações do banco
 *
 * @author Daniel Araújo
 */

public class Config {

    private String banco;
    private String ip;
    private Integer porta;
    private String versao_oracle;
    private String usuario;
    private String senha;
    private String dialeto;
    private String driver;


    /**
     * IP do servidor
     *
     * @return String - IP do servidor
     */
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Porta de conexão ao servidor
     *
     * @return Integer - Porta de conexão ao servidor
     */
    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    /**
     * Nome da versão do banco. EX: XE
     *
     * @return String - Nome da versão do banco. EX: XE
     */
    public String getVersao_oracle() {
        return versao_oracle;
    }

    public void setVersao_oracle(String versao_oracle) {
        this.versao_oracle = versao_oracle;
    }

    /**
     * Nome do usuario no banco
     *
     * @return String - Nome do usuario no banco
     */
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Senha de acesso ao usuario
     *
     * @return String - Senha de acesso ao usuario
     */
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * URL de conexão ao banco
     *
     * @return String - URL de conexão ao banco
     */
    public String getUrl() {
        return "jdbc:" + getBanco() + ":thin:@" + getIp() + ":" + getPorta() + ":" + getVersao_oracle();
    }

    /**
     * Nome do banco de dados
     *
     * @return String - Nome do banco de dados
     */
    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * Estrutura do dialeto do banco
     *
     * @return String - Estrutura do dialeto do banco
     */
    public String getDialeto() {
        return dialeto;
    }

    public void setDialeto(String dialeto) {
        this.dialeto = dialeto;
    }

    /**
     * Nome do driver de conexão oracle - hibernate
     *
     * @return String - Nome do driver de conexão oracle - hibernate
     */
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}

