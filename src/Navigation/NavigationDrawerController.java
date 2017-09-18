package Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class NavigationDrawerController implements Initializable {
	
	
		@FXML
	    private AnchorPane anchorpane;
	    @FXML
	    private JFXDrawer drawer;
	    @FXML
	    private JFXHamburger hm1;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		try {
		VBox box = FXMLLoader.load(getClass().getResource("JFXDrawer.fxml"));	
		drawer.setSidePane(box);
		
		for(Node node:box.getChildren()){
			if(node.getAccessibleText()!= null){
				node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
					
					switch(node.getAccessibleText()){
					case "Material_One": anchorpane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#4CAF50"), null, null)));
					break;
					case "Material_Two": anchorpane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#0288D1"), null, null)));
					break;
					case "Material_Three": anchorpane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#C2185B"), null, null)));
					break;
					case "Material_Four": anchorpane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#4E342E"), null, null)));
					break;
					case "Material_Five": System.exit(0);
					}
				});
			}
			
		}
		
		
		HamburgerBackArrowBasicTransition transition1 = new HamburgerBackArrowBasicTransition(hm1);
		transition1.setRate(-1);  // There are two type of setRate(-1) & setRate(1)
		hm1.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
		transition1.setRate(transition1.getRate()* -1);
		transition1.play();
		
		if(drawer.isShown()){
			drawer.close();
		}
		else{
			drawer.open();
		}
			
		
		
		});
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	

}
