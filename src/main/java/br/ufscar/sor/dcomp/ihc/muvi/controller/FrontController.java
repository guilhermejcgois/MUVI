package br.ufscar.sor.dcomp.ihc.muvi.controller;

import br.ufscar.sor.dcomp.ihc.muvi.model.MuviMuseum;
import br.ufscar.sor.dcomp.ihc.muvi.model.NavigationItem;
import com.lpsmuseum.behaviour.museum.navigation.AleatoryNavigation;
import com.lpsmuseum.behaviour.museum.navigation.GuidedNavigation;
import com.lpsmuseum.behaviour.museum.navigation.Node;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.service.MuseumService;
import com.lpsmuseum.service.ScenarioService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Guilherme JC Gois
 */
@Controller
public class FrontController {

	private MuviMuseum museum;
	private final MuseumService museumService;
	private int numItems;

	public FrontController() {
		museumService = new MuseumService();
	}

	@RequestMapping("/")
	public ModelAndView home() throws Exception {
		ModelAndView modelAndView = new ModelAndView("home");

		System.out.println("Inicializando museu...");
		
		/*
		Achamos que a interface de Museum para uso poderia ser um pouco melhor, 
		tais possíveis melhorias foram feitas na especialização em MuviMuseum, 
		fizemos issso para não mexer diretamente na linha.
		FIX Gambiarra.
		*/
		museum = new MuviMuseum(museumService.findById(1L));
		modelAndView.addObject("museum", museum);
		
		numItems = museum.getScenarios().size();

		return modelAndView;
	}

	@RequestMapping("navegar")
	public ModelAndView navegar(HttpServletRequest request, String mode) {

		ModelAndView modelAndView = null;

		System.out.println("Iniciando navegação em modo '"+ mode + "'...");
		
		Node navigationNode = null;
		if (mode.equals("aleatory")) {
			museum.setNavigation(new AleatoryNavigation());
			modelAndView = new ModelAndView("aleatory-navigation");
		} else if (mode.equals("guided")) {
			museum.setNavigation(new GuidedNavigation());
			modelAndView = new ModelAndView("guided-navigation");
		} else {
			throw new IllegalArgumentException("Sorry, but the mode '" + mode 
					+ "' is not allowed to navigation. Do you choose the "
					+ "navigation's mode in our home page?");
		}
		navigationNode = museum.navigate();
		
		request.getSession(true).setAttribute("navigationNode", navigationNode);
		modelAndView.addObject("navigationNode", navigationNode);
		modelAndView.addObject("items", new NavigationItem(navigationNode.getScenario()));
		modelAndView.addObject("hasNext", true);
		modelAndView.addObject("hasPrevious", false);
		modelAndView.addObject("atual", getCurrentIndex(navigationNode));
		modelAndView.addObject("numItems", numItems);

		return modelAndView;
	}

	@RequestMapping("navegar/proximo")
	public ModelAndView next(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("guided-navigation");

		System.out.println("Indo para o próximo cenário...");
		
		Node navigationNode = (Node) request.getSession().getAttribute("navigationNode");
		navigationNode = navigationNode.getNeighbor();
		request.getSession().setAttribute("navigationNode", navigationNode);
		
		modelAndView.addObject("navigationNode", navigationNode);
		modelAndView.addObject("items", new NavigationItem(navigationNode.getScenario()));
		modelAndView.addObject("hasNext", navigationNode.getNeighbor().getScenario() != null);
		modelAndView.addObject("hasPrevious", true);
		modelAndView.addObject("atual", getCurrentIndex(navigationNode));
		modelAndView.addObject("numItems", numItems);

		return modelAndView;
	}

	@RequestMapping("navegar/anterior")
	public ModelAndView back(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("guided-navigation");

		System.out.println("Indo para os objetos anteriores...");

		
		Node navigationNode = (Node) request.getSession().getAttribute("navigationNode");
		navigationNode = navigationNode.doBacktrack();
		request.getSession().setAttribute("navigationNode", navigationNode);
		
		modelAndView.addObject("navigationNode", navigationNode);
		modelAndView.addObject("items", new NavigationItem(navigationNode.getScenario()));
		modelAndView.addObject("hasNext", true);
		modelAndView.addObject("hasPrevious", navigationNode.doBacktrack() != null);
		modelAndView.addObject("atual", getCurrentIndex(navigationNode));
		modelAndView.addObject("numItems", numItems);

		return modelAndView;
	}

	/*@RequestMapping("visita-guiada/fazer-desafio")
	public ModelAndView cenarioComDesafioFinalizado() {
		ModelAndView modelAndView = new ModelAndView("notice");

		//System.out.println("O cenario acabou...");

		modelAndView.addObject("title", "Vamos testar seus conhecimentos?");
		modelAndView.addObject("text", "Você concluiu a navegação pelo cená"
				+ "rio" + museum.getScenarios().get(scenarioAtual).getName()
				+ " do museu, que legal! Gostaria de testar seus novos conhe"
				+ "cimentos adquiridos nessa visita?");
		Map<String, String> actions = new HashMap<String, String>();
		actions.put("Quero", "/muvi/desafio?scenarioId=" + scenarioAtual);
		actions.put("Não Quero", "/muvi/visita-guiada?scenarioId=" + (scenarioAtual + 1));
		modelAndView.addObject("actions", actions);

		return modelAndView;
	}

	@RequestMapping("visita-guiada/cenario-terminado")
	public ModelAndView cenarioSemDesafioFinalizado() {
		ModelAndView modelAndView = new ModelAndView("notice");

		//System.out.println("O cenario acabou...");

		modelAndView.addObject("title", "Sua visita por aqui acabou!");
		modelAndView.addObject("text", "Você completou com êxito sua última vi"
				+ "sita ao cenário " + museum.getScenarios().get(scenarioAtual).getName() + ", parabéns.");
		Map<String, String> actions = new HashMap<String, String>();
		actions.put("Continuar", "/muvi/visita-guiada?scenarioId=" + (scenarioAtual + 1));
		modelAndView.addObject("actions", actions);

		return modelAndView;
	}*/
	
	@SuppressWarnings("empty-statement")
	public int getCurrentIndex(Node node) {
		int i = 0;
		
		for (List<Scenario> scenarios = museum.getScenarios(); i < scenarios.size(); i++) {
			if (scenarios.get(i).getId() == node.getScenario().getId())
				break;
		}
		
		return i;//museum.getScenarios().indexOf(node.getScenario());
	}

}
