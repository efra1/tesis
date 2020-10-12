package controladores;

import modelos.Persona;
import modelos.Usuario;
import modelos.fincas;
import modelos.registroHumedad;
import modelos.registroTiempo;
import modelos.rol;
import servicios.UsuarioServicio;
import servicios.registroTiempoServicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/registroTiempo")
public class registroTiempoControl {
	@Autowired
	private registroTiempoServicio registroTiempoServicio;

	@RequestMapping("listaPrincipal.html")
	public String lista(Model m, HttpServletRequest req) {
		System.out.println("entro");
		HttpSession sesion = req.getSession(true);

		m.addAttribute("lista", this.registroTiempoServicio.RegistroTiempoServicios());
		
		return "registroTiempo/listaPrincipal";
	}

	@RequestMapping("nuevo.html")
	public String nuevo(){
		return "registroTiempo/nuevoRegistroTiempo";
	}
	
	@RequestMapping("guardart.html")
	public String guardar(HttpServletRequest req,registroTiempo r, String fecha_d){
		try {
			r.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fecha_d));
			
		} catch (ParseException e) {
			e.printStackTrace();
			
		}
		registroTiempoServicio.guardar(r);
		System.out.println("registro");
		return "redirect:listaPrincipal.html";
	}
	@RequestMapping("editar.html")
	public String editar(Model m,int id_t){
		m.addAttribute("tiempo",registroTiempoServicio.obtener(id_t));
		return "registroTiempo/editar";
	}

	@RequestMapping("modificar")
	public String modificar(registroTiempo r, String fecha_d){
		try {
			r.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fecha_d));
			
		} catch (ParseException e) {
			e.printStackTrace();
			
		}
		registroTiempoServicio.modificar(r);	
		System.out.println("modifico registro humedad");
		return "redirect:listaPrincipal.html";

		

	}

	@RequestMapping("inhabilitar")
	public String inhabilitar(Integer id_t){
		registroTiempoServicio.inhabilitar(id_t);
		
		return "redirect:listaPrincipal.html";
	}
	
}
