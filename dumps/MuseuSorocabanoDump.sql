-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: lpsmuseumdb
-- ------------------------------------------------------
-- Server version	5.6.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `annotation`
--

LOCK TABLES `annotation` WRITE;
/*!40000 ALTER TABLE `annotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `annotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `challenge`
--

LOCK TABLES `challenge` WRITE;
/*!40000 ALTER TABLE `challenge` DISABLE KEYS */;
/*!40000 ALTER TABLE `challenge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `challenge_pastpresent_options`
--

LOCK TABLES `challenge_pastpresent_options` WRITE;
/*!40000 ALTER TABLE `challenge_pastpresent_options` DISABLE KEYS */;
/*!40000 ALTER TABLE `challenge_pastpresent_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `museological_object`
--

LOCK TABLES `museological_object` WRITE;
/*!40000 ALTER TABLE `museological_object` DISABLE KEYS */;
INSERT INTO `museological_object` VALUES (33,'TextDO','2010-08-03','Como tudo comecou',1,'\"\"','Antigamente não existiam carros, ônibus ou caminhões. As viagens eram feitas a pé e as cargas   e pessoal eram transportadas nas costas dos escravos índios e negros.'),(34,'TextDO','2010-08-03','Como tudo comecou',1,'\"\"','As poucas cidades viviam isoladas, com dificuldades para adquirir alimentos e outros produtos   de fora e também dificuldades para transportar o que produziam.'),(35,'TextDO','2010-08-03','Como tudo comecou',0,'\"\"','Foi nessa época no final do século XVII, que surgiram os tropeiros.'),(36,'ImageDO','2015-02-26','Como tudo comecou',0,'https://github.com/guilhermejcgois/MUVI/blob/resources/images/Museu%20Quinzinho.jpg','\"\"'),(37,'TextDO','2014-05-04','O tropeiro',1,'\"\"','O tropeiro trabalhava na condução e comércio de muares. Os muares são as mulas e burros,   resultado do cruzamento da égua com o jumento, a mula é a fêmea e o burro o macho. Ambos   são estéreis (não podem se reproduzir).'),(38,'TextDO','2014-05-04','O tropeiro',1,'\"\"','Os muares são animais muito resistentes. Carregam maior carga do que o cavalo e aguentam   viajar por mais tempo e em estradas difíceis. Por esse motivo os muares ficaram muito   conhecidos.'),(39,'TextDO','2014-05-04','O tropeiro',0,'\"\"','O tropeiro trazia os muares do Sul e para aproveitar a viajem também transportavam cargas e   pessoas que gostavam de viajar junto com as tropas.'),(40,'ImageDO','2014-05-04','O tropeiro',0,'https://github.com/guilhermejcgois/MUVI/blob/resources/images/aparatos.jpg',''),(44,'TextDO','2012-06-03','O traje',1,'','O tropeiro em suas viagens usava roupas comuns: calça, camisa, lenço, um chapéu de aba larga para se proteger do sol e da chuva, um cinto de couro com vários bolsos chamados de guaiacas, para guardar dinheiro e botas.'),(45,'TextDO','2012-06-03','O traje',0,'','Nos dias de chuva e frio usava uma capa ou um  poncho que chegava a cobrir até a montaria. E também seu facão, esporas e relho que não   podiam faltar.'),(46,'ImageDO','2012-06-03','O traje',0,'https://github.com/guilhermejcgois/MUVI/blob/resources/images/traje.jpg',''),(47,'TextDO','2014-04-22','A tropa',1,'','A tropa era formada pela tropa xucra ou solta, que eram os animais trazidos do Sul para serem vendidos nas feiras de Sorocaba.'),(48,'TextDO','2014-04-22','A tropa',1,'','A tropa arreada ou cargueira eram os animais que levavam as  mercadorias a serem comercializadas e os suprimentos para a tropa.'),(49,'TextDO','2014-04-22','A tropa',0,'','Além do tropeiro (chefe da tropa), o capataz, os tocadores ou tangedores, e ajudavam a guiar a tropa, os camaradas ou peões e o cozinheiro ajudavam a compor a tropa.'),(50,'ImageDO','2014-04-22','A tropa',0,'https://github.com/guilhermejcgois/MUVI/blob/resources/images/a%20tropa.jpg',''),(51,'TextDO','2010-08-03','A viagem',1,'','Os homens partiam com destino a Viamão, no Rio Grande do Sul. No caminho enfrentavam grandes desafios, não havia estradas, poucas pontes, e muitos perigos.'),(52,'TextDO','2010-08-03','A viagem',0,'','Animais selvagens, trechos de montanhas, despenhadeiros, mata fechada, atoleiros, rios perigosos, índios e ladrões eram perigos constantes nas viagens.'),(53,'ImageDO','2010-08-03','A viagem',0,'https://github.com/guilhermejcgois/MUVI/blob/resources/images/Mapa%20tropeiro.jpg',''),(54,'TextDO','2012-06-12','O pouso',1,'','Durante a viagem havia paradas chamadas de pouso, onde os tropeiros descansavam, comiam   e dormiam.'),(55,'TextDO','2012-06-12','O pouso',0,'','Ao longo do tempo os pousos foram crescendo e tornaram-se cidades como é o  caso de Itapetininga, Itapeva, Itararé, Buri e Alambari no estado de São Paulo e muitas outras   em Santa Catarina e Rio Grande do Sul.'),(56,'ImageDO','2012-06-12','O pouso',0,'https://github.com/guilhermejcgois/MUVI/blob/resources/images/pouso.jpg',''),(57,'TextDO','2014-05-04','As feiras',1,'','As feiras eram bem diferentes das de hoje, o comércio era principalmente de animais, mulas,   burros, cavalos, gado e porcos.'),(58,'TextDO','2014-05-04','As feiras',1,'','Mas também havia um pequeno comércio de artesanato,  facões sorocabanos, facas, arreios, selas, botas, redes e objetos decorativos produzidos em   Sorocaba.'),(59,'TextDO','2014-05-04','As feiras',1,'','Vinham compradores de todo o Brasil. A cidade se transformava em uma grande festa, com   vendedores e compradores, circo de cavalinha, músicos e artesãos.'),(60,'TextDO','2014-05-04','As feiras',1,'','Eram tantos animais sendo comercializados que o governo criou o Registro de Animais, um   tipo de pedágio cobrando imposto de cada animal que passasse pela ponte do rio Sorocaba.'),(61,'TextDO','2014-05-04','As feiras',0,'','As feiras foram se acabando com o tempo, devido à construção de estradas de ferro. A última   feira aconteceu em 1897.'),(62,'ImageDO','2014-05-04','As feiras',0,'https://github.com/guilhermejcgois/MUVI/blob/resources/images/tropa2.jpg','');
/*!40000 ALTER TABLE `museological_object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `museum`
--

LOCK TABLES `museum` WRITE;
/*!40000 ALTER TABLE `museum` DISABLE KEYS */;
INSERT INTO `museum` VALUES (1,'Museu Sorocabano');
/*!40000 ALTER TABLE `museum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `scenario`
--

LOCK TABLES `scenario` WRITE;
/*!40000 ALTER TABLE `scenario` DISABLE KEYS */;
INSERT INTO `scenario` VALUES (1,'ScenarioDO','Como tudo começou',1,1),(2,'ScenarioDO','O tropeiro',1,1),(3,'ScenarioDO','O traje de Tropeiro',1,1),(4,'ScenarioDO','A tropa',1,1),(5,'ScenarioDO','A viagem',1,1),(6,'ScenarioDO','O pouso',1,1),(7,'ScenarioDO','As feiras de Sorocaba',1,1);
/*!40000 ALTER TABLE `scenario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `scenario_object`
--

LOCK TABLES `scenario_object` WRITE;
/*!40000 ALTER TABLE `scenario_object` DISABLE KEYS */;
INSERT INTO `scenario_object` VALUES (1,33),(1,34),(1,35),(1,36),(2,37),(2,38),(2,39),(2,40),(3,44),(3,45),(3,46),(4,47),(4,48),(4,49),(4,50),(5,51),(5,52),(5,53),(6,54),(6,55),(6,56),(7,57),(7,58),(7,59),(7,60),(7,61),(7,62);
/*!40000 ALTER TABLE `scenario_object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `theme`
--

LOCK TABLES `theme` WRITE;
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
INSERT INTO `theme` VALUES (1,'Movimento itinerante de tropeiros durante a época colinial brasileira.','Tropeirimos');
/*!40000 ALTER TABLE `theme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `userdo`
--

LOCK TABLES `userdo` WRITE;
/*!40000 ALTER TABLE `userdo` DISABLE KEYS */;
/*!40000 ALTER TABLE `userdo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-19 16:11:27
