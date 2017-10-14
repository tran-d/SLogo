package view;

import javafx.scene.paint.Color;

/**
 * The Pane responsible for presenting the turtle the lines it has drawn, along
 * with some background. It implements TurtleListener so that it can be notified
 * directly when changes to the turtle's state occur.
 *
 */
public interface TurtleView extends TurtleListener {
	public void setBackgroundColor(Color c);
}