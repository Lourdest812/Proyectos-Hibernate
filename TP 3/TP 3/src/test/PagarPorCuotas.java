package test;
import datos.Prestamo;
import negocio.PrestamoABM;
public class PagarPorCuotas {

	public static void main(String[] args) {
		PrestamoABM abm = new PrestamoABM();
		Prestamo p = null;
		try {
			p = abm.traerPrestamo(4l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		for(int i=1;i<=p.getCantCuotas();i++) {
			abm.pagarPorCuotas(p, i);
		}
		*/
		
		abm.pagarPorCuotas(p, 7);
		//abm.eliminar(p);
		
	}

}
