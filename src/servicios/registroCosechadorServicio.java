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
import servicios.registroTiempoServicio.Mapear;
import modelos.registroCosechadores;
@Service

public class registroCosechadorServicio extends Conexion {

	public class Mapear implements RowMapper<registroCosechadores> {
		@Override
		public registroCosechadores  mapRow(ResultSet res, int arg1) throws SQLException {
			 registroCosechadores u= new registroCosechadores();
			
			 u.setId_reg_us(res.getInt("id_reg_us"));
			 u.setFecha(res.getDate("fecha"));
			 u.setPeso(res.getString("peso"));
			 u.setId_lote(res.getInt("id_lote"));
			 u.setId_us(res.getInt("id_us"));
			 	return u;
		}
	}
		
		
		public List<Map<String, Object>> listarUsuarios() {
			return db.queryForList(
					"select *,r.nombre as rol,u.estado as activou from usuario u left join persona p on u.id_per=p.id_per left join rol r on r.id_rol=u.id_rol where r.id_rol=5" );
		}

}