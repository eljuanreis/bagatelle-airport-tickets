package boundary;

import control.PassengerControl;
import entity.Passenger;
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

public class PassengerBoundary extends Application {
	private PassengerControl control = new PassengerControl();
	
	private TextField txtName = new TextField();
	private TextField txtCpf = new TextField();
	private TextField txtPhone = new TextField();
	private TextField txtEmail = new TextField();
	private TextField txtBirthDate = new TextField();
	private TableView<Passenger> table = new TableView<Passenger>();
	
	private Button btnSave = new Button("Cadastrar");
	private Button btnSearch = new Button("Procurar");
	
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
		
		paneForm.add(new Label("CPF: "), 0, 1);
		paneForm.add(txtCpf, 1, 1);
		
		paneForm.add(new Label("Telefone: "), 0, 2);
		paneForm.add(txtPhone, 1, 2);
		
		paneForm.add(new Label("Email: "), 0, 3);
		paneForm.add(txtEmail, 1, 3);
		
		paneForm.add(new Label("Data de nascimento: "), 0, 4);
		paneForm.add(txtBirthDate, 1, 4);
		
		paneForm.add(btnSave, 0, 5);
		paneForm.add(btnSearch, 1, 5);
		
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
		stage.setTitle("Cadastro Passageiros");
		stage.show();
	}
	
	public void binding() {
		Bindings.bindBidirectional(txtName.textProperty(), control.nameProperty());
		Bindings.bindBidirectional(txtCpf.textProperty(), control.cpfProperty());
		Bindings.bindBidirectional(txtPhone.textProperty(), control.phoneProperty());
		Bindings.bindBidirectional(txtEmail.textProperty(), control.emailProperty());
		Bindings.bindBidirectional(txtBirthDate.textProperty(), control.birthdayProperty());
	}
	
	public void buildList() {
		TableColumn<Passenger, String> colName = new TableColumn<>("Nome");
		colName.setCellValueFactory(
				passengerData -> new ReadOnlyStringWrapper(passengerData.getValue().getName())
		);
		
		TableColumn<Passenger, String> colCpf = new TableColumn<>("CPF");
		colCpf.setCellValueFactory(
				passengerData -> new ReadOnlyStringWrapper(passengerData.getValue().getCpf())
		);
		
		TableColumn<Passenger, String> colPhone = new TableColumn<>("Telefone");
		colPhone.setCellValueFactory(
				passengerData -> new ReadOnlyStringWrapper(passengerData.getValue().getPhone())
		);
		
		TableColumn<Passenger, String> colEmail = new TableColumn<>("Email");
		colEmail.setCellValueFactory(
				passengerData -> new ReadOnlyStringWrapper(passengerData.getValue().getEmail())
		);
		
		TableColumn<Passenger, String> colBrithday = new TableColumn<>("Data de nascimento");
		colEmail.setCellValueFactory(
				passengerData -> new ReadOnlyStringWrapper(passengerData.getValue().getBirthDate().toString())
		);
		
		table.getColumns().addAll(colName, colCpf, colPhone, colEmail, colBrithday);
		
		table.setItems(control.getList());
	}
	
	public static void main(String args[]) { 
		Application.launch(PassengerBoundary.class, args);
	}
}
