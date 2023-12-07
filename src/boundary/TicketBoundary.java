package boundary;

import entity.Ticket;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
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

public class TicketBoundary extends Application {
	private TextField txtPassenger = new TextField();
	private TextField txtFlight = new TextField();
	private TextField txtSeat = new TextField();
	private TextField txtseatClass = new TextField();
	// id devera ser gerado automaticamente
	private TableView<Ticket> table = new TableView<Ticket>();
	
	@Override
	public void start(Stage stage) { 
		BorderPane mainPane = new BorderPane();
		Scene scn = new Scene(mainPane, 720, 600);
		stage.setResizable(false);
		
		Button btnSave = new Button("Cadastrar");
		Button btnSearch = new Button("Procurar");
		
		GridPane paneForm = new GridPane();
		
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
		paneForm.add(txtseatClass, 1, 3);
		
		paneForm.add(btnSave, 0, 4);
		paneForm.add(btnSearch, 1, 4);
		
		mainPane.setTop(paneForm);
		mainPane.setCenter(table);
		
		mainPane.setStyle("-fx-padding: 25px");
		
		stage.setScene(scn);
		stage.setTitle("Cadastro Passagem");
		stage.show();
	}
	
	public static void main(String args[]) { 
		Application.launch(TicketBoundary.class, args);
	}
}
