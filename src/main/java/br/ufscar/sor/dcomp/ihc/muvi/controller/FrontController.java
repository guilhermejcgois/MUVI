package br.ufscar.sor.dcomp.ihc.muvi.controller;

import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.service.MuseumService;
import com.lpsmuseum.service.builders.MuseumBuilder;
import java.util.ArrayList;
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
	public ModelAndView home() throws Exception {
		modelAndView = new ModelAndView("home");
				
		System.out.println("Inicializando museu...");
		
		//modelAndView.addObject("museum", museumService.findById(1L));
		modelAndView.addObject("museum", new Museum("Museu", new ArrayList<Scenario>()));
		
		return modelAndView;
	}
	
	@RequestMapping("visita-guiada")
	public ModelAndView navegacaoGuiada() {
		modelAndView = new ModelAndView("guided-navigation");
                
                System.out.println("Iniciando navegaçao guiada...");
		
		return modelAndView;
	}
        
        @RequestMapping("visita-guiada/fazer-desafio")
        public ModelAndView cenarioFinalizado() {
            modelAndView = new ModelAndView("notice");
            
            System.out.println("O cenario acabou...");
            
            return modelAndView;
        }
	
}
