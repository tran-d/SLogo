package view;

import java.util.Map;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import view.API.VariableDisplay;

/**
 * Class allowing users to see values of current variables
 * 
 * @author DavidTran
 *
 */
public class VariableView implements VariableDisplay {

	private TextArea ta;
	private ResourceBundle myResources = ResourceBundle.getBundle("resources.view/view");

	public VariableView() {

		ta = new TextArea();
		ta.setWrapText(true);
		ta.setEditable(false);
		ta.appendText(myResources.getString("VariableView"));
	}

	@Override
	public void changedMap(Map<String, Double> vars) {
		ta.clear();
		ta.appendText(myResources.getString("VariableView") + "\n\n");
		for (String key : vars.keySet()) {
			ta.appendText(key + " : " + vars.get(key) + "\n");
		}

	}

	@Override
	public void clearVariables() {
		ta.clear();

	}

	@Override
	public Parent getParent() {
		return ta;
	}

}
