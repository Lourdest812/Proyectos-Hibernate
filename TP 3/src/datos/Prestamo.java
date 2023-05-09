package datos;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import dao.Funciones;

public class Prestamo {
	private long idPrestamo;
	private LocalDate fecha;
	private double monto;
	private double interes;
	private int cantCuotas;
	private Cliente cliente;
	private Set<Cuota> cuotas;
	private boolean prestamoFinalizado;

	public Prestamo() {}

	public Prestamo(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente, boolean prestamoFinalizado) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.interes = interes;
		this.cantCuotas = cantCuotas;
		this.cliente = cliente;	
		this.prestamoFinalizado=prestamoFinalizado;
	}

	public long getIdPrestamo() {
		return idPrestamo;	
	}

	protected void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;	
	}

	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public int getCantCuotas() {
		return cantCuotas;
	}
	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Set<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(Set<Cuota> cuotas) {
		this.cuotas = cuotas;
	}
	
	public boolean isPrestamoFinalizado() {
		return prestamoFinalizado;
	}

	public void setPrestamoFinalizado(boolean prestamoFinalizado) {
		this.prestamoFinalizado = prestamoFinalizado;
	}
	/*
	@Override
	public int hashCode() {
		return Objects.hash(idPrestamo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		return idPrestamo == other.idPrestamo;
	}
	*/

	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", fecha=" + fecha + ", monto=" + monto + ", interes=" + interes
				+ ", cantCuotas=" + cantCuotas +  ", prestamoFinalizado="
				+ prestamoFinalizado + "]";
	}
	
	

}

