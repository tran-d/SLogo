package view.Toolbar;

import view.SubcomponentViewAPI;
import view.Animation.TurtleImageOptionListener;

public interface TurtleImageOptionAPI {

	/**
	 * Give a listener to the color option box to detect selections.
	 * 
	 * @param l
	 *            Listener that detects when user selects a color option.
	 */
	public void addTurtleImageListener(TurtleImageOptionListener l);
	
}
