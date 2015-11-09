package br.ufscar.sor.dcomp.ihc.muvi.controller;

import br.ufscar.sor.dcomp.ihc.muvi.model.MuviMuseum;
import com.lpsmuseum.behaviour.museum.navigation.GuidedNavigation;
import com.lpsmuseum.behaviour.museum.navigation.Node;
import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.service.MuseumService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
//@RestController
public class NavigationController {
	
	private Node noAtual = new MuviMuseum(new MuseumService().findById(1L)).navigate();
	
	@RequestMapping("navegar/proximo")
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
	}
}
