package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Ciudad;
import ec.edu.ups.modelo.Pais;
import ec.edu.ups.modelo.Provincia;
@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> {

	@PersistenceContext(unitName = "Distribuidor")
	private EntityManager em;
	public CiudadFacade() {
		super(Ciudad.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Provincia validarpro(String pais ) {
		Provincia paiss=new Provincia();
		try {
			String sql="SELECT u FROM Provincia u where u.nombre='"+pais+"'";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			paiss= (Provincia) query.getSingleResult();
			System.out.println("recupere pro"+pais);	
		} catch (Exception e) {
			System.out.println("Provincia"+e.getMessage());
		}
			
		return paiss;
	
	}


}
