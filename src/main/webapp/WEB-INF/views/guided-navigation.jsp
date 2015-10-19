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
        <c:url value="/resources/css/menu.css" var="menucss"/>
        <c:url value="/resources/css/navigation.css" var="navigationcss"/>

        <c:url value="/resources/js/DOMUtils.js" var="domutilsjs" />
        <c:url value="/resources/js/menu.js" var="menujs" />
        <c:url value="/resources/js/MUVI.js" var="muvijs" />
        <c:url value="/resources/js/navigation.js" var="navigationjs" />
        
        <link href="${maincss}" rel="stylesheet">
        <link href="${menucss}" rel="stylesheet">
        <link href="${navigationcss}" rel="stylesheet">

    </head>
    <body>
        <%@ include file="../jspf/menu.jspf" %>

        <section id="object-section">
            <nav>
                <ul>
                    <li><div id="backto" class="first hide"><a id="abackto" href="/muvi/visita-guiada/anterior" class="nav-sce-btn">#</a></div></li>
                    <li><div id="state" class="nav-sce-location">${atual} de ${numItems}</div></li>
                    <li><div id="goto"><a id="agoto" href="visita-guiada/proximo" class="nav-sce-btn">#</a></div></li>
                </ul>
            </nav>
            <article>
                <section>
                    <header>
                        <h1 id="title">${items.text.name}</h1>
                    </header>
                    <article id="object-text">
                        <div>${items.text.text}</div>
                        <a id="amore" href="#">Para saber mais...</a>
                    </article>
                    <footer class="hide">
                        <div id="divmore">${items.toKnowMore.text}</div>
                    </footer>
                </section>
                <img id="image" src="${items.image.urlAddress}"></img>
            </article>
        </section>
        
        <script>
            var numItems = ${numItems};
			
			if (${atual} == 1)
				document.getElementById('abackto').href = "/muvi/visita-guiada?scenarioId=" + ${scenarioId - 1};
			else if (${atual} == numItems && ${hasChallenge})
				document.getElementById('abackto').href = "/muvi/visita-guiada/fazer-desafio";
			
        </script>
        <script src="${domutilsjs}" type="text/javascript"></script>
        <script src="${muvijs}" type="text/javascript"></script>
		<script src="${menujs}" type="text/javascript"></script>
        <script src="${navigationjs}" type="text/javascript"></script>
    </body>
</html>
