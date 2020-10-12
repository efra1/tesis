package modelos;

import java.util.Date;

public class registroTiempo {
private int id_t;
private Date fecha;
private String temp_maxima;
private String temp_minima;
private String temp_ambiente;
private boolean estado;
private int id_us;

public int getId_t() {
	return id_t;
}
public void setId_t(int id_t) {
	this.id_t = id_t;
}

public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getTemp_maxima() {
	return temp_maxima;
}
public void setTemp_maxima(String temp_maxima) {
	this.temp_maxima = temp_maxima;
}
public String getTemp_minima() {
	return temp_minima;
}
public void setTemp_minima(String temp_minima) {
	this.temp_minima = temp_minima;
}
public String getTemp_ambiente() {
	return temp_ambiente;
}
public void setTemp_ambiente(String temp_ambiente) {
	this.temp_ambiente = temp_ambiente;
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
	return "registroTiempo [id_t=" + id_t + ", fecha=" + fecha + ", temp_maxima=" + temp_maxima + ", temp_minima="
			+ temp_minima + ", temp_ambiente=" + temp_ambiente + ", estado=" + estado + "]";
}

}
