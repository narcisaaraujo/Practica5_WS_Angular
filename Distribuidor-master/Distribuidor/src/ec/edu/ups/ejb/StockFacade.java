package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Provincia;
import ec.edu.ups.modelo.Stock;
@Stateless
public class StockFacade extends AbstractFacade<Stock> {

	@PersistenceContext(unitName = "Distribuidor")
	private EntityManager em;

	public StockFacade() {
		super(Stock.class);
	}
//
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	public Bodega nombreBodega(String bodega) {
		Bodega cat = new Bodega();
		System.out.println("Bodegaaaaaaaaaaaaaaaaa");
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
	
	public List<Stock>listaInventario(Bodega bodega){
	
		String sql = "SELECT s FROM Stock s where  s.bodega.nombre='" + bodega.getNombre()+"'";
		System.out.println(sql);
		List<Stock> list = em.createQuery(sql).getResultList();
		for (Stock stock : list) {
			System.out.println("Nombre  bodega"+stock.getBodega().getNombre());
			System.out.println("Direccion Bodega"+stock.getBodega().getCiudad().getNombre());			
			System.out.println("Nombre producto"+stock.getProducto().getNombre());
			System.out.println("Descripcion Producto"+stock.getProducto().getDescripcion());
			System.out.println("Precio Publico"+stock.getProducto().getPreciopublico());
			System.out.println("Precio Unitario"+stock.getProducto().getPreciounitario());
			System.out.println("Stock"+stock.getProducto().getStock());
			System.out.println("Categoria"+stock.getProducto().getCategoria().getNombre());
		}
		System.out.println("recuperooooooooooo stock");
		System.out.println(list);
		return list;
	}
	
	public List<Stock> bodegasCategorias_Productos(String bodega, String categoria){
		System.out.println(bodega);
		System.out.println(categoria);
		String sql = "SELECT s FROM Stock s where  s.bodega.nombre='" + bodega+"' AND  s.producto.categoria.nombre='"+categoria+"'";
		System.out.println(sql);
		List<Stock> list = em.createQuery(sql).getResultList();
		for (Stock stock : list) {
			System.out.println("Id" + stock.getBodega().getId());
			System.out.println("Nombre  bodega"+stock.getBodega().getNombre());
			//System.out.println("Direccion Bodega"+stock.getBodega().getCiudad().getNombre());			
			System.out.println("Nombre producto"+stock.getProducto().getNombre());
			System.out.println("Descripcion Producto"+stock.getProducto().getDescripcion());
			System.out.println("Precio Publico"+stock.getProducto().getPreciopublico());
			System.out.println("Precio Unitario"+stock.getProducto().getPreciounitario());
			System.out.println("Stock"+stock.getProducto().getStock());
			System.out.println("Categoria"+stock.getProducto().getCategoria().getNombre());
		}
		System.out.println("recuperooooooooooo stock");
		System.out.println(list);
		
		return list;
		
	}
}
