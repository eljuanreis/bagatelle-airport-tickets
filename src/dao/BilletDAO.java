package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import contracts.DAO;
import database.DBManager;
import entity.Billet;

public class BilletDAO implements DAO {

	private Billet billet;
	private DBManager db = DBManager.getInstance();
	private Connection con;
	
	public BilletDAO(Billet Billet) {
		this.billet = Billet;
	}
	
	@Override
	public void create() {
		try {
			PreparedStatement stmt = con.prepareStatement("asda");
			db.insert(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet index() {
		try {
			PreparedStatement stmt = con.prepareStatement("asda");
			ResultSet rs = db.select(stmt);
			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
