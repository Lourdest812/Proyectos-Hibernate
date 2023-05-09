package test;
import negocio.ClienteABM;
import datos.Cliente;

public class TestEliminarCliente {
	public static void main(String[] args) {
		ClienteABM abm = new ClienteABM();
		Cliente cliente = new Cliente();
		long id = 5;
		cliente = abm.traer(id);
		
		try {
			abm.eliminar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
