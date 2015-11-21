package br.ufscar.sor.dcomp.ihc.muvi.controller;

import br.ufscar.sor.dcomp.ihc.muvi.model.MuviMuseum;
import br.ufscar.sor.dcomp.ihc.muvi.util.NavigationUtil;
import com.lpsmuseum.behaviour.museum.navigation.AleatoryNavigation;
import com.lpsmuseum.behaviour.museum.navigation.GuidedNavigation;
import com.lpsmuseum.behaviour.museum.navigation.Node;
import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.object.Text;
import com.lpsmuseum.service.MuseumService;
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
		museum = new MuviMuseum(museumService.listMuseum().get(0));
		modelAndView.addObject("museum", museum);
		
		numItems = museum.getScenarios().size();
		
		System.out.println("--------------------- Museum ---------------------------");
		System.out.println("Id\t\t: " + museum.getId());
		System.out.println("Nome\t\t: " + museum.getName());
		for (Scenario scenario : museum.getScenarios()) {
			System.out.println("Cenários\t:" + scenario.getId() + " - " + scenario.getName() + "(" + scenario.getTheme().getTitle() + ")");
			for (MuseologicalObject object : scenario.getObjects()) {
				if (object instanceof Image)
					System.out.println("\t\t" + object.getId() + " - " + object.getName() + "I(" + ((Image) object).getUrlAddress() + ")");
				else if (object instanceof Text)
					System.out.println("\t\t" + object.getId() + " - " + object.getName() + "T(" + ((Text) object).getText() + ")");
				else
					System.out.println("ERROR");
			}
		}
		System.out.println("------------------------------------------------");

		return modelAndView;
	}

	@RequestMapping("navegar")
	public ModelAndView navegar(HttpServletRequest request, String mode) {
		String view;

		System.out.println("Iniciando navegação em modo '"+ mode + "'...");
		
		Node navigationNode = null;
		if (mode.equals("aleatory")) {
			museum.setNavigation(new AleatoryNavigation());
			view = "aleatory-navigation";
		} else if (mode.equals("guided")) {
			museum.setNavigation(new GuidedNavigation());
			view = "guided-navigation";
		} else {
			throw new IllegalArgumentException("Sorry, but the mode '" + mode 
					+ "' is not allowed to navigation. Do you choose the "
					+ "navigation's mode in our home page?");
		}
		navigationNode = museum.navigate();
		
		request.getSession(true).setAttribute("navigationNode", navigationNode);

		return NavigationUtil.getModelAndView(view, museum, navigationNode);
	}

}
