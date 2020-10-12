package modelos;

public class lote {
private int id_lote;
private String nombre;
private String numPlantas;
private boolean estado;
private int id_finca;
public int getId_lote() {
	return id_lote;
}
public void setId_lote(int id_lote) {
	this.id_lote = id_lote;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getNumPlantas() {
	return numPlantas;
}
public void setNumPlantas(String numPlantas) {
	this.numPlantas = numPlantas;
}
public boolean isEstado() {
	return estado;
}
public void setEstado(boolean estado) {
	this.estado = estado;
}
public int getId_finca() {
	return id_finca;
}
public void setId_finca(int id_finca) {
	this.id_finca = id_finca;
}
@Override
public String toString() {
	return "lote [id_lote=" + id_lote + ", nombre=" + nombre + ", numPlantas=" + numPlantas + ", estado=" + estado
			+ ", id_finca=" + id_finca + "]";
}


}
