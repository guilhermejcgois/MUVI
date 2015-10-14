package br.ufscar.sor.dcomp.ihc.muvi.util;

import br.ufscar.sor.dcomp.ihc.muvi.model.NavigationItem;
import com.lpsmuseum.dto.MuseologicalObject;
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
            
            for (NavigationItem navigationItem : navigationItems)
                if (notNew = navigationItem.set(museologicalObject))
                    break;
            
            if (!notNew)
                navigationItems.add(new NavigationItem(museologicalObject));
        }
        
        return navigationItems;
    }
    
}
