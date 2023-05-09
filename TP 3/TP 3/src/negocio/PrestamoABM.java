package negocio;
import dao.Funciones;
import dao.PrestamoDao;
import java.util.Set;
import java.time.LocalDate;
import java.util.List;
import java.util.HashSet;
import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;

public class PrestamoABM {
	private PrestamoDao dao=new PrestamoDao();
	public Prestamo traerPrestamo(long idPrestamo) throws Exception{
		//Implementar: si el no existe el prestamo lanzar la excepción
		Prestamo p =dao.traer(idPrestamo);
		if(p==null) {
			throw new Exception("ERROR, no se encontro el prestamo indicado.");
		}
		return p;
	}
	
	public Prestamo traerPrestamoYCuotas(long idPrestamo){
		return dao.traerPrestamoYCuotas(idPrestamo);
	}
	
/*public int agregar(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente, boolean prestamoFinalizado) {
		
		Prestamo p = new Prestamo(fecha, monto, interes, cantCuotas, cliente, prestamoFinalizado);
		Cuota c;
		LocalDate fechaVencimientoCuota = fecha;
		double saldoPendiente = monto;
		
		//dao.agregar(p);
		
		Set <Cuota> lista = new HashSet<Cuota>();
		
		int cont = cantCuotas;
		
		for(int i=0; i<cantCuotas; i++) {
			
			fechaVencimientoCuota = fechaVencimientoCuota.plusDays((long)31);
			if(i>0)
				saldoPendiente = Cuota.calculoInteres(saldoPendiente, interes);
			
			double amortizacion= Cuota.calculoAmortizacion(saldoPendiente, interes,  cont-i);
			
			c = new Cuota(i+1, fechaVencimientoCuota, saldoPendiente, amortizacion, interes, monto, 150000, false, LocalDate.now(),0);
			
			//System.out.println("------------------CUOTA-------------------");
			//System.out.println(c.toString());
			//dao.agregarCuota(c);
			
			c.setPrestamo(p);
			
			lista.add(c);
		}
		
		p.setCuotas(lista);
		
		return dao.agregar(p);
	}
	*/
	
	public int agregar(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente c, boolean prestamoFinalizado) {
		
		Prestamo objeto = new Prestamo(fecha, monto, interes, cantCuotas, c, prestamoFinalizado);
		
		Cuota cuota;
		
		Set <Cuota> lista = new HashSet <Cuota>();
		
		LocalDate fechaVenc = fecha;
		double saldoPendiente = monto;
		int cont = cantCuotas;
		
		
		for(int i=0;i<objeto.getCantCuotas();i++) {
			System.out.println(i);
			fechaVenc = Funciones.traerProxDiaHabil(fechaVenc.plusMonths(1));
			double amortizacion= Cuota.calculoAmortizacion(saldoPendiente, interes,  cont-i);
			cuota = new Cuota(i+1, fechaVenc, saldoPendiente, amortizacion, interes, monto, 150000, false, LocalDate.now(), 0);
			cuota.setPrestamo(objeto);
			//dao.agregarCuota(cuota);
			System.out.println(lista.add(cuota));
			
		}
		
		objeto.setCuotas(lista);
		
		
		//objeto.setCuotas(calcularCuotas(objeto));
		
		return dao.agregar(objeto);
		
	}
	
	
	//public int agregar(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente c) {
		
		//Prestamo objeto = new Prestamo(fecha, monto, interes, cantCuotas, c, false);
		
		//objeto.setCuotas(calcularCuotas(objeto));
		
		//return dao.agregar(objeto);
	//}
	
	public void actualizar(Prestamo objeto) {
		dao.actualizar(objeto);
	}
	
	public void eliminar(Prestamo objeto) {
		//for(Cuota c : objeto.getCuotas()) {
			//dao.eliminar(c);
		//}
		dao.eliminar(objeto);
	}
	
	public void pagarPorCuotas(Prestamo objeto, int nroCuota) {
		dao.pagarPorCuotas(objeto, nroCuota);
	}
	
	public List<Prestamo> traerPrestamo(Cliente c) {
		return dao.traer(c);
		}
	
	public List<Prestamo> traerPrestamosImpagos(Cliente cliente, boolean prestamoFinalizado){
		return dao.traerPrestamosImpagos(cliente, prestamoFinalizado);
	}
	
	public Set <Cuota> calcularCuotas(Prestamo p){
		Set<Cuota> lista = new HashSet<Cuota>(); 
		boolean respuesta;
		
		double saldoPendiente = p.getMonto();
		double interes = p.getInteres()/100;
		int cantCuotas = p.getCantCuotas();
		LocalDate fechaVenc = p.getFecha();
		
		for(int i=0;i< p.getCantCuotas();i++) {
			fechaVenc=Funciones.traerProxDiaHabil(fechaVenc.plusMonths(1));
			
			double amortizacion = (saldoPendiente*interes)/(Math.pow((1+interes), cantCuotas-i)-1);
			double interesCuota = saldoPendiente*interes;
			double cuota = amortizacion*interesCuota;
			double deuda = saldoPendiente - amortizacion;
			saldoPendiente = saldoPendiente - amortizacion;
			
			Cuota c = new Cuota(i+1, fechaVenc, saldoPendiente, amortizacion, interesCuota, cuota, deuda,false, fechaVenc, 100);
			c.setPrestamo(p);
			respuesta = lista.add(c);
			System.out.println(respuesta);
		}
		return lista;
	}
	
	/* Pendiente implementar
	 * Alta, Modificar
	 */
	
	
}
