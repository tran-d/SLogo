package controller.API;

/**
 * The controller of the program -- instantiates Model and View, distributes
 * Listeners from View to Model, gives View the ability to access Model's
 * execute method
 *
 */
public interface DriverAPI {
	/**
	 * Loads a new Model and starts the programming environment.
	 */
	public void run(); 
}
