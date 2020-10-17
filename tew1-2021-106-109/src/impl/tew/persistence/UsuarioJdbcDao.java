package impl.tew.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tew.model.Usuario;
import com.tew.persistence.UsuarioDao;
import com.tew.persistence.exception.PersistenceException;

public class UsuarioJdbcDao implements UsuarioDao {

	@Override
	public List<Usuario> getUsuarios() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			// En una implemenntaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("select * from alumno");
			rs = ps.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setEmail(rs.getLong("EMAIL"));
				usuario.setPasswd(rs.getLong("PASSWORD"));
				usuario.setRol(rs.getString("ROL"));
				usuario.setNombre(rs.getString("NOMBRE"));
				
				usuarios.add(usuario);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally  {
			if (rs != null) {try{ rs.close(); } catch (Exception ex){}};
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		
		return usuarios;
	}

}
