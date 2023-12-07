package boundary;

import control.TicketControl;
import entity.Ticket;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicketBoundary extends Application {
	private TicketControl control = new TicketControl();

	private TextField txtPassenger = new TextField();
	private TextField txtFlight = new TextField();
	private TextField txtSeat = new TextField();
	private TextField txtSeatClass = new TextField();
	
	private Button btnSave = new Button("Cadastrar");

	// id devera ser gerado automaticamente
	private TableView<Ticket> table = new TableView<Ticket>();
	
	@Override
	public void start(Stage stage) { 
		BorderPane mainPane = new BorderPane();
		Scene scn = new Scene(mainPane, 720, 600);
		stage.setResizable(false);
		
		Button btnSearch = new Button("Procurar");
		
		GridPane paneForm = new GridPane();
		
		binding();
		buildList();
		paneForm.add(new Label("Passageiro: "), 0, 0);
		paneForm.add(txtPassenger, 1, 0);
		Button btnSearchPassenger = new Button("Procurar");
		paneForm.add(btnSearchPassenger, 2, 0);
		
		paneForm.add(new Label("Voo: "), 0, 1);
		paneForm.add(txtFlight, 1, 1);
		Button btnSearchFlight = new Button("Procurar");
		paneForm.add(btnSearchFlight, 2, 1);
		
		paneForm.add(new Label("Assento: "), 0, 2);
		paneForm.add(txtSeat, 1, 2);
		
		paneForm.add(new Label("Classe: "), 0, 3);
		paneForm.add(txtSeatClass, 1, 3);
		
		paneForm.add(btnSave, 0, 4);
		paneForm.add(btnSearch, 1, 4);
		
		btnSave.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent event) {
		    	control.save();
		    }
		});
		
		mainPane.setTop(paneForm);
		mainPane.setCenter(table);
		
		mainPane.setStyle("-fx-padding: 25px");
		
		stage.setScene(scn);
		stage.setTitle("Cadastro Passagem");
		stage.show();
	}
	
	public void binding() {
		Bindings.bindBidirectional(txtPassenger.textProperty(), control.passengerProperty());
		Bindings.bindBidirectional(txtFlight.textProperty(), control.flightProperty());
		Bindings.bindBidirectional(txtSeat.textProperty(), control.seatProperty());
		Bindings.bindBidirectional(txtSeatClass.textProperty(), control.seatClassProperty());
	}
	
	@SuppressWarnings("unchecked")
	public void buildList() {
		TableColumn<Ticket, String> col1 = new TableColumn<>("Passageiro");
		col1.setCellValueFactory(
				data -> new ReadOnlyStringWrapper(data.getValue().getPassenger().getName())
		);
		
		TableColumn<Ticket, String> col2 = new TableColumn<>("Voo");
		col2.setCellValueFactory(
				data -> new ReadOnlyStringWrapper(data.getValue().getFlight().getNumber())
		);
		
		TableColumn<Ticket, String> col3 = new TableColumn<>("Assento");
		col3.setCellValueFactory(
				data -> new ReadOnlyStringWrapper(data.getValue().getSeat())
		);
		
		TableColumn<Ticket, String> col4 = new TableColumn<>("Classe");
		col4.setCellValueFactory(
				data -> new ReadOnlyStringWrapper(data.getValue().getSeatClass())
		);
		
		table.getColumns().addAll(col1, col2, col3, col4);
		
		table.setItems(control.getList());
	}
	
	
	public static void main(String args[]) { 
		Application.launch(TicketBoundary.class, args);
	}
}
