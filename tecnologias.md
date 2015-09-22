---
layout: page
title: Tecnologias
permalink: /tecnologias/
---

A seguir estaremos descrevendo com quais tipos de tecnologias estamos trabalhando, explicando brevemente cada uma delas e por quê escolhemos para a execução de noso projeto.

#Infraestrutura

##Java
A linguagem de programação [Java](https://en.wikipedia.org/wiki/Java_%28programming_language%29), já em seus 20 anos de mercado mantém-se firme entre as linguagens mais utilizadas e robustas do mercado. Como uma linguagem de propósito geral, abrange aplicação no desenvolvimento desde pequenos dispositivos embarcados, até recentemente trabalhos com [IoT (Internet of Things)](http://whatis.techtarget.com/definition/Internet-of-Things), tal portabilidade com que é possível trabalharmos com a linguagem Java podemos atribuir ao conceito WORA (Write Once, Run Anywhere - Escreva uma vez, rode onde quiser), onde podemos escrever uma biblioteca de classes em Java e utilizarmos em qualquer plataforma (desde que a mesma possua uma máquina virtual própria, a chamada [Java Virtual Machine](https://en.wikipedia.org/wiki/List_of_Java_virtual_machines), a JVM). Não obstante a essas e outras especificidades da linguagem, nosso maior motivacional vem sendo a linha de produto de software (LPS) que estaremos utilizando em nosso backend, pois a mesma foi desenvolvida utilizando a linguagem Java. Sendo mais especificos ainda, estaremos trabalhando com a plataforma [Java EE (Enterprise Edition)](https://www.oracle.com/java/technologies/java-ee.html), pois é está edição que nos permite trabalhar com ambientes web.

##lpsmuseum
A [lpsmuseum](https://github.com/guilhermejcgois/lpsmuseum) é uma linha de produto de software (LPS) desenvolvida e mantida pelo [Laboratório de Estudo em Redes, Inovação e Software (LERIS)](http://leris.sor.ufscar.br/) da [Universidade Federal de São Carlos (UFSCar) de Sorocaba](http://www.sorocaba.ufscar.br/ufscar/).

##Glassfish
Um servidor de aplicação basicamente fornece uma maneira de instalarmos instalarmos e acessarmos aplicações web de maneira centralizada, ou seja, a instalação é feita apenas uma vez (no servidor) e o acesso pode ocorrer de qualquer lugar do globo, basta termos a disposição um browser (navegador de internet). O servidor de aplicação a ser utilizado será o [Glassfish](https://glassfish.java.net/). Ele é [Open Source](https://en.wikipedia.org/wiki/Open_source), desenvolvido pela [Oracle](http://www.oracle.com/index.html) e a prórpia comunidade, o [Glassfish](https://glassfish.java.net/) é totalmente compatível com aplicações [Java EE](https://www.oracle.com/java/technologies/java-ee.html), além de já poder ser instalado juntamente com a [IDE Netbeans](https://netbeans.org/). Mas também é de fácil instalação e configuração.

#Desenvolvimento

##MySQL
O [Sistema de Gerenciamento de Banco de Dados (SGBD)](https://pt.wikipedia.org/wiki/Sistema_de_gerenciamento_de_banco_de_dados) que estaremos utilizando é o [MySQL Community Edition](http://www.mysql.com/products/community/), tal escolha não compete a nós, pois a LPS já está configurada para trabalhar com ele. Apenas ressaltamos que há a possibilidade de se trabalhar com outro [SGBD relacional](https://pt.wikipedia.org/wiki/Banco_de_dados_relacional), pois a LPS permite essa adaptação, porém não nos preocuparemos com isso.  

##Netbeans
Com o intuito de ganharmos agilidade e produtividade no desenvolvimento de nosso produto, contamos com um [Ambiente de Desenvolvimento Integrado](https://pt.wikipedia.org/wiki/Ambiente_de_desenvolvimento_integrado), do inglês [Integrated Development Environment (IDE)](https://en.wikipedia.org/wiki/Integrated_development_environment), onde teremos mais integrados todas as ferramentas de desenvolvimento em uma única ferramenta. E a [IDE](https://en.wikipedia.org/wiki/Integrated_development_environment) escolhida foi o [Netbeans](https://netbeans.org/), em sua versão focada para a plataforma [Java EE](https://www.oracle.com/java/technologies/java-ee.html).

##SpringMVC
Na fronteira de nosso backend, estaremos trabalhando com um [framework web](https://en.wikipedia.org/wiki/Web_application_framework), baseado na arquitetura [MVC](https://en.wikipedia.org/wiki/Web_application_framework#Model.E2.80.93view.E2.80.93controller_.28MVC.29) para nos auxiliar no desenvolvimento do projeto. Esse framework é o [Spring MVC](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html), que escolhemos pela sua robustez e a familiaridade do grupo com o mesmo. O [Spring MVC](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) também é atualmente bastante utilizado no mercado, o que nos foi também um atrativo a mais, pois está a bastante tempo no mercado.

##JUnit
Estaremos realizando [testes unitários](https://pt.wikipedia.org/wiki/Teste_de_unidade) no nosso backend. Tais testes nos permitem ir dividindo e isolando as funcionalidades e para tal utilizaremos o [JUnit](http://junit.org/), um framework de testes unitários simples, fácil de aprender e também bastante conhecido e utilizado no mercado.

##Selenium
O [Selenium](http://docs.seleniumhq.org/) é um automatizador de browser, isto é, ele server para a automatização de aplicações web para fins de teste. Nós escolhemos utilizar por nos poupar tempo de testar o frontend de nossa aplicação no que tange para a interação. Além de que o [Selenium](http://docs.seleniumhq.org/) possui suporte para os maiores e mais utilizados browsers do mercado.

##Apache Maven
O [Apache Maven](http://maven.apache.org/) é uma ferramenta de gerenciamento de projeto de software, com ele é possível configurarmos e automatizarmos tarefas como build, teste e até mesmo deploy de aplicação. Além de ele ser também um ótimo gerenciador de dependências.

#Organizacional

##GitHub
Para controle e versionamento de código, vamos trabalhar com o [git](http://www.git-scm.com/), com o auxílio do [GitHub](https://github.com/). O [GitHub](https://github.com/) basicamente funciona como um host de código, rodando em cima do [git](http://www.git-scm.com/), nos possibilitando trabalhar com praticamente tudo que o [git](http://www.git-scm.com/) tem a oferecer. Não obstante, o principal motivo de trabalharmos com ele se deve a experiência do grupo com a ferramenta, além de ser simples e com um curva de aprendizagem consideravelmente baixa, ele é grátis.

##Google Drive
Para não misturarmos documentos (ainda mais rascunhos) com código, resolvemos manter uma pasta compartilhada em nuvem no [Google Drive](http://drive.google.com) com todos os documentos referentes ao projeto, desde rascunhos, questionários para UX Research, até documentos mais técnicos. Dentre as opções disponíveis no mercado ([OneDrive](http://onedrive.live.com/), [Dropbox](http://dropbox.com/), etc.), optamos pelo [Google Drive](http://drive.google.com) devido a sua simplicidade e todos os membros do grupo já possuírem conta no mesmo.

##Trello
O [Trello](https://trello.com/) basicamente é um [kanban](https://en.wikipedia.org/wiki/Kanban) virtual para o gerenciamento de projeto, nele conseguimos saber quem está trabalhando no que e também saber como anda o progresso de cada item de nosso product backlog.

##Skype
O [Skype](http://www.skype.com/) foi a ferramenta de comunicação escolhida pela equipe, pois todos os membros da equipe e o especialista no tema de nosso projeto estão familiarizados com a ferramenta.