package modelos;

public class fincas {
private int id_finca;
private String nombre;
private String descripcion;
private boolean estado;
private int id_us;
public int getId_finca() {
	return id_finca;
}
public void setId_finca(int id_finca) {
	this.id_finca = id_finca;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public boolean isEstado() {
	return estado;
}
public void setEstado(boolean estado) {
	this.estado = estado;
}
public int getId_us() {
	return id_us;
}
public void setId_us(int id_us) {
	this.id_us = id_us;
}
@Override
public String toString() {
	return "fincas [id_finca=" + id_finca + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado
			+ ", id_us=" + id_us + "]";
}



}
