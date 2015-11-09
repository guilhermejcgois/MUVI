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

		<c:url value="/resources/css/challenge.css" var="challengecss"/>
		<c:url value="/resources/css/main.css" var="maincss"/>
		<c:url value="/resources/css/menu.css" var="menucss"/>
		<c:url value="/resources/css/navigation.css" var="navigationcss"/>

		<c:url value="/resources/js/challenge.js" var="challengejs" />
		<c:url value="/resources/js/DOMUtils.js" var="domutilsjs" />
		<c:url value="/resources/js/menu.js" var="menujs" />
		<c:url value="/resources/js/MUVI.js" var="muvijs" />
		<c:url value="/resources/js/navigation.js" var="navigationjs" />

		<link href="${challengecss}" rel="stylesheet">
		<link href="${maincss}" rel="stylesheet">
		<link href="${menucss}" rel="stylesheet">
		<link href="${navigationcss}" rel="stylesheet">

	</head>
	<body>
		<%@ include file="../jspf/menu.jspf" %>

		<section id="object-section">
			<nav>
				<ul>
					<li><div id="backto" class="button <c:if test="${!hasPrevious}">hide</c:if>"><a id="abackto" href="/muvi/navegar/anterior" class="nav-sce-btn">#</a></div></li>
					<li><div id="state" class="nav-sce-location">${atual} de ${numItems}</div></li>
					<li><div id="goto" class=" button <c:if test="${!hasNext}">hide</c:if>"><a id="agoto" href="/muvi/navegar/proximo" class="nav-sce-btn">#</a></div></li>
					</ul>
				</nav>
				<article>
					<section>
						<header>
							<h1 id="title">${items.text.name}</h1>
					</header>
					<article id="object-text">
						<div>${items.text.text}</div>
						<a id="amore" href="#">Saiba mais...</a>
					</article>
					<footer class="hide">
						<div id="divmore">${items.toKnowMore.text}</div>
					</footer>
				</section>
				<img id="image" src="${items.image.urlAddress}"/>
				<c:if test="${navigationNode.scenario.class.name == 'com.lpsmuseum.dto.scenario.ScenarioChallenge'}">
					<div id="challenge"><a class="button">Desafio</a></div>
				</c:if>
			</article>
		</section>

		<style>
			#challenge {
				position: absolute;
				left: 49%;
				bottom: 10%;
				height: 20%;
				width: 45%;
			}
			#challenge span {
				margin: 0;
				height: 100%;
				width: 100%;
				padding: 5% 0;
			}
			#challenge a {
				vertical-align: middle;
				font-size: 72px;
				height: 100%;
				width: 100%;
				display: inline-block;
			}
			.doneAndCorrect {
				background-color: #45ff89;
			}
			.doneAndWrong {
				background-color: #ab0000;
			}
			.doneAndWrong:hover {
				background-color: #bc0000;
			}
			.doneAndWrong:active {
				background-color: #890000;
			}
			.disabled {
				background-color: gray;
			}
		</style>

		<c:if test="${navigationNode.scenario.class.name == 'com.lpsmuseum.dto.scenario.ScenarioChallenge'}">
			<%@ include file="../jspf/challenge.jspf" %>
		</c:if>

		<script src="${domutilsjs}" type="text/javascript"></script>
		<script src="${muvijs}" type="text/javascript"></script>
		<script src="${menujs}" type="text/javascript"></script>
		<script src="${navigationjs}" type="text/javascript"></script>
		<script src="${challengejs}" type="text/javascript"></script>

		<script>
			MUVI.keyboard(
					function () {
						console.log('left');
						document.getElementById('abackto').click();
					},
					function () {
						console.log('right');
						document.getElementById('agoto').click()
					}
			);

			document.getElementById('challenge').addEventListener("click", function (event) {
				console.log('challenge click');

				DOMUtils.removeClass(document.getElementById('challenge-section'), "hide");

				var cancelButton = document.getElementById('challenge-cancel');
				if (DOMUtils.containClass(cancelButton, "disabled")) {
					DOMUtils.removeClass(cancelButton, "disabled");
					cancelButton.addEventListener("click", cancelListener);

					for (var i = 0; i < alternativesdiv.length; i++) {
						console.log('Adding event listener to alternative ' + i);
						alternativesdiv[i].addEventListener("click", alternativeClicked);
					}
				}
			});

			function alternativeClicked(event) {
				var target = event.target || event.srcElement;

				for (var i = 0; i < alternativesdiv.length; i++)
					if (alternativesdiv[i] === target)
						if (DOMUtils.containClass(target, "selected"))
							DOMUtils.removeClass(target, "selected");
						else
							DOMUtils.addClass(target, "selected");
					else if (DOMUtils.containClass(alternativesdiv[i], "selected"))
						DOMUtils.removeClass(alternativesdiv[i], "selected");
			}
			;

			var alternativesdiv = document.getElementsByClassName('alternative');
			for (var i = 0; i < alternativesdiv.length; i++) {
				console.log('Adding event listener to alternative ' + i);
				alternativesdiv[i].addEventListener("click", alternativeClicked);
			}
			;

			var cancelListener = function (event) {
				console.log('challenge cancelado!');

				DOMUtils.addClass(document.getElementById('challenge-section'), "hide");
				DOMUtils.addClass(document.getElementById('challenge').children[0], "doneAndWrong");
			};

			document.getElementById('challenge-cancel').addEventListener("click", cancelListener);

			document.getElementById('challenge-done').addEventListener("click", function (event) {
				console.log('Challenge done!');

				var target = (event.target || event.srcElement);
				var challengebutton = document.getElementById('challenge').children[0];
				if (DOMUtils.containClass(target, "verified")) {
					DOMUtils.addClass(document.getElementById('challenge-section'), "hide");
				} else {
					for (i = 0; i < alternativesdiv.length; i++) {
						if (DOMUtils.containClass(alternativesdiv[i], "wrong"))
							DOMUtils.removeClass(alternativesdiv[i], "wrong");
						if (DOMUtils.containClass(alternativesdiv[i], "selected")) {
							if (alternativesdiv[i].children[0].innerHTML === '${challenge.correctAnswer.description}') {
								if (DOMUtils.containClass(alternativesdiv[i], "wrong"))
									DOMUtils.removeClass(alternativesdiv[i], "wrong")
								if (!DOMUtils.containClass(alternativesdiv[i], "correct"))
									DOMUtils.addClass(alternativesdiv[i], "correct");
								if (DOMUtils.containClass(challengebutton, "doneAndWrong"))
									DOMUtils.removeClass(challengebutton, "doneAndWrong");
								if (!DOMUtils.containClass(challengebutton, "doneAndCorrect"))
									DOMUtils.addClass(challengebutton, "doneAndCorrect");
								target.innerHTML = 'Finalizar';

								DOMUtils.addClass(document.getElementById('challenge-cancel'), "disabled");
								document.getElementById('challenge-cancel').removeEventListener(cancelListener);
								for (var i = 0; i < alternativesdiv.length; i++) {
									console.log('Adding event listener to alternative ' + i);
									alternativesdiv[i].removeEventListener("click", alternativeClicked);
								}
							} else {
								if (DOMUtils.containClass(alternativesdiv[i], "correct"))
									DOMUtils.removeClass(alternativesdiv[i], "correct")
								if (!DOMUtils.containClass(alternativesdiv[i], "wrong"))
									DOMUtils.addClass(alternativesdiv[i], "wrong");
								if (DOMUtils.containClass(challengebutton, "doneAndCorrect"))
									DOMUtils.removeClass(challengebutton, "doneAndCorrect");
								if (!DOMUtils.containClass(challengebutton, "doneAndWrong"))
									DOMUtils.addClass(challengebutton, "doneAndWrong");

								DOMUtils.removeClass(document.getElementById('challenge-cancel'), "disabled");
								document.getElementById('challenge-cancel').addEventListener(cancelListener);
								for (var i = 0; i < alternativesdiv.length; i++) {
									console.log('Adding event listener to alternative ' + i);
									alternativesdiv[i].addEventListener("click", alternativeClicked);
								}
							}
						} else if (DOMUtils.containClass(alternativesdiv[i], "wrong"))
							DOMUtils.removeClass(alternativesdiv[i], "wrong");
					}
				}
			});
		</script>
	</body>
</html>
