package application;

import database.DBManager;
import javafx.application.Application;

public class Index {

	public static void main(String[] args) {
		
		// Iniciando servico de banco de dados
		try {			
			DBManager db = DBManager.getInstance();
			db.testConnection();
			
			Application.launch(boundary.Index.class, args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
