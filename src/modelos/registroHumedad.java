package modelos;

import java.util.Date;

public class registroHumedad {
private int id_reg;
private Date fecha;
private String humedad;
private boolean estado;
private int id_us;
public int getId_reg() {
	return id_reg;
}
public void setId_reg(int id_reg) {
	this.id_reg = id_reg;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getHumedad() {
	return humedad;
}
public void setHumedad(String humedad) {
	this.humedad = humedad;
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
	return "registroHumedad [id_reg=" + id_reg + ", fecha=" + fecha + ", humedad=" + humedad + ", estado=" + estado
			+ ", id_us=" + id_us + "]";
}


}
