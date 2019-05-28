<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" isELIgnored ="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="snk" uri="/WEB-INF/tld/sankhyaUtil.tld" %>
<html>
   <head>
      <title>Clima Atual</title>
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta charset="utf-8">
      <link href="${BASE_FOLDER}/css/bootstrap.min.css" rel="stylesheet">
      <link href="${BASE_FOLDER}/css/style_home.css" rel="stylesheet">
      
      <snk:load/>
      <script type='text/javascript'>
         function abrirDetalhes(CODCID){
         	var params = {'CODCID' : CODCID};
         	openLevel('lvl_abmxejt', params);
         }
      </script>
   </head>
   <body>
      <snk:query var="previsoes"> 
         SELECT DISTINCT P.CODCID AS CODCID, CODPRETEMAT AS CODPRETEMAT, P.CONDICAO AS CONDICAO, to_char(P.DATAPREVISAO, 'dd/MM/yyyy hh24:mi:ss') AS DATA, P.UMIDADE AS UMIDADE, 
         P.ICONE AS ICONE , trunc(P.PRESSAO) AS PRESSAO, P.SENSACAO AS SENSACAO, Round(P.TEMPERATURA) AS TEMPERATURA,
         P.DIRECAOVENTO AS DIRECAOVENTO, P.VELOCIDADEVENTO AS VELOCIDADEVENTO,INITCAP(CID.NOMECID) AS NOME
         FROM TSICID CID, AD_PRETEMAT P
         WHERE P.CODCID = CID.CODCID
         AND P.CODCID IN (:P_CIDADE)
         AND P.DATAPREVISAO = (SELECT MAX( DATAPREVISAO) FROM AD_PRETEMAT WHERE CODCID = P.CODCID)
         ORDER BY NOME
      </snk:query>
      <br>
      <div class="container">
      <div class="card-deck mb-3 text-center">
         <c:forEach items="${previsoes.rows}" var="row">
            <div class="card mb-4 shadow-sm">
               <div class="card-header">
                  <h4 class="my-0 font-weight-normal">
                     <c:out value="${row.NOME}" />
                  </h4>
               </div>
               <div class="card-body">
                  <div class="row">
                     <div class="col-sm-4">
                        <img src="${BASE_FOLDER}/images/<c:out value="${row.ICONE}" />.png"  class="responsive">
                     </div>
                     <div class="col-sm-8">
                        <h1 class="card-title pricing-card-title" id="titleGraus">
                           <c:out value="${row.TEMPERATURA}" />
                           º
                        </h1>
                     </div>
                  </div>
                  <span class="textInfo">
                     <b>
                        <c:out value="${row.CONDICAO}" />
                     </b>
                  </span>
                  <ul class="list-unstyled mt-3 mb-4">
                     <li>
                        <b>Sensação: </b>
                        <c:out value="${row.SENSACAO}" />ºC
                     </li>
                     <li>
                        <b>Umidade: </b>
                        <c:out value="${row.UMIDADE}" />
						%
                     </li>
                     <li>
                        <b>Pressão: </b>
                        <c:out value="${row.PRESSAO}" />
                        hPa
                     </li>
                     <li>
                        <b>Vento: </b>
                        <c:out value="${row.VELOCIDADEVENTO}" />
                        km/h 
                     </li>
                  </ul>
                  <small style="font-size:11px;">
                     Última atualização:<br> 
                     <c:out value="${row.DATA}" />
                  </small>
                  <br><br>
                  <button class="btn btn-lg btn-block btn-primary" onclick="javascript:abrirDetalhes( ${row.CODCID} )">Ver detalhes</button>
               </div>
            </div>
         </c:forEach>
      </div>
      <!-- Bootstrap core JavaScript
         ================================================== -->
      <!-- Placed at the end of the document so the pages load faster -->
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
   </body>
</html>