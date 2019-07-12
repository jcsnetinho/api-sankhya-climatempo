package com.danielaraujos.previsaotempo;

import com.danielaraujos.previsaotempo.model.climatempo.DefaultInterface;
import com.danielaraujos.previsaotempo.model.preferencias.Config;
import com.danielaraujos.previsaotempo.provider.ExcecaoPersona;
import com.danielaraujos.previsaotempo.provider.LoggerUtil;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Terminal {

    private static String DIRETORIO = "config/config.json";

    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        LoggerUtil.CreatLog();
        menuPrincipal(s);
    }

    public static void menuPrincipal(Scanner s) throws InterruptedException {

        String texto = "CONFIGURAÇÃO DO MÓDULO DE PREVISÃO DO TEMPO" +
                "   \n" +
                "1 - CONFIGURAR BANCO DE DADOS: \n" +
                "2 - GERAR DE/PARA DAS CIDADES: \n" +
                "3 - SAIR\n" +
                "Selecione uma opção:";

        System.out.print(texto);
        int opcao = 0;
        do {
            opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    menu2(s);
                    System.out.print(texto);
                    break;
                case 2:
                    System.out.print("\n");
                    Tarefas.CidadeTarefas();
                    System.out.println("Script Concluido com sucesso!");
                    System.out.print(texto);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Selecione uma das opções acima!");
            }
        } while (opcao != 3);
    }


    public static void menu2(Scanner b) {

        String texto1 = "\n\n" +
                "   \n" +
                "1 - VISUALIZAR INFORMAÇÕES CADASTRADAS: \n" +
                "2 - ALTERAR INFORMAÇÕES DO SERVIDOR: \n" +
                "3 - VOLTAR À TELA ANTERIOR \n" +
                "Selecione uma opção:";
        System.out.print(texto1);
        int opcao = 0;

        do {
            opcao = b.nextInt();
            b.nextLine();

            switch (opcao) {
                case 1:
                    getInformacoes();
                    System.out.print(texto1);
                    break;
                case 2:
                    setInformacoes(b);
                    System.out.println("Script Concluido com sucesso!");
                    System.out.print(texto1);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Selecione uma das opções acima!");
            }

        } while (opcao != 3);
    }


    public static void setInformacoes(Scanner s) {
        System.out.print("IP do servidor:");
        String servidor = s.nextLine();

        System.out.print("Porta do Banco: ");
        int porta = s.nextInt();
        s.nextLine();

        System.out.print("Nome do Banco:");
        String banco = s.nextLine();

        System.out.print("Versao do Banco:");
        String versao = s.nextLine();

        System.out.print("Usuario:");
        String usuario = s.nextLine();

        System.out.print("Senha:");
        String senha = s.nextLine();

        criarJson(servidor, porta, banco, versao, usuario, senha);
    }

    public static void criarJson(String servidor, int porta, String banco, String versao, String usuario, String senha) {
        Config config = new Config();

        config.setIp(servidor);
        config.setPorta(porta);
        config.setBanco(banco);
        config.setVersao_oracle(versao);
        config.setUsuario(usuario);
        config.setSenha(senha);

        config.setDialeto("org.hibernate.dialect.Oracle10gDialect");
        config.setDriver("oracle.jdbc.driver.OracleDriver");

        Gson gson = new Gson();
        String json = gson.toJson(config);

        try {
            FileWriter writer = new FileWriter(DIRETORIO);
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void getInformacoes() {
        try {
            Config config = new DefaultInterface().getConfig(DIRETORIO);
            System.out.println("Banco: " + config.getBanco());
            System.out.println("IP Servidor: " + config.getIp());
            System.out.println("Porta: " + config.getPorta());
            System.out.println("Versão do Banco: " + config.getVersao_oracle());
            System.out.println("Usuario: " + config.getUsuario());
            System.out.println("Senha: " + config.getSenha());
            System.out.println("Dialeto: " + config.getDialeto());
            System.out.println("Driver: " + config.getDriver());

        } catch (ExcecaoPersona e) {
            System.out.println(e);
            System.exit(0);
        } catch (NullPointerException e) {
            System.out.println("Não existe nenhuma estrutura para este arquivo.");
        }
    }
}

