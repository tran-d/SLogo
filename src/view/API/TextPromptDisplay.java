package view.API;

/**
 * The pane containing a text field where users can enter commands to be sent to
 * the model. Must have access to a Consumer<String>.
 *
 */
public interface TextPromptDisplay extends SubcomponentViewAPI {
	/**
	 * Submits the text in the field to the stored Consumer
	 */
	public void enter();

	/**
	 * Clears the text field
	 */
	public void clear();
}
