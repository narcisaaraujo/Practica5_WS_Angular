package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.jasper.tagplugins.jstl.ForEach;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Usuario;

@Stateless
public class FacturaCabeceraFacade extends AbstractFacade<FacturaCabecera>{
	@PersistenceContext(unitName = "Distribuidor")
    private EntityManager em;
    
    public FacturaCabeceraFacade() {
	super(FacturaCabecera.class);
    }    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Usuario> validarper( ) {    	
	
			String sql="SELECT u FROM Usuario u where u.roles.nombre = 'cliente'";
			
			List<Usuario> list = em.createQuery(sql).getResultList();
			System.out.println("Lista persona:" + list);
			return list;		
	}
    
 
}
