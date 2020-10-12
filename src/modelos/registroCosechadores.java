package modelos;
import java.util.Date;
public class registroCosechadores {
private int id_reg_us;
private Date fecha;
private String peso;
private boolean estado;
private int id_us;
private int id_lote;
public int getId_reg_us() {
	return id_reg_us;
}
public void setId_reg_us(int id_reg_us) {
	this.id_reg_us = id_reg_us;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getPeso() {
	return peso;
}
public void setPeso(String peso) {
	this.peso = peso;
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
public int getId_lote() {
	return id_lote;
}
public void setId_lote(int id_lote) {
	this.id_lote = id_lote;
}
@Override
public String toString() {
	return "registroCosechadores [id_reg_us=" + id_reg_us + ", fecha=" + fecha + ", peso=" + peso + ", estado=" + estado
			+ ", id_us=" + id_us + ", id_lote=" + id_lote + "]";
}


}
