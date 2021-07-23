 package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Pais;
import ec.edu.ups.modelo.Producto;
@Stateless
public class ProductoFacade extends AbstractFacade<Producto>{
	
	 @PersistenceContext(unitName = "Distribuidor")
	    private EntityManager em;
	    
	    public ProductoFacade() {
		super(Producto.class);
	    }    

	    @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
	    
		public Categoria validar(String categoria ) {
			Categoria cat=new Categoria();
			try {
				String sql="SELECT c FROM Categoria c where c.nombre='"+categoria+"'";
				System.out.println(sql);
				Query query = em.createQuery(sql);
				cat= (Categoria) query.getSingleResult();
				System.out.println("recupere"+categoria);	
			} catch (Exception e) {
				System.out.println("Pais"+e.getMessage());
			}
				
			return cat;
			
		}
		
		public List<Producto> buscarProductos(int id){
			System.out.println("El id que resivo es:"+ id);
			String sql="SELECT p FROM Producto p where p.categoria.id='"+id+"'";
			List<Producto> list = em.createQuery(sql).getResultList();
			return list;
		}
		
		public List<Producto> buscarProductosnombre(String nombre){
			
			String sql="SELECT p FROM Producto p where p.categoria.nombre='"+nombre+"'";
			List<Producto> list = em.createQuery(sql).getResultList();
			return list;
		}
		
		public Bodega nombreBodega(String bodega) {
			Bodega cat = new Bodega();
			try {
				String sql = "SELECT b FROM Bodega b where b.nombre='" + bodega + "'";
				System.out.println(sql);
				Query query = em.createQuery(sql);
				cat = (Bodega) query.getSingleResult();

			} catch (Exception e) {
				System.out.println("bodega" + e.getMessage());
			}
			return cat;
		}
		
		
		public Producto nombreProducto(String producto) {
			Producto pro = new Producto();
			try {
				String sql = "SELECT b FROM Producto b where b.nombre='" + producto + "'";
				System.out.println(sql);
				Query query = em.createQuery(sql);
				pro = (Producto) query.getSingleResult();

			} catch (Exception e) {
				System.out.println("bodega" + e.getMessage());
			}
			return pro;
		}
}
