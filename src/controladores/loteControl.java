package controladores;
import modelos.Persona;
import modelos.Usuario;
import modelos.fincas;
import modelos.rol;
import modelos.lote;
import servicios.UsuarioServicio;
import servicios.fincasServicio;
import servicios.loteServicio;
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
@RequestMapping("/registroLote")
public class loteControl {
@Autowired
private loteServicio lote;

@RequestMapping("lista.html")
public String lista(Model m, HttpServletRequest req) {
	System.out.println("entro");
	HttpSession sesion = req.getSession(true);

//	m.addAttribute("lista",this.lote.getLotes());
	

	return "registroLote/lista";
}

@RequestMapping("nuevoLote.html")
public String nueva(Model m, HttpServletRequest req){
	
	return "registroLote/nuevoLote";
}
}
