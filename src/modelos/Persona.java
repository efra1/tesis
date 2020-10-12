package modelos;

import java.util.Date;

public class Persona {
	private Integer id_per;
	private String ci;
	private String nombres;
	private String apellidos;
	private Boolean sexo;
	private Date f_nac;
	private Boolean estado;

	public Integer getId_per() {
		return id_per;
	}

	public void setId_per(Integer id_per) {
		this.id_per = id_per;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Boolean getSexo() {
		return sexo;
	}

	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}

	public Date getF_nac() {
		return f_nac;
	}

	public void setF_nac(Date f_nac) {
		this.f_nac = f_nac;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	
}
