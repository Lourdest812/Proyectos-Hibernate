package test;
import negocio.PrestamoABM;
import datos.Prestamo;

public class TestEliminarPrestamo {

	public static void main(String[] args) {
		PrestamoABM prestamo = new PrestamoABM();
		Prestamo p = new Prestamo();
		long id = 4;
		
		try {
			p = prestamo.traerPrestamo(id);
			prestamo.eliminar(p);
		}catch(Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
	}

}
