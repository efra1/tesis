package modelos;

public class rol {
private int id_rol;
private String nombre;
private String descripcion;

public rol(){
	super();
}
public int getId_rol() {
	return id_rol;
}
public void setId_rol(int id_rol) {
	this.id_rol = id_rol;
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
@Override
public String toString() {
	return "rol [id_rol=" + id_rol + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
}


}
