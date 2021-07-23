package ec.edu.ups.ejb;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Pais;
@Stateless
public class PaisFacade  extends AbstractFacade<Pais>{
	
	@PersistenceContext(unitName = "Distribuidor")
	private EntityManager em;
	
	public PaisFacade() {
		super(Pais.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	

}
