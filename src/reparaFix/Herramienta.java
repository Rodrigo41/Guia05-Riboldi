package reparaFix;

public class Herramienta {

	private String nombre;
	private Double costopordia;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getCostopordia() {
		return costopordia;
	}
	public void setCostopordia(Double costopordia) {
		this.costopordia = costopordia;
	}
	public Herramienta(String nombre, Double costopordia) {
		this.nombre = nombre;
		this.costopordia = costopordia;
	}
	
	
}
