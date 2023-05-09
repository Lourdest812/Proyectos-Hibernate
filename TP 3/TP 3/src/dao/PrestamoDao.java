package dao;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;
import java.util.HashSet;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;

public class PrestamoDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	
	public int agregar(Prestamo objeto) throws HibernateException {
		int id = 0;
		try {
			iniciaOperacion();
			id=Integer.parseInt(session.save(objeto).toString());
			//objeto.setCuotas(calcularCuotas(objeto));
			Hibernate.initialize(objeto.getCuotas());
			tx.commit();
		}catch (HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}
	
	public int agregarCuota(Cuota c) {
		int id=0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(c).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	
	public Prestamo traer(long idPrestamo) throws HibernateException {
		Prestamo obj = null;
		try {
			iniciaOperacion();
			String hQL = "from Prestamo p inner join fetch p.cliente c where p.idPrestamo=" + idPrestamo;
					obj = (Prestamo) session.createQuery(hQL).uniqueResult();
		} finally {
			session.close();
		}
		return obj;
	}
	
	
	
	public Prestamo traerPrestamoYCuotas(long idPrestamo)throws HibernateException {
        Prestamo p = null;
        try {
            iniciaOperacion();
            String hql = "from Prestamo p where p.idPrestamo = " + idPrestamo;
            p = (Prestamo)session.createQuery(hql).uniqueResult();
            Hibernate.initialize(p.getCuotas());
        }
        finally {
            session.close();
        }
        return p;
    }
	
	public void actualizar(Prestamo objeto)throws HibernateException{
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
			
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	public void eliminar(Prestamo objeto)throws HibernateException{
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	public void eliminar(Cuota objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked") 
	public List<Prestamo> traer(Cliente c) throws HibernateException {
		List<Prestamo> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Prestamo p inner join fetch p.cliente c where c.idCliente=" + c.getIdCliente();
					lista = session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Prestamo> traerPrestamosImpagos(Cliente cliente, boolean prestamoFinalizado){
		//List<Prestamo> lista = traer(cliente);
		List<Prestamo> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Prestamo p inner join fetch p.cliente c where c.idCliente=" + cliente.getIdCliente()+" and p.prestamoFinalizado="+prestamoFinalizado; 
			lista = session.createQuery(hQL).list();
		}finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cuota> traerCuotas(Prestamo p) throws HibernateException {
		List<Cuota> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Cuota c inner join fetch c.prestamo p where p.idPrestamo=" + p.getIdPrestamo();
			lista = session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public void pagarPorCuotas(Prestamo objeto, int nroCuota) {
		List <Cuota> lista = traerCuotas(objeto);
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getNroCuota()==nroCuota) {
				eliminar(lista.get(i));
			}
		}
	}
	
	
	
	
	
	
}