package br.ufscar.sor.dcomp.ihc.muvi.controller;

import com.lpsmuseum.service.MuseumService;
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
	private MuseumService museumService;

	public FrontController() {
		museumService = new MuseumService();
	}
	
	@RequestMapping("/")
	public ModelAndView home() {
		modelAndView = new ModelAndView("home");
				
		System.out.println("Inicializando museu...");
		
		modelAndView.addObject("museum", museumService.findById(1L));
		
		return modelAndView;
	}
	
	@RequestMapping("visita-guiada")
	public ModelAndView navegacaoGuiada() {
		modelAndView = new ModelAndView("guided-navigation");
		
		return modelAndView;
	}
	
}
