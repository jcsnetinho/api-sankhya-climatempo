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
	  <link href="${BASE_FOLDER}/css/style_sub.css" rel="stylesheet">
      <link href="${BASE_FOLDER}/css/bootstrap.min.css" rel="stylesheet">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	  
      <snk:load/>
      <script type='text/javascript'>
         
         function abrirDetalhesData(P_DATA){
         	var params = {"P_DATA" : P_DATA};
         	openLevel('lvl_kmprlf', params);
         }
		 
         function abrirTemperaturaVento(P_DATA){
         	var params = {"P_DATA" : P_DATA};
         	openLevel('lvl_gtr430', params);
         }
		 
      </script>
	  
   </head>
   <body>
      <snk:query var="geoforecast"> 
         SELECT TO_CHAR(DATAPREVISAO, 'ddMMYY') AS P_DATA,TO_CHAR(DATAPREVISAO, 'YY/MM/dd') as DAT,INITCAP(TO_CHAR(DATAPREVISAO, 'DAY')) AS DIA, CODCID,TEMPERATURAMAX as TEMPMAX, TEMPERATURAMIN AS TEMPMIN, TEXTOCLIMA,PRECIPITACAOCHUVA, PROBABILIDADECHUVA,ICONEDIA
         FROM AD_PRETEMD
         WHERE DATAPREVISAO BETWEEN SYSDATE AND SYSDATE+7
         AND CODCID = :CODCID
         ORDER BY DATAPREVISAO
      </snk:query>
      <snk:query var="geoforecastinfo"> 
         SELECT CODCID, CODPRETEMD, DATAPREVISAO, DIRECAOVENTO, RAJADAVENTO, UMIDADEMAX, UMIDADEMIN, PRECIPITACAOCHUVA, PROBABILIDADECHUVA, SENSACAOMAX, SENSACAOMIN, TEMPERATURAMAX, 
         TEMPERATURAMIN, TEXTOCLIMA, VELOCIDADEMAXVENTO, VELOCIDADEMINVENTO,TEXTODIA, ICONEMANHA,ICONETARDE,ICONENOITE, 
         TEMPERATURAMANHAMAX, TEMPERATURAMANHAMIN, TEMPERATURANOITEMAX, TEMPERATURANOITEMIN, TEMPERATURATARDEMAX, TEMPERATURATARDEMIN,
         UMIDADEMANHAMAX, UMIDADEMANHAMIN, UMIDADENOITEMAX, UMIDADENOITEMIN, UMIDADETARDEMAX, UMIDADETARDEMIN,
         VELOCIDADEMANHAVENTO, VELOCIDADENOITEVENTO, VELOCIDADETARDEVENTO,
         RAJADAMANHAVENTO, RAJADANOITEVENTO, RAJADATARDEVENTO,PRECIPITACAOCHUVA, PROBABILIDADECHUVA,
         DIRECAOGRAUSMANHAVENTO, DIRECAOGRAUSNOITEVENTO, DIRECAOGRAUSTARDEVENTO, DM.NOME AS DIRECAOMANHAVENTO, DT.NOME AS  DIRECAOTARDEVENTO,DN.NOME AS   DIRECAONOITEVENTO,
		 TO_CHAR(DATAPREVISAO, 'ddMMYY')|| 1 AS D1,TO_CHAR(DATAPREVISAO, 'ddMMYY')|| 2 AS D2,TO_CHAR(DATAPREVISAO, 'ddMMYY')|| 3 AS D3
         FROM AD_PRETEMD, AD_PRETEMDIR DM,AD_PRETEMDIR DT,AD_PRETEMDIR DN
         WHERE DATAPREVISAO = TO_CHAR(SYSDATE)
         AND DM.SIGLA = DIRECAOMANHAVENTO
         AND DT.SIGLA = DIRECAOTARDEVENTO
         AND DN.SIGLA = DIRECAONOITEVENTO
         AND CODCID = :CODCID
         ORDER BY DATAPREVISAO
      </snk:query>
      <snk:query var="atual"> 
         SELECT DISTINCT P.CODCID AS CODCID, CODPRETEMAT AS CODPRETEMAT, P.CONDICAO AS CONDICAO, to_char(P.DATAPREVISAO, 'dd/MM/yyyy hh24:mi:ss') AS DATA, P.UMIDADE AS UMIDADE, 
         P.ICONE AS ICONE , P.PRESSAO AS PRESSAO, P.SENSACAO AS SENSACAO, Round(P.TEMPERATURA) AS TEMPERATURA,
         P.DIRECAOVENTO AS DIRECAOVENTO, P.VELOCIDADEVENTO AS VELOCIDADEVENTO,INITCAP(CID.NOMECID) AS NOME
         FROM TSICID CID, AD_PRETEMAT P
         WHERE P.CODCID = CID.CODCID
         AND P.CODCID IN (:CODCID)
         AND P.DATAPREVISAO = (SELECT MAX( DATAPREVISAO) FROM AD_PRETEMAT WHERE CODCID = P.CODCID)
         ORDER BY NOME
      </snk:query>
      <br><br><br>
      <div class="container" >
         <div class="forecast-container" id="value">
            <div class="today forecast">
               <div class="forecast-header">
                  <div class="day">Hoje</div>
               </div>
               <!-- .forecast-header -->
               <div class="forecast-content">
                  <c:forEach items="${atual.rows}" var="row">
                     <div class="location">
                        <c:out value="${row.NOME}" />
                     </div>
                     <div class="degree">
                        <div class="num">
                           <c:out value="${row.TEMPERATURA}" />
                           <sup>o</sup>C
                        </div>
                        <div class="forecast-icon">
						<img src="${BASE_FOLDER}/images/<c:out value="${row.ICONE}" />.png" alt="" width=90>
                        </div>
                     </div>
                     <span style="font-size:11px;">
                        Última atualização: 
                        <c:out value="${row.DATA}" />
                     </span>
               </div>
               </c:forEach>
            </div>
            <c:forEach items="${geoforecast.rows}" var="row">
               <div class="forecast">
                  <div class="forecast-header">
                     <div class="day">
                        <c:out value="${row.DIA}" />
                     </div>
                  </div>
                  <!-- .forecast-header -->
                  <div class="forecast-content">
                     <div class="forecast-icon">
                        <img src="${BASE_FOLDER}/images/<c:out value="${row.ICONEDIA}"/>.png" alt="" width=48>
                     </div>
                     <div class="degree">
                        <c:out value="${row.TEMPMAX}" />
                        <sup>o</sup>C
                     </div>
                     <small>
                        <c:out value="${row.TEMPMIN}" />
                        <sup>o</sup>C
                     </small>
                     <p></p>
                     <button class="btn btn-danger" onclick="javascript:abrirDetalhesData( ${row.P_DATA})"><i class="fa fa-search"></i> </button>
                    </div>
               </div>
            </c:forEach>
         </div>
         <c:forEach items="${geoforecastinfo.rows}" var="row">
            <div class="card-deck mb-4 text-center">
               <div class="card mb-3 shadow-sm">
                  <div class="card-body">
                     <div class="row">
                        <div class="col-2"><img src="${BASE_FOLDER}/images/icon-humidy.png" alt="" width=48></div>
                        <div class="col-10"class="border-gray">
                           <h2 class="card-title" align="left">Chuvas</h2>
                           <hr>
                        </div>
                     </div>
                     <div class="row">
                        <div class="col-12">
                           <span>
                              <strong>Probabilidade:</strong> 
                              <c:out value="${row.PROBABILIDADECHUVA}" />
                              % - <strong>Precipitação:</strong> 
                              <c:out value="${row.PRECIPITACAOCHUVA}" />
                              mm
                           </span>
                           <br><br>
                           <div class="row">
                              <div class="col-12" align="center"><button type="button" onclick="javascript:abrirTemperaturaVento(${row.D3})" class="btn btn-danger btn-lg btn-block">Saiba Mais</button></div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="card mb-4 shadow-sm">
                  <div class="card-body">
                     <div class="row">
                        <div class="col-2"><img src="${BASE_FOLDER}/images/icon-temperature.png" alt="" width=48></div>
                        <div class="col-10"class="border-gray">
                           <h2 class="card-title" align="left">Temperaturas</h2>
                           <hr>
                        </div>
                     </div>
                     <div class="row">
                        <div class="col-12">
                           <span>
                              <strong>Mínima:</strong> 
                              <c:out value="${row.TEMPERATURAMIN}" />
                              °C - <strong>Máxima:</strong> 
                              <c:out value="${row.TEMPERATURAMAX}" />
                              °C
                           </span>
                           <br><br>
                           <div class="row">
                              <div class="col-12" align="center"><button type="button" onclick="javascript:abrirTemperaturaVento(${row.D2})" class="btn btn-danger btn-lg btn-block">Saiba Mais</button></div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="card mb-4 shadow-sm">
                  <div class="card-body">
                     <div class="row">
                        <div class="col-2"><img src="${BASE_FOLDER}/images/icon-wind.png" alt="" width=48></div>
                        <div class="col-10"class="border-gray">
                           <h2 class="card-title" align="left">Ventos</h2>
                           <hr>
                        </div>
                     </div>
                     <div class="row">
                        <div class="col-12">
                           <span>
                              <strong>Mínima:</strong> 
                              <c:out value="${row.VELOCIDADEMINVENTO}" />
                              km/h - <strong>Máxima:</strong> 
                              <c:out value="${row.VELOCIDADEMAXVENTO}" />
                              km/h
                           </span>
                           <br><br>
                           <div class="row">
                              <div class="col-12" align="center"><button type="button" onclick="javascript:abrirTemperaturaVento(${row.D1})" class="btn btn-danger btn-lg btn-block">Saiba Mais</button></div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <div class="row">
               <div class="col-12">
                  <div class="alert alert-info" role="alert">
                     <h4>
                        <c:out value="${row.TEXTODIA}" />
                     </h4>
                  </div>
               </div>
            </div>
            <div class="card-deck mb-3 text-center">
               <div class="card mb-4 shadow-sm">
                  <div class="card-body">
                     <div class="row">
                        <div class="col-2">
                           <img src="${BASE_FOLDER}/images/<c:out value="${row.ICONETARDE}" />.png" alt="" width=48>
                        </div>
                        <div class="col-10"class="border-gray">
                           <h2 class="card-title" align="left">Manhã</h2>
                           <hr>
                        </div>
                     </div>
                     <div class="row">
                        <div class="col-12">
                           <table class="table table-striped">
                              <thead>
                                 <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Minímo</th>
                                    <th scope="col">Máximo</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr>
                                    <th scope="row">T</th>
                                    <td>
                                       <c:out value="${row.TEMPERATURAMANHAMIN}" />
                                       ºC
                                    </td>
                                    <td>
                                       <c:out value="${row.TEMPERATURAMANHAMAX}" />
                                       ºC
                                    </td>
                                 </tr>
                                 <tr>
                                    <th scope="row">U</th>
                                    <td>
                                       <c:out value="${row.UMIDADEMANHAMIN}" />
                                       %
                                    </td>
                                    <td>
                                       <c:out value="${row.UMIDADEMANHAMAX}" />
                                       %
                                    </td>
                                 </tr>
                                 <tr>
                                    <th scope="row">I/V</th>
                                    <td>
                                       <c:out value="${row.RAJADAMANHAVENTO}" />
                                       km/h
                                    </td>
                                    <td>
                                       <c:out value="${row.VELOCIDADEMANHAVENTO}" />
                                       km/h
                                    </td>
                                 </tr>
                                 <tr>
                                    <th scope="row">D/G</th>
                                    <td>
                                       <c:out value="${row.DIRECAOMANHAVENTO}" />
                                    </td>
                                    <td>
                                       <c:out value="${row.DIRECAOGRAUSMANHAVENTO}" />
                                       º
                                    </td>
                                 </tr>
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="card mb-4 shadow-sm">
                  <div class="card-body">
                     <div class="row">
                        <div class="col-2">
                           <img src="${BASE_FOLDER}/images/<c:out value="${row.ICONEMANHA}" />.png" alt="" width=48>
                        </div>
                        <div class="col-10"class="border-gray">
                           <h2 class="card-title" align="left">Tarde</h2>
                           <hr>
                        </div>
                     </div>
                     <div class="row">
                        <div class="col-12">
                           <table class="table table-striped">
                              <thead>
                                 <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Minímo</th>
                                    <th scope="col">Máximo</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr>
                                    <th scope="row">T</th>
                                    <td>
                                       <c:out value="${row.TEMPERATURATARDEMIN}" />
                                       ºC
                                    </td>
                                    <td>
                                       <c:out value="${row.TEMPERATURATARDEMAX}" />
                                       ºC
                                    </td>
                                 </tr>
                                 <tr>
                                    <th scope="row">U</th>
                                    <td>
                                       <c:out value="${row.UMIDADETARDEMIN}" />
                                       %
                                    </td>
                                    <td>
                                       <c:out value="${row.UMIDADETARDEMAX}" />
                                       %
                                    </td>
                                 </tr>
                                 <tr>
                                    <th scope="row">I/V</th>
                                    <td>
                                       <c:out value="${row.RAJADATARDEVENTO}" />
                                       km/h
                                    </td>
                                    <td>
                                       <c:out value="${row.VELOCIDADETARDEVENTO}" />
                                       km/h
                                    </td>
                                 </tr>
                                 <tr>
                                    <th scope="row">D/G</th>
                                    <td>
                                       <c:out value="${row.DIRECAOTARDEVENTO}" />
                                    </td>
                                    <td>
                                       <c:out value="${row.DIRECAOGRAUSTARDEVENTO}" />
                                       º
                                    </td>
                                 </tr>
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="card mb-4 shadow-sm">
                  <div class="card-body">
                     <div class="row">
                        <div class="col-2">
                           <img src="${BASE_FOLDER}/images/<c:out value="${row.ICONENOITE}" />.png" alt="" width=48>
                        </div>
                        <div class="col-10"class="border-gray">
                           <h2 class="card-title" align="left">Noite</h2>
                           <hr>
                        </div>
                     </div>
                     <div class="row">
                        <div class="col-12">
                           <table class="table table-striped">
                              <thead>
                                 <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Minímo</th>
                                    <th scope="col">Máximo</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr>
                                    <th scope="row">T</th>
                                    <td>
                                       <c:out value="${row.TEMPERATURANOITEMIN}" />
                                       ºC
                                    </td>
                                    <td>
                                       <c:out value="${row.TEMPERATURANOITEMAX}" />
                                       ºC
                                    </td>
                                 </tr>
                                 <tr>
                                    <th scope="row">U</th>
                                    <td>
                                       <c:out value="${row.UMIDADENOITEMIN}" />
                                       %
                                    </td>
                                    <td>
                                       <c:out value="${row.UMIDADENOITEMAX}" />
                                       %
                                    </td>
                                 </tr>
                                 <tr>
                                    <th scope="row">I/V</th>
                                    <td>
                                       <c:out value="${row.RAJADANOITEVENTO}" />
                                       km/h
                                    </td>
                                    <td>
                                       <c:out value="${row.VELOCIDADENOITEVENTO}" />
                                       km/h
                                    </td>
                                 </tr>
                                 <tr>
                                    <th scope="row">D/G</th>
                                    <td>
                                       <c:out value="${row.DIRECAONOITEVENTO}" />
                                    </td>
                                    <td>
                                       <c:out value="${row.DIRECAOGRAUSNOITEVENTO}" />
                                       º
                                    </td>
                                 </tr>
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </c:forEach>
		 <div class="row">
				   <div class="col-12">
					  <div class="alert alert-secondary" role="alert">
						 <h4>Legenda</h4>
						 <p>T = Temperatura | U = Umidade Relativa |  I = Intensidade dos ventos em km/h | V =  Rajada máxima do vento 
						 | D = Direção do vento | G = Direção do vento em graus  
						 </p>
					  </div>
				   </div>
            </div>
		 
      </div>
   </body>
</html>