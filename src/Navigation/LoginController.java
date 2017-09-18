package Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	
	@FXML
	private JFXTextField txtUname;
	@FXML
	private JFXPasswordField txtPassword;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		 RequiredFieldValidator validator = new RequiredFieldValidator();
		    RequiredFieldValidator passv = new RequiredFieldValidator();
		    NumberValidator nv = new NumberValidator();
				
				//txtUname.getValidators().add(validator);
				//validator.setMessage("No Input Provided");
				
				/*txtUname.focusedProperty().addListener(new ChangeListener<Boolean>(){
					public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue){
						
						if(! newValue){
							txtUname.validate();
						}
					}
				});*/
				
				txtUname.getValidators().add(validator);
				validator.setMessage("Please Enter User Name");
				txtUname.validate();
				txtUname.focusedProperty().addListener(new ChangeListener< Boolean>(){
					@Override
					public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
						// TODO Auto-generated method stub
						
						if(!newValue){
							txtUname.validate();
						}
						
					}
					
				});
				
				txtPassword.getValidators().add(passv);
				passv.setMessage("Please enter Password");
				txtPassword.focusedProperty().addListener(new ChangeListener< Boolean>(){
					@Override
					public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
						// TODO Auto-generated method stub
						
						if(!newValue){
							txtPassword.validate();
						}
						
					}
					
				});

				
	}
	
	 
	@FXML
	 void btnLoginClicked(ActionEvent event) throws IOException{
		
		String uname = txtUname.getText();
		String pass = txtPassword.getText();
		
		if(uname.equals("admin")&& pass.equals("admin")){
			System.out.println("Valid User");
			 //FXMLLoader.load(getClass().getResource("NavigationDrawer.fxml"));
			 Stage stage = new Stage();
		       stage.setTitle("Library Management");
		       Pane myPane = null;
		       myPane = FXMLLoader.load(getClass().getResource("NavigationDrawer.fxml"));
		       Scene scene = new Scene(myPane);
		       stage.setScene(scene);

		      // prevStage.close();

		       stage.show();
		}
		else{
			System.out.println("Invalid User");
		}
	}
	
	@FXML
	 void btnExitClicked(ActionEvent event){
		System.exit(0);	
	}

}
