package main.java.challenge;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class QuoteDao {
	
	private Quote getResultSQL(String sql) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.createConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try {
				if (rs.next()) {
					return new Quote(rs.getString("actor"), rs.getString("detail"));
				}
				return null;
			} finally {
				rs.close();
				stmt.close();
			}

		} finally {
			conn.close();
		}		
	}

	public Quote getQuote() throws SQLException, ClassNotFoundException {
		String sql = "SELECT actor, detail FROM scripts WHERE actor NOT NULL ORDER BY RANDOM() LIMIT 1";
		return getResultSQL(sql);
	}

	public Quote getQuoteByActor(String actor) throws SQLException, ClassNotFoundException {
		String sql = "SELECT actor, detail FROM scripts WHERE actor = '" + actor + "' ORDER BY RANDOM() LIMIT 1";
		return getResultSQL(sql);
	}

}
