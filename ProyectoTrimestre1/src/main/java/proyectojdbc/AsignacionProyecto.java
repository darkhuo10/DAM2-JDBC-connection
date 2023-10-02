package proyectojdbc;

import java.sql.Date;

public class AsignacionProyecto {
	private String dniEmpleado;
	private Integer numProyecto;
	private Date fInicio;
	private Date fFin;
	
	public AsignacionProyecto(String dniEmpleado, Integer numProyecto, Date fInicio, Date fFin) {
		this.dniEmpleado = dniEmpleado;
		this.numProyecto = numProyecto;
		this.fInicio = fInicio;
		this.fFin = fFin;
	}

	public String getDniEmpleado() {
		return dniEmpleado;
	}

	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	public Integer getNumProyecto() {
		return numProyecto;
	}

	public void setNumProyecto(Integer numProyecto) {
		this.numProyecto = numProyecto;
	}

	public Date getfInicio() {
		return fInicio;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public Date getfFin() {
		return fFin;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}

	@Override
	public String toString() {
		return "AsignacionProyecto [dniEmpleado=" + dniEmpleado + ", numProyecto=" + numProyecto + ", fInicio="
				+ fInicio + ", fFin=" + fFin + "]";
	}
	
	
}
