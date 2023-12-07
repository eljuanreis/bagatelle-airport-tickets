package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBManager;

public class EntityLoadRelations {

	private static DBManager db = DBManager.getInstance();

	public static String getAttributeById(String table, long id, String attr) {
		PreparedStatement stmt = db.prepare("SELECT * from %s WHERE id = %s".formatted(table, id));
		ResultSet r = db.select(stmt);
		
		try {
			while (r.next()) {
				return r.getString(attr);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
	}
}
