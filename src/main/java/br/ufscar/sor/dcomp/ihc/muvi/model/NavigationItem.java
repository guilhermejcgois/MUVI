package br.ufscar.sor.dcomp.ihc.muvi.model;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.object.Text;

/**
 *
 * @author gois
 */
public class NavigationItem {

    private Text text;
    private Image image;
    private Text toKnowMore;

    public NavigationItem(MuseologicalObject museologicalObject) {
        if (museologicalObject instanceof Image) {
            image = (Image) museologicalObject;
        } else if (museologicalObject.getObjectType()) {
            text = (Text) museologicalObject;
        } else {
            toKnowMore = (Text) museologicalObject;
        }
    }

    public Text getText() {
        return text;
    }

    public Image getImage() {
        return image;
    }

    public Text getToKnowMore() {
        return toKnowMore;
    }

    public boolean belongs(MuseologicalObject candidate) {
        if (text != null && text.getName().equals(candidate.getName())) {
            return true;
        }
        if (image != null && image.getName().equals(candidate.getName())) {
            return true;
        }
        if (toKnowMore != null && toKnowMore.getName().equals(candidate.getName())) {
            return true;
        }
        return false;
    }

    public boolean set(MuseologicalObject candidate) {
        if (belongs(candidate)) {
            if (candidate instanceof Image) {
                image = (Image) candidate;

                return true;
            } else if (candidate instanceof Text) {
                if (candidate.getObjectType()) {
                    text = (Text) candidate;
                } else {
                    toKnowMore = (Text) candidate;
                }
            }
        }

        return false;
    }

}
