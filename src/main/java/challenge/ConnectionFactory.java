package main.java.challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection createConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		String db = "C:\\Java\\eclipse-workspaces\\ws-desafios\\desafio-java4-codenation\\src\\main\\resources\\database.sqlite";
		return DriverManager.getConnection("jdbc:sqlite:" + db);
	}

}
