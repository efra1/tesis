package servicios;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;

import datos.Conexion;
import modelos.Persona;
import modelos.Usuario;

import modelos.rol;

@Service
public class UsuarioServicio extends Conexion {

	public class Mapear implements RowMapper<Usuario> {
		@Override
		public Usuario mapRow(ResultSet res, int arg1) throws SQLException {
			Usuario u = new Usuario();
			u.setId_us(res.getInt("id_us"));
			u.setLogin(res.getString("login"));
			u.setPassword(res.getString("password"));
			u.setId_per(res.getInt("id_per"));
			u.setId_rol(res.getInt("id_rol"));
			return u;
		}
	}
	
	


	public String GetNombre(String login) {
		String sql = "select concat(p.nombres, ' ' ,p.apellidos) as persona from persona p, usuario u "
				+ "where u.login = ? and u.id_per =p.id_per";
		return this.db.queryForObject(sql, String.class, new Object[] { login });
	}	

	public int ValidarLogin(String login, String password) {
		String sql = "select count(login) from usuario where login=? and password =?";
		return this.db.queryForObject(sql, Integer.class, new Object[] { login, password });
	}

	public List<Map<String, Object>> listarUsuarios() {
		return db.queryForList(
				"select *,r.nombre as rol,u.estado as activou from usuario u left join persona p on u.id_per=p.id_per left join rol r on r.id_rol=u.id_rol where u.estado=true");
	}
	public List<Map<String, Object>> listarUsuariosI() {
		return db.queryForList(
				"select *,r.nombre as rol,u.estado as activou from usuario u left join persona p on u.id_per=p.id_per left join rol r on r.id_rol=u.id_rol where u.estado=false");
	}
	 
	public Integer guardarP(Persona p){
		db.update( "INSERT INTO persona(ci, nombres, apellidos, sexo, f_nac) VALUES (?, ?, ?, ?, ?)",p.getCi(),p.getNombres(),p.getApellidos(),p.getSexo(),p.getF_nac());
		return db.queryForObject("select max(id_per) from persona",Integer.class);
	}
	
	public void guardarU(Usuario u){
		db.update("insert into usuario(login,password,id_per,id_rol) values(?,?,?,?)",u.getLogin(),u.getPassword(),u.getId_per(),u.getId_rol());
	}

	
	
	
	/*public void guardar(Persona p, Usuario u) {
		
		u.setId_per(p.getId_per());
		u.setId_us(GenerateIdUs());
		
		System.out.println(p.toString());
		System.out.println(u.toString());
		
		String sql = "INSERT INTO persona(id_per, ci, nombres, apellidos, sexo, f_nac, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
		String sql1 = "INSERT INTO usuario(id_us,login, password, id_per, id_rol, estado)  VALUES (?, ?, ?, ?, ?, ?)";
		
		int res = db.update(sql ,p.getId_per(),p.getCi(), p.getNombres(), p.getApellidos(), p.getSexo(), p.getF_nac(), p.getEstado());
		int res1 = db.update(sql1,u.getId_us(), u.getLogin(), u.getPassword(), u.getId_per(), u.getId_rol());
		
		System.out.println("Guardo: "+res1 +" "+res );
	}
*/
	public List<Map<String, Object>> listarRoles() {
		return db.queryForList("select * from rol");
	}
	public Integer obtener(int id_us){
		return db.update( "select * from usuario where id_us=?",id_us);
	
	}
	public void inhabilitar(int id_us){
		db.update("update usuario set estado=false where id_us=?",id_us);
	}
	
	public void habilitar(int id_us){
		db.update("update usuario set estado=true where id_us=?",id_us);
	}
	
	public Map<String,Object> obtenerUs(int id_us){
		return db.queryForMap("select * from usuario as u left join persona as p on u.id_per=p.id_per where id_us=?",id_us);
	}
	
	public void modificar(Usuario u){
		db.update("update usuario set (login,password,id_rol)=(?,?,?) where id_us=?",u.getLogin(),u.getPassword(),u.getId_rol(),u.getId_us());
	}
	
	
	
}