package datos;

import java.time.LocalDate;
import java.util.Objects;

public class Cuota {
	private long idCuota;
	private int nroCuota;
	private LocalDate fechaVencimiento;
	private double saldoPendiente;
	private double amortizacion;
	private double interesCuota;
	private double cuota;
	private double deuda;
	private boolean cancelada;
	private LocalDate fechaDePago;
	private double punitorios;
	private Prestamo prestamo;

	public static double calculoAmortizacion(double saldoPendiente, double interesCuota, int cantCuotas) {
		return (saldoPendiente*interesCuota)/Math.pow((1+interesCuota/100), cantCuotas)-1;
	}
	
	public static double calculoInteres(double saldoPendiente, double interesCuota) {
		return saldoPendiente * interesCuota;
	}
	
	public static double calculoValorCuota(double amortizacion, double interesCuota) {
		 return amortizacion + interesCuota;
	}

	public static double calculoDeudaPendiente(double saldoPendiente, double amortizacion) {
		return  saldoPendiente - amortizacion;
	}
	
	public static double calculoSaldoPendiente(double amortizacion, double saldoPendiente) {
		return  saldoPendiente - amortizacion;
	}

	public Cuota(int nroCuota, LocalDate fechaVencimiento, double saldoPendiente, double amortizacion,
			double interesCuota, double cuota, double deuda, boolean cancelada, LocalDate fechaDePago,
			double punitorios) {
		this.nroCuota = nroCuota;
		this.fechaVencimiento = fechaVencimiento;
		//this.amortizacion = calculoAmortizacion(saldoPendiente, interesCuota);
		this.amortizacion = amortizacion;
		this.saldoPendiente = calculoSaldoPendiente(amortizacion, saldoPendiente);
		this.interesCuota = calculoInteres(saldoPendiente, interesCuota);
		this.cuota = calculoValorCuota(amortizacion, interesCuota);
		this.deuda = calculoDeudaPendiente(saldoPendiente, amortizacion);
		this.cancelada = cancelada;
		this.fechaDePago = fechaDePago;
		this.punitorios = punitorios;
	}
	
	public Cuota() {}
	
	public long getIdCuota() {
		return idCuota;
	}
	
	protected void setIdCuota(long idCuota) {
		this.idCuota = idCuota;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		//this.fechaVencimiento=LocalDate.of(fechaVencimiento.getYear(), fechaVencimiento.getMonthValue()+this.getNroCuota(), fechaVencimiento.getDayOfMonth());
		this.fechaVencimiento=fechaVencimiento;
	}

	public int getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}

	public double getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(double saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	public double getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(double amortizacion) {
		//this.amortizacion = (saldoPendiente*interesCuota)/Math.pow((1+interesCuota),prestamo.getCantCuotas()-(this.nroCuota-1))-1;
		this.amortizacion=amortizacion;
	}

	public double getInteresCuota() {
		return interesCuota;
	}

	public void setInteresCuota(double interesCuota) {
		//if(this.nroCuota==1) {
			this.interesCuota = saldoPendiente * interesCuota;
		//}
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		//if(this.nroCuota==1) {
			this.cuota = amortizacion+interesCuota;
		//}
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		if(this.nroCuota==1) {
			this.deuda = saldoPendiente-amortizacion;
		}
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = false;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public double getPunitorios() {
		return punitorios;
	}

	public void setPunitorios(double punitorios) {
		this.punitorios = punitorios;
	}
	
	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	/*
	@Override
	public int hashCode() {
		return Objects.hash(idCuota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuota other = (Cuota) obj;
		return idCuota == other.idCuota;
	}
	*/
	@Override
	public String toString() {
		return "Cuota [idCuota=" + idCuota + ", nroCuota=" + nroCuota + ", fechaVencimiento=" + fechaVencimiento
				+ ", saldoPendiente=" + saldoPendiente + ", amortizacion=" + amortizacion + ", interesCuota="
				+ interesCuota + ", cuota=" + cuota + ", deuda=" + deuda + ", cancelada=" + cancelada + ", fechaDePago="
				+ fechaDePago + ", punitorios=" + punitorios + "]";
	}

	
	
}
