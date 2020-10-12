package modelos;

public class Usuario {
	private int id_us;
	private String login;
	private String password;
	private int id_per;
	private int id_rol;
	private boolean estado;

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Usuario() {
		super();
	}

	public int getId_us() {
		return id_us;
	}

	public void setId_us(int id_us) {
		this.id_us = id_us;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_per() {
		return id_per;
	}

	public void setId_per(int id_per) {
		this.id_per = id_per;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	@Override
	public String toString() {
		return "Usuario [id_us=" + id_us + ", login=" + login + ", password=" + password + ", id_per=" + id_per
				+ ", id_rol=" + id_rol + "]";
	}

}
