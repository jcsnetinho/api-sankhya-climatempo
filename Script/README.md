# Api Sankhya / Clima Tempo

## Resumo
<p>
O objetivo deste repositório é armazenar os scripts responsáveis pela execução da integração Sankhya com Clima Tempo. O Módulo foi desenvolvido na linguagem Java. Segue abaixo todas as configurações necessárias para bom funcionamento.
</p>

## Requisitos
- [x] Java JDK
- [x] Banco de Dados Oracle

## Execução

### Banco de Dados
Para configuração do banco, é necessário a configuração do arquivo json, ou execução do arquivo bat, chamado <b>Terminal</b>.

```sh
 src/main/resources/config/config.json
```
Arquivo JSON:
```sh
{
  "banco": "oracle",
  "ip":"192.168.1.10",
  "porta":1521,
  "versao_oracle":"XE",
  "usuario":"TESTE",
  "senha":"AAAMINHASENHA",
  "dialeto": "org.hibernate.dialect.Oracle10gDialect",
  "driver": "oracle.jdbc.driver.OracleDriver"
}

```

  - banco: Coloque o nome de seu banco
  - ip: Endereço do banco
  - porta: Porta do banco
  - versao_oracle: Nome do serviço 
  - usuario: Nome do usuário
  - senha: Senha de acesso
  - dialeto: Dialeto do Hibernate para seu banco
  - driver: Driver de conexão do script ao banco
  
Observação: Os dados acima são importantes para concatenação para a configuração da url:

```sh
"jdbc:oracle:thin:@192.168.1.10:1521:XE";
```

### Geração de Log
Para a execução do log da aplicação, utilizamos a biblioteca [Log4j](https://logging.apache.org/log4j/2.x/). Existe um arquivo de configuração padrão, o mesmo vem previamente configurado.
Mas caso deseje incrementar outros logs, o arquivo se encontra no diretório:

```sh
 src/main/resources/config/log4j.properties
```	
O arquivo log gerado, pode ser visto no diretório:

```sh
 src/main/resources/Log
```	

### Agendador de Tarefas
Rotina responsável pela execução automática do script, para deixar o módulo sempre atualizado.

#### Windows
1º Criar Tarefa:<br>
<img src="https://i.ibb.co/NxWx6T9/1.png" alt="drawing" width="450"/>

2º Criar Disparador:<br>
<img src="https://i.ibb.co/Y2HzCTt/2.png" alt="drawing" width="450"/><br>
O disparador executa diariamente, a cada 6 horas. Coloque o intervalo de tempo que achar pertinente.

3º Criar Ação:<br>
<img src="https://i.ibb.co/gg50VNx/3.png" alt="drawing" width="450"/><br>
Como o Windows tem algumas particularidades, é necessário que no campo "Iniciar em: ", colocar o prefixo do diretório.
Pois sem essa configuração, o serviço não será executado.

4º Configuração:<br>
<img src="https://i.ibb.co/SRp4sCR/4.png" alt="drawing" width="450"/><br>


#### Linux

### Versões
Site da API: http://apiadvisor.climatempo.com.br/doc/index.html
#### 1.0
Serviços implementados nesta versão:
<ul>
  <li>Weather - Tempo no momento</li>
  <li>Forecast - Previsão 15 dias</li>
  <li>Forecast - Previsão 72 horas</li>
  <li>Locale - Buscar cidades por Nome e/ou Estado</li>
</ul>


