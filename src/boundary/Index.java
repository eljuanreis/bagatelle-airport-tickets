package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Index extends Application {

	public static void main(String[] args) {
		Application.launch(Index.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane mainPane = new BorderPane();
		Scene scn = new Scene(mainPane, 500, 300);
		stage.setResizable(false);
		GridPane paneForm = new GridPane();
		GridPane paneTop = new GridPane();

		Label text = new Label("Selecione uma opção:");
		
		Button airline = new Button("Cadastrar companhias");
		Button passenger = new Button("Cadastrar passageiro");
		Button flight = new Button("Cadastrar vôos");
		Button ticket = new Button("Cadastrar tickets");
		
		paneTop.add(text, 0, 0);
		
		paneForm.add(airline, 0, 1);
		paneForm.add(passenger, 0, 2);
		paneForm.add(flight, 0, 3);
		paneForm.add(ticket, 0, 4);
		
		mainPane.setTop(paneTop);
		mainPane.setCenter(paneForm);
		
		mainPane.setStyle("-fx-padding: 25px");
		paneForm.setVgap(20);
		
		airline.setOnAction(x -> {
			AirlineBoundary bd = new AirlineBoundary();
			Stage bdStage = new Stage();
			bd.start(bdStage);
		});
		
		passenger.setOnAction(x -> {
			PassengerBoundary bd = new PassengerBoundary();
			Stage bdStage = new Stage();
			bd.start(bdStage);
		});
		
		flight.setOnAction(x -> {
			FlightBoundary bd = new FlightBoundary();
			Stage bdStage = new Stage();
			bd.start(bdStage);
		});
		
		ticket.setOnAction(x -> {
			TicketBoundary bd = new TicketBoundary();
			Stage bdStage = new Stage();
			bd.start(bdStage);
		});
		
		stage.setScene(scn);
		stage.setTitle("Menu de opções");
		stage.show();
	}
}
