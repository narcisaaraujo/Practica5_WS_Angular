package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Usuario;
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria>{

	@PersistenceContext(unitName = "Distribuidor")
	private EntityManager em;
	

	public CategoriaFacade() {
		super(Categoria.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
}
