package test;
import java.util.List;
import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestTraerPrestamo {
	public static void main(String[] args) {
		PrestamoABM prestamoABM=new PrestamoABM();
		long idPrestamo=2;
		
		System.out.println("\n---> TraerPrestamo idPrestamo="+idPrestamo+"\n\n");
		
		Prestamo p;
		try {
			p = prestamoABM.traerPrestamo(idPrestamo);
			System.out.println(p + "\nPertenece a "+p.getCliente());
		} catch (Exception e) {
			System.out.println("Excepcion:" + e.getMessage());
		}
		//implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
		
		ClienteABM clienteABM=new ClienteABM();
		
		int dni=14000000;
		
		Cliente c= clienteABM.traer(dni);
		
		System.out.println("\n---> TraerPrestamos del Cliente="+c+ "\n\n");
		
		List<Prestamo> prestamos=prestamoABM.traerPrestamo(c);
		
		if(prestamos.isEmpty()) {
			System.out.println("El cliente no tiene prestamos.");
		}
		for (Prestamo o: prestamos) {System.out.println(o + "\nPertenece a "+o.getCliente());}
		
		List<Prestamo> prestamosImpagos = prestamoABM.traerPrestamosImpagos(c, true);
		
		System.out.println(prestamosImpagos.toString());
		
		for(Prestamo a : prestamosImpagos) {System.out.println("\nPrestamo: " + a.toString());};
		
	}
}

