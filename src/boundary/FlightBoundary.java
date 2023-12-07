package boundary;

import java.time.LocalDate;
import java.time.LocalTime;

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

public class FlightBoundary extends Application {	
	private TextField txtAirline = new TextField();
	private TextField txtAirplane = new TextField();
	private TextField txtNumber = new TextField();
	private TextField txtDate = new TextField();
	private TextField txtBoardingTime = new TextField();
	private TextField txtDepartureTime = new TextField();
	private TextField txtArrivalTime = new TextField();
	private TextField txtDepartureAirport = new TextField();
	private TextField txtDestinationAirport = new TextField();
	private TextField txtGate = new TextField();
	private TableView<Ticket> table = new TableView<Ticket>();
	
	@Override
	public void start(Stage stage) { 
		BorderPane mainPane = new BorderPane();
		Scene scn = new Scene(mainPane, 720, 600);
		stage.setResizable(false);
		
		Button btnSave = new Button("Cadastrar");
		Button btnSearch = new Button("Procurar");
		
		GridPane paneForm = new GridPane();
		
		paneForm.add(new Label("Companhia Aérea: "), 0, 0);
		paneForm.add(txtAirline, 1, 0);
		Button btnSearchAirline = new Button("Procurar");
		paneForm.add(btnSearchAirline, 2, 0);
		
		paneForm.add(new Label("Modelo da Aeronave: "), 0, 1);
		paneForm.add(txtAirplane, 1, 1);
		
		paneForm.add(new Label("Número do voo: "), 0, 2);
		paneForm.add(txtNumber, 1, 2);
		
		paneForm.add(new Label("Data do voo: "), 0, 3);
		paneForm.add(txtDate, 1, 3);
		
		paneForm.add(new Label("Horário de embarque: "), 0, 4);
		paneForm.add(txtBoardingTime, 1, 4);
		
		paneForm.add(new Label("Horário de saída: "), 0, 5);
		paneForm.add(txtDepartureTime, 1, 5);
		
		paneForm.add(new Label("Horário de chegada: "), 0, 6);
		paneForm.add(txtArrivalTime, 1, 6);
		
		paneForm.add(new Label("Aeroporto de partida: "), 0, 7);
		paneForm.add(txtDepartureAirport, 1, 7);
		
		paneForm.add(new Label("Aeroporto de destino: "), 0, 8);
		paneForm.add(txtDestinationAirport, 1, 8);
		
		paneForm.add(new Label("Portão de embarque: "), 0, 9);
		paneForm.add(txtGate, 1, 9);
		
		paneForm.add(btnSave, 0, 10);
		paneForm.add(btnSearch, 1, 10);
		
		mainPane.setTop(paneForm);
		mainPane.setCenter(table);
		
		mainPane.setStyle("-fx-padding: 25px");
		
		stage.setScene(scn);
		stage.setTitle("Cadastro Voos");
		stage.show();
	}
	
	public static void main(String args[]) { 
		Application.launch(FlightBoundary.class, args);
	}
}
