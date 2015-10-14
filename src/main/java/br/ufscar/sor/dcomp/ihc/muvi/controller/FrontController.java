package br.ufscar.sor.dcomp.ihc.muvi.controller;

import br.ufscar.sor.dcomp.ihc.muvi.model.NavigationItem;
import br.ufscar.sor.dcomp.ihc.muvi.util.NavigationUtil;
import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.service.MuseumService;
import com.lpsmuseum.service.ScenarioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Guilherme JC Gois
 */
@Controller
public class FrontController {

    private ModelAndView modelAndView;
    private Museum museum;
    private final MuseumService museumService;
    private List<NavigationItem> navigationItems;
    private int navigationIndex;

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
    public ModelAndView navegacaoGuiada(String scenarioName) {
        modelAndView = new ModelAndView("guided-navigation");

        System.out.println("Iniciando navegaçao guiada...");

        Scenario scenario = null;
        for (Scenario sc : museum.getScenarios()) {
            if (sc.getName().equals(scenarioName)) {
                scenario = sc;
                break;
            }
        }
        
        navigationItems = NavigationUtil.arrangeData(scenario.getObjects());
        navigationIndex = -1;
        
        modelAndView.addObject("numItems", navigationItems.size());

        return modelAndView;
    }

    @RequestMapping("visita-guiada/{acao}")
    @ResponseBody
    public NavigationItem getNavigationItem(@PathVariable String acao) {
        if (acao.equals("next"))
            return navigationItems.get(++navigationIndex);
        else if (acao.equals("back"))
            return navigationItems.get(--navigationIndex);
        return null;
    }

    @RequestMapping("visita-guiada/fazer-desafio")
    public ModelAndView cenarioFinalizado() {
        modelAndView = new ModelAndView("notice");

        System.out.println("O cenario acabou...");

        return modelAndView;
    }

}
