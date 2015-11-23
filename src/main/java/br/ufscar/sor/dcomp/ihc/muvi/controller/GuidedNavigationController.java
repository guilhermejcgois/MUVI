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
public class GuidedNavigationController {
	
	private MuviMuseum museum;
	private String view;

	public GuidedNavigationController() {
		museum = new MuviMuseum(new MuseumService().listMuseum().get(0));
		view = "guided-navigation";
	}

	@RequestMapping("navegar/g/proximo")
	public ModelAndView next(HttpServletRequest request, @RequestParam(required = false) Node node) {
		System.out.println("Indo para o próximo cenário...");
		
		Node navigationNode = (node != null) ? node : (Node) request.getSession().getAttribute("navigationNode");
		navigationNode = navigationNode.getNeighbor();
		//request.getSession().setAttribute("navigationNode", navigationNode);
		
		return NavigationUtil.getModelAndView(view, museum, navigationNode);
	}

	@RequestMapping("navegar/g/anterior")
	public ModelAndView back(HttpServletRequest request, @RequestParam(required = false) Node node) {
		System.out.println("Indo para o cenário anterior...");
		
		Node navigationNode = (node != null) ? node : (Node) request.getSession().getAttribute("navigationNode");
		navigationNode = navigationNode.doBacktrack();
		//request.getSession().setAttribute("navigationNode", navigationNode);
		
		return NavigationUtil.getModelAndView(view, museum, navigationNode);
	}
	
	/*@RequestMapping("navegar/proximo")
	public Scenario proximo() {
		if (noAtual == null) {
			Museum m = new MuseumService().findById(1L);
			MuviMuseum mm = new MuviMuseum(m);
			mm.setNavigation(new GuidedNavigation());
			noAtual = mm.navigate();
		}else
			noAtual = noAtual.getNeighbor();
		
		return noAtual.getScenario();
	}
	
	@RequestMapping("navegar/anterior")
	public Scenario anterior() {
		if (noAtual == null)
			noAtual = new MuviMuseum(new MuseumService().findById(1L)).navigate();
		else
			noAtual = noAtual.doBacktrack();
		
		return noAtual.getScenario();
	}*/
}
