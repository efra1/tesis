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
import modelos.fincas;
import modelos.registroHumedad;
import modelos.registroTiempo;

@Service
public class registroTiempoServicio extends Conexion {

	public class Mapear implements RowMapper<registroTiempo> {
		@Override
		public registroTiempo  mapRow(ResultSet res, int arg1) throws SQLException {
			 registroTiempo u= new registroTiempo();
			
			u.setId_t(res.getInt("id_t"));
			u.setFecha(res.getDate("fecha"));
			
			u.setTemp_maxima(res.getString("temp_maxima"));
			u.setTemp_minima(res.getString("temp_minima"));
			u.setTemp_ambiente(res.getString("temp_ambiente"));
			u.setEstado(res.getBoolean("estado"));
			u.setId_us(res.getInt("id_us"));
			return u;
		}
	
	
	}
	public List<registroTiempo> RegistroTiempoServicios(){
		String sql = "select * from registroTiempo where estado=true";
		return db.query(sql, new Mapear());
		
	}
	public int guardar(registroTiempo r){

		return db.update("insert into registroTiempo(fecha,temp_maxima,temp_minima,temp_ambiente) values(?,?,?,?)",r.getFecha(),r.getTemp_ambiente(),r.getTemp_maxima(),r.getTemp_minima());
				
	}
	public void modificar(registroTiempo r){
		db.update("update registroTiempo set (fecha, temp_maxima,temp_minima,temp_ambiente)=(?,?,?,?) where id_t=?",r.getFecha(),r.getTemp_maxima(),r.getTemp_minima(),r.getTemp_ambiente(),r.getId_t());
	}

	public Map<String,Object> obtener(int id_t){
		return db.queryForMap("select * from registroTiempo where id_t=?",id_t);
	}
	public void inhabilitar(int id_t){
		db.update("update registroTiempo set estado=false where id_t=?",id_t);
	}

}
