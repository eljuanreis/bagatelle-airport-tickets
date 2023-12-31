package boundary;

import control.AirlineControl;
import entity.Airline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class AirlineBoundary extends Application {
	private AirlineControl control = new AirlineControl();
	
	private TextField txtName = new TextField();
	private TableView<Airline> table = new TableView<Airline>();
	
	Button btnSave = new Button("Cadastrar");
	Button btnSearch = new Button("Procurar");
	
	@Override
	public void start(Stage stage) { 
		BorderPane mainPane = new BorderPane();
		Scene scn = new Scene(mainPane, 720, 600);
		stage.setResizable(false);
		GridPane paneForm = new GridPane();
		
		binding();
		buildList();
		
		paneForm.add(new Label("Nome: "), 0, 0);
		paneForm.add(txtName, 1, 0);
		
		paneForm.add(btnSave, 0, 1);
		paneForm.add(btnSearch, 1, 1);
		
		mainPane.setTop(paneForm);
		mainPane.setCenter(table);
		
		mainPane.setStyle("-fx-padding: 25px");
		
		btnSave.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent event) {
		    	control.save();
		    }
		});
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent event) {
		    	control.search(txtName.getText());;
		    }
		});
		
		stage.setScene(scn);
		stage.setTitle("Cadastro Companhia Aérea");
		stage.show();
	}
	
	public void binding() {
		Bindings.bindBidirectional(txtName.textProperty(), control.nameProperty());
	}
	
	public void buildList() {
		TableColumn<Airline, String> colName = new TableColumn<>("Nome");
		colName.setCellValueFactory(
				airlineData -> new ReadOnlyStringWrapper(airlineData.getValue().getName())
		);
		
		table.getColumns().add(colName);
		
		table.setItems(control.getList());
	}
	
	public static void main(String args[]) { 
		Application.launch(AirlineBoundary.class, args);
	}
}
