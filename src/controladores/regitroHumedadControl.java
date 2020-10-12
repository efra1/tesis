package controladores;
import datos.Conexion;
import modelos.Persona;
import modelos.Usuario;
import modelos.rol;
import modelos.registroHumedad;
import modelos.registroTiempo;
import servicios.registroHumedadServicios;


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
@RequestMapping("/registroHumedad")

public class regitroHumedadControl {
@Autowired
private registroHumedadServicios registroHumedadS;
@RequestMapping("lista.html")
public String lista(Model m, HttpServletRequest req) {
	System.out.println("entro lista humedad");
	HttpSession sesion = req.getSession(true);
m.addAttribute("lista", this.registroHumedadS.lista());
	

	return "registroHumedad/listaHumedad";
}

@RequestMapping("nuevo.html")
public String nuevo(Model m, HttpServletRequest req){
	
	return "registroHumedad/nuevoRegistro";
}	
@RequestMapping("guardar.html")
public String guardar(HttpServletRequest req,registroHumedad h, String fecha_dato){
	try {
		h.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fecha_dato));
		
	} catch (ParseException e) {
		e.printStackTrace();
		
	}
	registroHumedadS.guardar(h);	
	System.out.println("registro humedad");
	return "redirect:lista.html";
}

@RequestMapping("editar.html")
public String editar(Model m,int id_reg){
	m.addAttribute("humedad",registroHumedadS.obtener(id_reg));
	return "registroHumedad/editar";
}

@RequestMapping("modificar")
public String modificar(registroHumedad h, String fecha_dato){
	try {
		h.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fecha_dato));
		
	} catch (ParseException e) {
		e.printStackTrace();
		
	}
	registroHumedadS.modificar(h);	
	System.out.println("modifico registro humedad");
	return "redirect:lista.html";

	

}

@RequestMapping("inhabilitar")
public String inhabilitar(Integer id_reg){
	registroHumedadS.inhabilitar(id_reg);
	//EtniaD.inhabilitar(id_etn);
	return "redirect:lista.html";
}
}
