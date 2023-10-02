package proyectojdbc;

public class Empleado {
	private String dniNif;
	private String nomrbe;
	
	public Empleado(String dniNif, String nomrbe) {
		this.dniNif = dniNif;
		this.nomrbe = nomrbe;
	}

	public String getDniNif() {
		return dniNif;
	}

	public void setDniNif(String dniNif) {
		this.dniNif = dniNif;
	}

	public String getNomrbe() {
		return nomrbe;
	}

	public void setNomrbe(String nomrbe) {
		this.nomrbe = nomrbe;
	}

	@Override
	public String toString() {
		return "Empleado [dniNif=" + dniNif + ", nomrbe=" + nomrbe + "]";
	}
	
	

}
