package application;

import dao.PassengerDAO;
import database.DBManager;
import entity.Passenger;

public class Index {

	public static void main(String[] args) {
		
		// Iniciando servico de banco de dados
		try {			
			DBManager db = DBManager.getInstance();
			db.testConnection();
			
			Passenger p = new Passenger();
			p.setName("aa");
			p.setCpf("aaa");
			p.setPhone("123");
			p.setEmail("aasd");
			
			PassengerDAO pd = new PassengerDAO(p);
			pd.create();
			
			pd.index();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Lançar telas da aplicação
	}
}
