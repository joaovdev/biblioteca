package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LivroBd implements Dao {

	public void delete(Base base) throws Exception {
		Livro p = (Livro)base;
		int id = p.getId();
		String sql = "delete from livros where id = " + id;
		
		execute(sql);	
	}

	
	public void insert(Base base) throws Exception {
		Livro livro = (Livro) base;
		String sql = "insert into livros(id ,nome, author) values(" + 
		    livro.getId() + ",'" + 
		    livro.getNome() + "','" + 
		    livro.getAuthor()
		+ "')";

		execute(sql);
	}


	private void execute(String sql) throws Exception {
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);
			
			Statement statement = conn.createStatement();
			statement.execute(sql);
			
			conn.commit();
			
		}catch(Exception e) {
			conn.rollback();
			throw e;
			
		} finally {
			conn.close();
		}
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		String host = "jdbc:postgresql://localhost:5432/Ativ0312";
		String user = "postgres";
		String pass = "postgres";
		Connection conn = DriverManager.getConnection(host, user, pass);
		return conn;
	}

}
