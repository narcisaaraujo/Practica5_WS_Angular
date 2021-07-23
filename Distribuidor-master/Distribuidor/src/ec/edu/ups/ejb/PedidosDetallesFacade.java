package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.Pais;
import ec.edu.ups.modelo.PedidoDetalle;
import ec.edu.ups.modelo.PedidosCabecera;
import ec.edu.ups.modelo.Provincia;
import ec.edu.ups.modelo.Stock;
import ec.edu.ups.modelo.Usuario;

@Stateless
public class PedidosDetallesFacade  extends AbstractFacade<PedidoDetalle>{
	@PersistenceContext(unitName = "Distribuidor")
    private EntityManager em;

	public PedidosDetallesFacade() {
		// TODO Auto-generated constructor stub
		super(PedidoDetalle.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public List<PedidoDetalle> pedidosDetalle(Usuario usuario) {
		System.out.println("Correo llegada");
System.out.println(usuario);
		String sql = "SELECT p FROM PedidoDetalle p where  p.pedidosCabID.cliente.nombre='"+usuario.getNombre()+"'";
		System.out.println(sql);
		List<PedidoDetalle> list = em.createQuery(sql).getResultList();
		for (PedidoDetalle stock : list) {
			System.out.println("Nombre  Cliente"+stock.getPedidosCabID().getCliente().getNombre());
			System.out.println("fecha Cab"+stock.getPedidosCabID().getFecha());
			System.out.println("Total cab"+stock.getPedidosCabID().getTotal());
			System.out.println("Cantidades de prod detalle"+stock.getProid().toString());
			System.out.println("Subtotal detalle pedido"+stock.getSubtotalDetalle());
			System.out.println("Cantidad productos"+stock.getCantidad());
		}		
		System.out.println("recuperooooooooooo");
		System.out.println(list);
		return list;

	}
	public List<PedidoDetalle> pedidosDetallesFacturacion(){
		String sql = "SELECT p FROM PedidoDetalle p where  p.pedidosCabID.estadoPedido='Recibido'";
		System.out.println(sql);
		List<PedidoDetalle> list = em.createQuery(sql).getResultList();
		for (PedidoDetalle pedido : list) {
			System.out.println(pedido.getId());
			System.out.println(pedido.getCantidad());
			System.out.println(pedido.getSubtotalDetalle());
			System.out.println(pedido.getPedidosCabID().getId()+pedido.getPedidosCabID().getFecha()+pedido.getPedidosCabID().getEstadoPedido()+
					pedido.getPedidosCabID().getTotal()+pedido.getPedidosCabID().getCliente().getNombre()+pedido.getPedidosCabID().getId());
			System.out.println(pedido.getProid().getCantidad()+pedido.getProid().getNombre()+pedido.getProid().getDescripcion()+pedido.getProid().getPreciounitario()+pedido.getProid().getStock());	
		}
		System.out.println("recuperooooooooooo");
		System.out.println(list);
		return list;
		
	}
	
	public Usuario BUscarBycedula(int cedula) {
		String sql = "SELECT p FROM Usuario p where  p.id="+cedula+"";
		System.out.println(sql);

		Usuario usuario = new Usuario();
		usuario= (Usuario) em.createQuery(sql).getSingleResult();
		return usuario;
	}
	
	public PedidosCabecera BuscarCabecera(String nombre) {
		String sql = "SELECT p FROM PedidosCabecera p where  p.cliente.nombre='"+nombre+"'";
		System.out.println(sql);
		
		PedidosCabecera cabecera = new PedidosCabecera();
		cabecera=(PedidosCabecera)em.createQuery(sql).getSingleResult();
		return cabecera;	
	}
	
	
	public List<PedidosCabecera>   PedidosPorFacturar() {
		String sql = "SELECT p FROM PedidosCabecera p where  p.estadoPedido='Recibido'";
		System.out.println(sql);
		
		List<PedidosCabecera> list = em.createQuery(sql).getResultList();
		
		return list;
		
	}
	

}
