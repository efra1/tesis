package servicios;
import modelos.fincas;


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
public class fincasServicio extends Conexion {
	
	public class Mapear implements RowMapper<fincas> {
		@Override
		public fincas mapRow(ResultSet res, int arg1) throws SQLException {
			fincas u = new fincas();
			u.setId_finca(res.getInt("id_finca"));
			u.setNombre(res.getString("nombre"));
			u.setDescripcion(res.getString("descripcion"));
			u.setId_us(res.getInt("id_us"));
			
			return u;
		}
	}

	public List<fincas> getFincas(){
		String sql = "select * from finca where estado=true";
		return db.query(sql, new Mapear());
		
	}
	
	public Integer obtenerus(int id_us){
		return db.update( "select * from usuario where id_us=?",id_us);
	
	}
	public void guardarFinca(fincas f){

		db.update("insert into finca(nombre,descripcion) values(?,?)",f.getNombre(),f.getDescripcion());
		
	}

	public void modificar(fincas r){
		db.update("update finca set (nombre,descripcion)=(?) where id_finca=?",r.getNombre(),r.getDescripcion(),r.getId_finca());
	}
	
	public void eliminar(int id_finca){
		db.update("update finca set estado=false where id_finca=?",id_finca);
	}
	
	public Map<String,Object> obtener(int id_finca){
		return db.queryForMap("select * from finca where id_finca=?",id_finca);
	}
	

	
}
