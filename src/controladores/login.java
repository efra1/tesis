package controladores;

import java.io.IOException;
import java.sql.ResultSet;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import modelos.Persona;
import modelos.Usuario;
import servicios.UsuarioServicio;

@Controller
@RequestMapping("/principal")
public class login {
	@Autowired
	UsuarioServicio usuarioServicio;
	
	@RequestMapping("login.html")
	public String login() {
		System.out.println(this.usuarioServicio.listarUsuarios());
		return "login/login";
	}

	@RequestMapping("validar.html")
	public String validar(String login, String password, Model m, HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		System.out.println(login + " " + password);
		int validar = this.usuarioServicio.ValidarLogin(login, password);
		if (validar == 1) {
			// creamos la sesion
			HttpSession sesionLogin = req.getSession(true);
			sesionLogin.setAttribute("usuario", login);
			System.out.println("Sesion iniciada");
			res.sendRedirect("menu.html");
			return "principal/menuprincipal";
		} else {
			m.addAttribute("mensaje", "USUARIO NO AUTORIZADO... O SESION CADUCADO!");
			m.addAttribute("enlace", "login.html");
			return "principal/alerta";
		}
	}

	@RequestMapping("menu.html")
	public String MenuPrincipal(Model m, HttpServletRequest req) {
		HttpSession sesion = req.getSession(true);
		String login = (String) sesion.getAttribute("usuario");
		System.out.println("Este es el user:" + login);
		if (login == null) {
			m.addAttribute("mensaje", "ACCESO NO PERMITIDO... O SESSION CADUCADA!");
			m.addAttribute("enlace", "login.html");
			return "principal/alerta";
		} else {
			String persona = this.usuarioServicio.GetNombre(login);
			m.addAttribute("usuario", persona);
			m.addAttribute("login", login);
			return "principal/menuprincipal";
		}
	}

	@RequestMapping("index.html")
	public String menu(Model m, HttpServletRequest req) {
		HttpSession sesionLogin = req.getSession(true);
		//m.addAttribute("datosprincipal", this.datosServicio.listarDatos());
		//m.addAttribute("obtener", this.datosServicio.obtener(id_est));
		
		return "principal/vistainicial";
	}

	@RequestMapping({ "finaliza.html" })
	public String vista1(HttpServletRequest request, HttpServletResponse res, String login, Model model)
			throws IOException {
		HttpSession sesion = request.getSession(true);
		sesion.removeAttribute("usuario");
		sesion.invalidate();
		res.sendRedirect("login.html");
		
		
		return "login/login";
		
	}

}
