package proyectojdbc;

import java.sql.Date;

public class Proyecto {
	private Integer numero;
	private String nombre;
	private String dniNifJefe;
	private Date inicio;
	private Date fin;
	
	public Proyecto(Integer numeroProyecto, String nombreProyecto, String dniNifJefe, Date inicio, Date fin) {
		this.numero = numeroProyecto;
		this.nombre = nombreProyecto;
		this.dniNifJefe = dniNifJefe;
		this.inicio = inicio;
		this.fin = fin;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDniNifJefe() {
		return dniNifJefe;
	}

	public void setDniNifJefe(String dniNifJefe) {
		this.dniNifJefe = dniNifJefe;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "Proyecto [numero=" + numero + ", nombre=" + nombre + ", dniNifJefe=" + dniNifJefe + ", inicio=" + inicio
				+ ", fin=" + fin + "]";
	}
	
	
	
}
