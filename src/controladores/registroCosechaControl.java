package controladores;

import modelos.Persona;
import modelos.Usuario;
import modelos.rol;
import servicios.UsuarioServicio;
import servicios.registroCosechadorServicio;

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
@RequestMapping("/registroCosecha")
public class registroCosechaControl {
	@Autowired
	private registroCosechadorServicio registro;

	@RequestMapping("listaCosechadores.html")
	public String lista(Model m, HttpServletRequest req) {
		System.out.println("entro lista usuarios"+registro.listarUsuarios());
		HttpSession sesion = req.getSession(true);

		//m.addAttribute("usuario", this.usuarioServicio.listarUsuarios());
		m.addAttribute("lista",this.registro.listarUsuarios() );

		return "registroCosecha/listaCosechadores";
	}

	@RequestMapping("nuevoRegistro.html")
public String nuevoRegistro(Model m, HttpServletRequest req){
		return "registroCosecha/nuevoRegistroCosechador";
	}
}
