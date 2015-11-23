package br.ufscar.sor.dcomp.ihc.muvi.view.util;

import java.util.HashMap;

/**
 *
 * @author USER
 */
public class ExpectedMap extends HashMap<String, Object> {
	
	private static ExpectedMap instance = null;
	
	public static ExpectedMap get() {
		if (instance == null)
			instance = new ExpectedMap();
		
		return instance;
	}

	private ExpectedMap() {
		put("title", "MUVI - Home");
		put("museumName", "Lei de Diretrizes e Base");
		put("aclass", "button button-home");
		put("paleatory", "Aleatória");
		put("pguided", "Guiada");
		put("titleAleatory", "MUVI - Visita Aleatória");
		put("titleGuided", "MUVI - Visita Guiada");
	}
	
}
