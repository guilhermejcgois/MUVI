package br.ufscar.sor.dcomp.ihc.muvi.controller;

import br.ufscar.sor.dcomp.ihc.muvi.model.MuviMuseum;
import br.ufscar.sor.dcomp.ihc.muvi.util.NavigationUtil;
import com.lpsmuseum.behaviour.museum.navigation.Node;
import com.lpsmuseum.service.MuseumService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author USER
 */
@Controller
public class AleatoryNavigationController {
	
	private MuviMuseum museum;
	private String view;

	public AleatoryNavigationController() {
		museum = new MuviMuseum(new MuseumService().listMuseum().get(0));
		view = "aleatory-navigation";
	}

	@RequestMapping("navegar/a/proximo")
	public ModelAndView next(HttpServletRequest request) {
		System.out.println("Indo para o próximo cenário...");
		
		Node navigationNode = (Node) request.getSession().getAttribute("navigationNode");
		navigationNode = navigationNode.getNeighbor();
		request.getSession().setAttribute("navigationNode", navigationNode);
		
		return NavigationUtil.getModelAndView(view, museum, navigationNode);
	}

	@RequestMapping("navegar/a/anterior")
	public ModelAndView back(HttpServletRequest request) {
		System.out.println("Indo para o cenário anterior...");
		
		Node navigationNode = (Node) request.getSession().getAttribute("navigationNode");
		navigationNode = navigationNode.doBacktrack();
		request.getSession().setAttribute("navigationNode", navigationNode);
		
		return NavigationUtil.getModelAndView(view, museum, navigationNode);
	}
	
	@RequestMapping("navegar/a/ir")
	public ModelAndView goToScenario(HttpServletRequest request, @RequestParam(value = "para") Long scenarioId) {
		System.out.println("Indo para o cenário de id " + scenarioId);
		
		Node navigationNode = (Node) request.getSession().getAttribute("navigationNode");
		
		if (navigationNode.getScenario().getId() < scenarioId)
			while (navigationNode.getScenario().getId() != scenarioId)
				navigationNode = navigationNode.getNeighbor();
		else
			while (navigationNode.getScenario().getId() != scenarioId)
				navigationNode = navigationNode.doBacktrack();
		
		request.getSession().setAttribute("navigationNode", navigationNode);
		
		return NavigationUtil.getModelAndView(view, museum, navigationNode);
	}
}
