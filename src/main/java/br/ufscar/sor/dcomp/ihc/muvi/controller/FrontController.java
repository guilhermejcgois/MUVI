package br.ufscar.sor.dcomp.ihc.muvi.controller;

import br.ufscar.sor.dcomp.ihc.muvi.model.NavigationItem;
import br.ufscar.sor.dcomp.ihc.muvi.util.NavigationUtil;
import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.scenario.ScenarioChallenge;
import com.lpsmuseum.service.MuseumService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Guilherme JC Gois
 */
@Controller
public class FrontController {

	private ModelAndView modelAndView;
	private static Museum museum;
	private final MuseumService museumService;
	private List<NavigationItem> navigationItems;
	private int navigationIndex;
	private int scenarioAtual;

	public FrontController() {
		museumService = new MuseumService();
	}

	@RequestMapping("/")
	public ModelAndView home() throws Exception {
		modelAndView = new ModelAndView("home");

		System.out.println("Inicializando museu...");

		museum = museumService.findById(1L);
		modelAndView.addObject("museum", museum);
		//modelAndView.addObject("museum", new Museum("Museu", new ArrayList<Scenario>()));

		return modelAndView;
	}

	@RequestMapping("visita-guiada")
	public ModelAndView navegacaoGuiada(Long scenarioId) {
		modelAndView = new ModelAndView("guided-navigation");

		System.out.println("Iniciando navegaçao guiada...");

		Scenario scenario = null;
		for (Scenario sc : museum.getScenarios()) {
			if (sc.getId() == scenarioId) {
				scenario = sc;
				break;
			}
		}

		navigationItems = NavigationUtil.arrangeData(scenario.getObjects());
		navigationIndex = -1;

		System.out.println(navigationItems.size());

		modelAndView.addObject("numItems", navigationItems.size());
		modelAndView.addObject("museum", museum);
		modelAndView.addObject("items", navigationItems.get(++navigationIndex));
		System.out.println(navigationItems.get(navigationIndex).getImage().getUrlAddress());
		modelAndView.addObject("atual", navigationIndex + 1);
		modelAndView.addObject("scenarioId", scenarioAtual = scenarioId.intValue());
		modelAndView.addObject("hasChallenge", museum.getScenarios().get(scenarioAtual) instanceof ScenarioChallenge);

		return modelAndView;
	}

	@RequestMapping("visita-guiada/proximo")
	/*@ResponseBody
	 public NavigationItem next() {
	 return navigationItems.get(++navigationIndex);
	 }*/
	public ModelAndView next() {
		modelAndView = new ModelAndView("guided-navigation");

		System.out.println("Indo para os próximos objetos...");

		if ((navigationIndex + 1) < navigationItems.size()) {
			System.out.println("Indo para os próximos objetos...");
			modelAndView.addObject("numItems", navigationItems.size());
			modelAndView.addObject("museum", museum);
			modelAndView.addObject("items", navigationItems.get(++navigationIndex));
			modelAndView.addObject("atual", navigationIndex + 1);
			modelAndView.addObject("scenarioId", scenarioAtual);
			modelAndView.addObject("hasChallenge", museum.getScenarios().get(scenarioAtual) instanceof ScenarioChallenge);
		}

		return modelAndView;
	}

	@RequestMapping("visita-guiada/anterior")
	/*@ResponseBody
	 public NavigationItem back() {
	 return navigationItems.get(--navigationIndex);
	 }*/
	public ModelAndView back() {
		modelAndView = new ModelAndView("guided-navigation");

		System.out.println("Indo para os objetos anteriores...");

		if (navigationIndex > 0) {
			modelAndView.addObject("numItems", navigationItems.size());
			modelAndView.addObject("museum", museum);
			modelAndView.addObject("items", navigationItems.get(--navigationIndex));
			modelAndView.addObject("atual", navigationIndex + 1);
			modelAndView.addObject("scenarioId", scenarioAtual);
			modelAndView.addObject("hasChallenge", museum.getScenarios().get(scenarioAtual) instanceof ScenarioChallenge);
		}

		return modelAndView;
	}

	@RequestMapping("visita-guiada/fazer-desafio")
	public ModelAndView cenarioComDesafioFinalizado() {
		modelAndView = new ModelAndView("notice");

		System.out.println("O cenario acabou...");

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
		modelAndView = new ModelAndView("notice");

		System.out.println("O cenario acabou...");

		modelAndView.addObject("title", "Sua visita por aqui acabou!");
		modelAndView.addObject("text", "Você completou com êxito sua última vi"
				+ "sita ao cenário " + museum.getScenarios().get(scenarioAtual).getName() + ", parabéns.");
		Map<String, String> actions = new HashMap<String, String>();
		actions.put("Continuar", "/muvi/visita-guiada?scenarioId=" + (scenarioAtual + 1));
		modelAndView.addObject("actions", actions);

		return modelAndView;
	}

}
