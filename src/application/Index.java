package application;

import database.DBManager;

public class Index {

	public static void main(String[] args) {
		
		// Iniciando servico de banco de dados
		try {			
			DBManager db = DBManager.getInstance();
			db.testConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Lançar telas da aplicação
	}
}
