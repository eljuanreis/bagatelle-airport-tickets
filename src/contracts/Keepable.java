package contracts;

import java.sql.PreparedStatement;

public interface Keepable {
	public PreparedStatement getInsertSql();
	public PreparedStatement getList();
}
