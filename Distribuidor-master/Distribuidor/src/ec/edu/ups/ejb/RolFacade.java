package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Provincia;
import ec.edu.ups.modelo.Rol;
@Stateless
public class RolFacade extends AbstractFacade<Rol> {

	@PersistenceContext(unitName = "Distribuidor")
	private EntityManager em;
	

	public RolFacade() {
		super(Rol.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Rol buscarRol(String nombre){
		Rol rol=new Rol();
		String sql="SELECT p FROM Rol p where p.nombre='"+nombre+"'";
		rol = (Rol) em.createQuery(sql).getSingleResult();
		return rol;
	}
}
