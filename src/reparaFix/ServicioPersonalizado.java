package reparaFix;

public class ServicioPersonalizado extends Servicio{

	private Double presupuesto;
	private Double materiales;
	private Double transporte;

	
	public ServicioPersonalizado(Double presupuesto, Double materiales, Double transporte, Oficio oficio) {
		this.presupuesto = presupuesto;
		this.materiales = materiales;
		this.transporte = transporte;
		this.oficio=oficio;
	}

	@Override
	public Double calcularCosto() {
		return presupuesto+materiales+transporte;
	}

	public Double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Double getMateriales() {
		return materiales;
	}

	public void setMateriales(Double materiales) {
		this.materiales = materiales;
	}

	public Double getTransporte() {
		return transporte;
	}

	public void setTransporte(Double transporte) {
		this.transporte = transporte;
	}


	
	
}
