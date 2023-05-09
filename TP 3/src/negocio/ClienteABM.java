package negocio;
import java.time.LocalDate;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();
	
	public Cliente traer(long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;	
	}
	
	public Cliente traer(int dni) {
		Cliente c = dao.traer(dni);
		return c;
		
	}
	
	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
// consultar si existe un cliente con el mismo dni, si existe arrojar la
// Excepcion
		Cliente consulta = traer(dni);
		if(consulta!=null) {
			throw new Exception("Error, ya existe un cliente con el dni ingresado.");
		}
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return dao.agregar(c);
	}
	
	public void modificar(Cliente c) throws Exception {
		if(traer(c.getDni())==null && traer(c.getIdCliente())==null) {
			throw new Exception("El cliente a modificar no existe.");
		}
//implementar antes de actualizar que no exista un cliente con el mismo
//documento a modificar y con el mismo id, lanzar la Exception
		dao.actualizar(c);	
	}
	
	public void eliminar(long idCliente) throws Exception {
//en este caso es física en gral. no se se aplicaría este caso de uso, si
//se hiciera habría que validar que el cliente no tenga dependencias
		Cliente c = dao.traer(idCliente);
		if(c==null) {
			throw new Exception("No existe un cliente con el id dado.");
		}
// Implementar que si es null que arroje la excepción la Excepción
		dao.eliminar(c);	
	}
	
	public void eliminar(Cliente objeto) throws Exception{
		dao.eliminar(objeto);
	}
	
	public List<Cliente> traer() {
		return dao.traer();	
	}
	
	public Cliente traerClienteYPrestamos(long idCliente) {
		return dao.traerClienteYPrestamos(idCliente);
	}

}

