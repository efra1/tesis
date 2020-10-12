package datos;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
public class Conexion {
public JdbcTemplate db;
	
	@Resource(name = "dataSource")
	public void setDataSource( DataSource dataSource){
		db = new JdbcTemplate(dataSource);
	}
}
