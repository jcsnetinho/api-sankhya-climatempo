package com.danielaraujos.previsaotempo;

import com.danielaraujos.previsaotempo.controller.CidadeController;
import com.danielaraujos.previsaotempo.model.sankhya.Cidade;
import org.apache.log4j.Logger;


public class AcoesPrincipais {

    private static Logger logger = Logger.getLogger(AcoesPrincipais.class);

    public static void principal()  throws InterruptedException{

        System.out.println("RUN SCRIPT");
        logger.warn("------------------------INICIANDO A APLICAÇÃO ---------------------");

        int i = 0;

        CidadeController cidadeController = new CidadeController();

        for (Cidade cidade: cidadeController.getCidadesMarcadas()) {
            int codCidadeClimaTempo = cidadeController.getCodigoCidade(cidade.getCodcid());

            System.out.println("\n-"+ cidade.getCodcid() + ":"+ cidade.getNomecid());
            logger.info("CODIGO DA CIDADE: "+cidade.getCodcid() + " - Nome da Cidade: "+ cidade.getNomecid());

            System.out.print("PA: ");
            Tarefas.ClimaAtualTarefas(codCidadeClimaTempo, cidade.getCodcid());

            System.out.print("\nP72h: ");
            Tarefas.Previsao72hTarefas(codCidadeClimaTempo,cidade.getCodcid());

            System.out.print("\nP15d: ");
            Tarefas.Previsao15dTarefas(codCidadeClimaTempo,cidade.getCodcid());

            //System.out.println("\nCC: ");
            //Tarefas.ChuvaClimaticaTarefas(codCidadeClimaTempo, cidade.getCodcid());

            i = i+3;
            if(i==9){
                System.out.println("");
                System.out.println("\nEsperar:70s");
                logger.info("\nEsperar:70s");
                Thread.sleep(70000);
                i = 0;
            }
            System.out.print("\n");
        }

        logger.warn("------------------------FINALIZANDO A APLICAÇÃO ---------------------");
        System.out.println("\nEND SCRIPT");
        System.exit(0);
    }


}
