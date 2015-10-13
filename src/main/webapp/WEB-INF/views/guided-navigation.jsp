<%-- 
    Document   : guided-navigation
    Created on : 08/10/2015, 13:21:57
    Author     : Guilherme JC Gois
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MUVI - Visita Guiada</title>
        
        <c:url value="/resources/css/main.css" var="maincss"/>
        <link href="${maincss}" rel="stylesheet">

        <c:url value="/resources/css/menu.css" var="menucss"/>
        <link href="${menucss}" rel="stylesheet">
        
        <c:url value="/resources/css/navigation.css" var="navigationcss"/>
        <link href="${navigationcss}" rel="stylesheet">

    </head>
    <body>
        <%@ include file="../jspf/menu.jspf" %>

        <section id="object-section">
            <nav>
                <ul>
                    <li><div id="backto" class="first"><a class="nav-sce-btn">#</a></div></li>
                    <li><div class="nav-sce-location">1 de 4</div></li>
                    <li><div id="goto"><a class="nav-sce-btn">#</a></div></li>
                </ul>
            </nav>
            <article>
                <section>
                    <header>
                        <h1>Como tudo Começou</h1>
                    </header>
                    <article id="object-text">
                        <div>
                            Antigamente não existiam carros, ônibus ou caminhões. As viagens eram feitas a pé e as cargas e pessoal eram transportadas nas costas dos escravos índios e negros.<br>
                            As poucas cidades viviam isoladas, com dificuldades para adquirir alimentos e outros produtos
                            de fora e também dificuldades para transportar o que produziam.<br>
                            Foi nessa época no final do século XVII, que surgiram os tropeiros.
                        </div>
                        <a class="amore" href="#">Para saber mais...</a>
                    </article>
                    <footer class="hide">
                        <div>Tropeiro, condutor de tropa, arrieiro ou bruaqueiro é a designação dada aos condutores de tropas ou comitivas de muares e cavalos entre as regiões de produção e os centros consumidores no Brasil a partir do século XVII. Mais ao sul do Brasil, também são conhecidos como carreteiros devido às carretas com as quais trabalhavam.</div>
                    </footer>
                </section>
                <img src="sala troperismo.jpg"></img>
            </article>
        </section>
        
        <c:url value="/resources/js/navigation.js" var="navigationjs" />
        <script src="${navigationjs}" type="text/javascript"></script>
    </body>
</html>
