package controladores;

import modelos.Persona;
import modelos.Usuario;
import modelos.fincas;
import modelos.lote;
import modelos.rol;
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
@RequestMapping("/fincas")
public class fincaControl {
	@Autowired
	private fincasServicio fincasServicio;
	@Autowired
	private loteServicio loteServicio;
	
	@RequestMapping("listaFincas.html")
	public String lista(Model m, HttpServletRequest req) {
		System.out.println("entro");
		HttpSession sesion = req.getSession(true);

		m.addAttribute("listaFincas",this.fincasServicio.getFincas());
		

		return "registroFinca/listaFincas";
	}

	@RequestMapping("nuevaFinca.html")
	public String nueva(Model m, HttpServletRequest req){
		
		return "registroFinca/nuevaFinca";
	}
	
	@RequestMapping("guardar.html")
	public String guardar(Model m,fincas f,HttpServletRequest req){
		HttpSession sesion=req.getSession();
		
		fincasServicio.guardarFinca(f);
		return "redirect:listaFincas.html";
	}
	
	@RequestMapping("editar.html")
	public String editar(Model m,Integer id_finca){
		m.addAttribute("finca",fincasServicio.obtener(id_finca));
		return "RegistroFinca/modificar";
	}
	
	@RequestMapping("modificar")
	public String modificar(fincas r){
		fincasServicio.modificar(r);
		
		return "redirect:listaFincas.html";
	}
	
	@RequestMapping("inhabilitar")
	public String inhabilitar(Integer id_finca){
		fincasServicio.eliminar(id_finca);
		
		return "redirect:listaFincas.html";
	}

	
}
