package servicios;
import modelos.lote;
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
import modelos.fincas;
import modelos.rol;
import servicios.fincasServicio.Mapear;

@Service
public class loteServicio extends Conexion {
	public class Mapear implements RowMapper<lote> {
		@Override
		public lote mapRow(ResultSet res, int arg1) throws SQLException {
			lote u = new lote();
			u.setId_lote(res.getInt("id_lote"));
			u.setNombre(res.getString("nombre"));
			u.setNumPlantas(res.getNString("numPlantas"));
			u.setEstado(res.getBoolean("estado"));
			u.setId_finca(res.getInt("id_finca"));
			return u;
		}
	}
	public List<lote> getLotes(int id_lote){
		String sql = "select f.*,f.nombre  as lote from finca f join lote l on f.id_finca=l.id_finca where id_lote=?",id_lote1;
		return db.query(sql, new Mapear());
		
	}
	public Map<String,Object> obtenerF(int id_lote){
		return db.queryForMap("select f.*,f.nombre  as lote from finca f join lote l on f.id_finca=l.id_finca where id_lote=?",id_lote);
	}
	
	
}
