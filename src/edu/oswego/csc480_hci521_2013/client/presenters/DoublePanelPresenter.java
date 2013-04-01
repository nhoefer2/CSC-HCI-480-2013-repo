package edu.oswego.csc480_hci521_2013.client.presenters;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Command;
import edu.oswego.csc480_hci521_2013.shared.h2o.json.RF;

/**
 *
 */
public interface DoublePanelPresenter {

    void goTo(Place place);

    void addDataTab(String key);

    void addVisTab(String datakey, String modelkey, int tree);

    void addConfusionMatrixTab(RF randomForest);

    Command getMenuCommand(String value);
}
