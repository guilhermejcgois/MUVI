package br.ufscar.sor.dcomp.ihc.muvi.util;

import br.ufscar.sor.dcomp.ihc.muvi.model.NavigationItem;
import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.object.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gois
 */
public class NavigationUtil {

	public static List<NavigationItem> arrangeData(List<MuseologicalObject> museologicalObjects) {
		List<NavigationItem> navigationItems;

		navigationItems = new ArrayList<NavigationItem>();

		for (MuseologicalObject museologicalObject : museologicalObjects) {
			boolean notNew = false;
			if (museologicalObject instanceof Image)
			System.out.println("img: " + museologicalObject.getName());
			else
			System.out.println("txt: " + museologicalObject.getName());
			for (NavigationItem navigationItem : navigationItems) {
				System.out.println("ni: " + navigationItem.getName());
				if (notNew = navigationItem.set(museologicalObject)) {
					System.out.println("Atualizado");
					break;
				}
			}

			if (!notNew) {
				navigationItems.add(new NavigationItem(museologicalObject));
				System.out.println("Inserido");
			}
		}

		return navigationItems;
	}

}