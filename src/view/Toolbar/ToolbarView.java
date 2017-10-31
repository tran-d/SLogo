package view.Toolbar;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import view.ErrorWindow;
import view.SubcomponentViewAPI;

/**
 * Class allowing users to view and use toolbar functions.
 * 
 * @author DavidTran
 *
 */
public class ToolbarView implements SubcomponentViewAPI {

	private ResourceBundle myResources = ResourceBundle.getBundle("resources.view/view");
	private static final double NODE_SPACING = 50;
	private List<String> myImageNameList;
	private List<String> myColorList;

	private HBox myToolbar;
	private WorkSpaceButtons myWorkSpaceButtons;
	private BackgroundOptionView myBackgroundOptionView;
	private PenOptionView myPenOptionView;
	private PenSlider myPenSlider;
	private PenButtons myPenButtons;
	private TurtleImageOptionView myImageOptionView;
	private LanguageOptionView myLanguageOptionView;
	private Hyperlink myHelpLink;
	private BiConsumer<String, String> myCommandConsumer;

	public ToolbarView(double width, List<String> imgList, List<String> colorList, Runnable newWorkspace,
			Consumer<String> saveConsumer, Consumer<String> loadConsumer, BiConsumer<String,String> commandConsumer) {

		myToolbar = new HBox(NODE_SPACING);
		myToolbar.setAlignment(Pos.CENTER);
		myToolbar.setMinWidth(width);

		myImageNameList = imgList;
		myColorList = colorList;
		myCommandConsumer = commandConsumer;

		myWorkSpaceButtons = new WorkSpaceButtons(newWorkspace, saveConsumer, loadConsumer);
		makeSubcomponents();
		makeHelpLink();

		myToolbar.getChildren().addAll(myWorkSpaceButtons.getParent(), myBackgroundOptionView.getParent(),
				myPenOptionView.getParent(), myPenSlider.getParent(), myPenButtons.getParent(),
				myImageOptionView.getParent(), myLanguageOptionView.getParent(), myHelpLink);

	}

	@Override
	public Parent getParent() {
		return myToolbar;
	}

	// Must add to API
	public BackgroundOptionView getBackgroundOptionView() {
		return myBackgroundOptionView;
	}

	public PenOptionView getPenOptionView() {
		return myPenOptionView;
	}

	public PenSlider getPenSlider() {
		return myPenSlider;
	}

	public PenButtons getPenButtons() {
		return myPenButtons;
	}

	public LanguageOptionView getLanguageOptionView() {
		return myLanguageOptionView;
	}

	// Must add to API
	public TurtleImageOptionView getImageOptionView() {
		return myImageOptionView;
	}

	private void makeHelpLink() {

		myHelpLink = new Hyperlink();
		myHelpLink.setText("Help");
		myHelpLink.setId("help-hyperlink");

		myHelpLink.setOnAction(e -> {
			if (Desktop.isDesktopSupported()) {
				try {
					Desktop.getDesktop().browse(new URI(myResources.getString("HelpURL")));
				} catch (IOException e1) {
					e1.printStackTrace();
					new ErrorWindow(e1.getMessage());
				} catch (URISyntaxException e1) {
					new ErrorWindow(e1.getMessage());
				}
			}
		});

	}

	private void makeSubcomponents() {
		myBackgroundOptionView = new BackgroundOptionView(myColorList, myCommandConsumer);
		myPenOptionView = new PenOptionView(myColorList, myCommandConsumer);
		myPenSlider = new PenSlider(myCommandConsumer);
		myPenButtons = new PenButtons(myCommandConsumer);
		myImageOptionView = new TurtleImageOptionView(myImageNameList ,myCommandConsumer);
		myLanguageOptionView = new LanguageOptionView();
	}

}
