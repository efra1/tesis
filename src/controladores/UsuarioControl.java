package controladores;

import modelos.Persona;
import modelos.Usuario;
import modelos.rol;
import servicios.UsuarioServicio;

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

@RequestMapping("/usuario")
public class UsuarioControl {
	@Autowired
	private UsuarioServicio usuarioServicio;

	@RequestMapping("listaUsuario.html")
	public String lista(Model m, HttpServletRequest req) {
		System.out.println("entro");
		HttpSession sesion = req.getSession(true);

		m.addAttribute("usuario", this.usuarioServicio.listarUsuarios());

		return "gestionUsuarios/listaUsuarios";
	}
	@RequestMapping("listaInhabilitado.html")
	public String listaI(Model m, HttpServletRequest req) {
		System.out.println("entro");
		HttpSession sesion = req.getSession(true);

		m.addAttribute("usuario", this.usuarioServicio.listarUsuariosI());

		return "gestionUsuarios/listaUsuariosI";
	}

	
	@RequestMapping("nuevo.html")
	public String nuevo(Model m, HttpServletRequest req) {
		m.addAttribute("roles", usuarioServicio.listarRoles());

		return "gestionUsuarios/nuevoUsuario";
	}
/*
@RequestMapping("getNuevo.html")
	public String GetNuevo(Model m, HttpServletRequest req) {
		m.addAttribute("roles", usuarioServicio.listarRoles());
		return "gestionUsuarios/getNuevo";
	}
	*/
	@RequestMapping("guardar.html")
	public String guardar(Persona p, Usuario u,String fecha){
		Integer id_per=usuarioServicio.guardarP(p);
		try {
			p.setF_nac(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		u.setId_per(id_per);
				usuarioServicio.guardarU(u);
		System.out.println("se guardo"+u +" "+p.toString() );
		return "redirect:listaUsuario.html";
	}
	
	
	@RequestMapping("inabilitar.html")
	public String inabilitar(int id_us, HttpServletRequest req) {
		usuarioServicio.inhabilitar(id_us);

		return "redirect:listaUsuario.html";
	}
	
	@RequestMapping("habilitar.html")
	public String habilitar(int id_us, HttpServletRequest req) {
		usuarioServicio.habilitar(id_us);

		return "redirect:listaInhabilitado.html";
	}


	@RequestMapping("editar.html")
	public String editar(Model m, HttpServletRequest req, int id_us) {
		m.addAttribute("usuario", usuarioServicio.obtenerUs(id_us));
		m.addAttribute("roles", usuarioServicio.listarRoles());

		return "gestionUsuarios/editar";
	}
	
	@RequestMapping("modificar.html")
	public String modificar(Model m, HttpServletRequest req, Usuario u) {
		usuarioServicio.modificar(u);
		
		return "redirect:listaUsuario.html";
	}
	
	
	
	/*	@RequestMapping("guardar.html")
	public @ResponseBody String guardar(HttpServletRequest req) throws ParseException {
		Usuario u = new Usuario();
		Persona p = new Persona();
		//String fecha = req.getParameter("f_nac");
		
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	//	Date date = format.parse(fecha);
	//	java.sql.Date sqlFecha = new java.sql.Date(date.getTime());
		
		u.setPassword(req.getParameter("password"));
		u.setLogin(req.getParameter("login"));
		u.setId_rol(Integer.parseInt(req.getParameter("id_rol")));
		
		p.setCi(Integer.parseInt(req.getParameter("ci")));
		p.setNombres(req.getParameter("nombres"));
		p.setApellidos(req.getParameter("apellidos"));
	//	p.setF_nac(sqlFecha);
		p.setSexo(req.getParameter("sexo"));
		p.setEstado(true);
		
		
		System.out.println("guardar el usuario " + u.toString());
		System.out.println("guardar el persona " + p.toString());
		usuarioServicio.guardar(p,u);
		return "redirect:usuario.html";
	*/	
	}


