package reparaFix;

public class ServicioEstandar extends Servicio{

	private Double costo;
	
	@Override
	public Double calcularCosto() {
		return costo;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public ServicioEstandar(Double costo, Oficio oficio) {
		this.costo = costo;
		this.oficio=oficio;
	}

	
	
}
