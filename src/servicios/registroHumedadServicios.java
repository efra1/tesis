package servicios;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import datos.Conexion;
import modelos.Persona;
import modelos.Usuario;
import modelos.registroTiempo;
import servicios.UsuarioServicio.Mapear;
import modelos.registroHumedad;

@Service

public class registroHumedadServicios extends Conexion {

	public class Mapear implements RowMapper<registroHumedad> {
		@Override
		public registroHumedad  mapRow(ResultSet res, int arg1) throws SQLException {
			 registroHumedad u= new registroHumedad();
			
			u.setId_reg(res.getInt("id_reg"));
			u.setFecha(res.getDate("fecha"));
			u.setHumedad(res.getString("humedad"));
			u.setEstado(res.getBoolean("estado"));
			u.setId_us(res.getInt("id_us"));
			 	return u;
		}
	}
		public List<registroHumedad> lista(){
			String sql = "select * from registroHumedad where estado=true";
			return db.query(sql, new Mapear());
		
	
	
}
		
	public int guardar(registroHumedad h){
		return db.update("insert into registroHumedad(fecha,humedad) values(?,?)",h.getFecha(),h.getHumedad());
	}
	
	public Map<String,Object> obtenerUs(int id_us){
		return db.queryForMap("select * from usuario as u left join persona as p on u.id_per=p.id_per where id_us=?",id_us);
	}

	
	public void modificar(registroHumedad h){
		db.update("update registroHumedad set (fecha, humedad)=(?,?) where id_reg=?",h.getFecha(),h.getHumedad(),h.getId_reg());
	}

	public Map<String,Object> obtener(int id_reg){
		return db.queryForMap("select * from registroHumedad where id_reg=?",id_reg);
	}

	public void inhabilitar(int id_reg){
		db.update("update registroHumedad set estado=false where id_reg=?",id_reg);
	}
	}


