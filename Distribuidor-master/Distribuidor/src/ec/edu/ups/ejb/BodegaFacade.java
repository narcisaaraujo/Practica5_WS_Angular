package ec.edu.ups.ejb;

import ec.edu.ups.modelo.Bodega;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Ciudad;
import ec.edu.ups.modelo.Pais;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Provincia;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BodegaFacade extends AbstractFacade<Bodega> {

	@PersistenceContext(unitName = "Distribuidor")
	private EntityManager em;

	public BodegaFacade() {
		super(Bodega.class);
	}
//
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Ciudad validar(String ciudad) {
		Ciudad cat = new Ciudad();
		try {
			String sql = "SELECT c FROM Ciudad c where c.nombre='" + ciudad + "'";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			cat = (Ciudad) query.getSingleResult();
			System.out.println("recupere" + ciudad);
		} catch (Exception e) {
			System.out.println("ciudad" + e.getMessage());
		}

		return cat;

	}

	public Pais pais(String pais) {
		Pais cat = new Pais();
		try {
			String sql = "SELECT p FROM Pais p where p.nombre='" + pais + "'";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			cat = (Pais) query.getSingleResult();
			System.out.println("recupere pais:" + pais);
		} catch (Exception e) {
			System.out.println("pais" + e.getMessage());
		}

		return cat;

	}

	public Provincia recuperoProvincia(String provincia) {
		Provincia cat = new Provincia();
		try {
			String sql = "SELECT p FROM Provincia p where p.nombre='" + provincia + "'";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			cat = (Provincia) query.getSingleResult();
			System.out.println("recupere pais:" + provincia);
		} catch (Exception e) {
			System.out.println("pais" + e.getMessage());
		}

		return cat;

	}

	public List<Provincia> provincia(Pais pais) {

		String sql = "SELECT p FROM Provincia p where  p.pais.id=" + pais.getId();
		List<Provincia> list = em.createQuery(sql).getResultList();
		System.out.println("recuperooooooooooo");
		System.out.println(list);
		return list;

	}

	public List<Ciudad> ciudad(Provincia provincia) {

		String sql = "SELECT c FROM Ciudad c where  c.provincia.id=" + provincia.getId();
		List<Ciudad> list = em.createQuery(sql).getResultList();
		return list;
	}
	public List<Producto>  recuperarInventario(String bodega) {
		String sql = "select p "
				+ "from Producto p "
				+ "join p.bodegas b "
				+ "join b.producto bb "
				+ "where bb.name=:"+bodega+"";
		System.out.println(sql);
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
}
