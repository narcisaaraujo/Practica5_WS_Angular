package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.FacturaCabeceraFacade;
import ec.edu.ups.ejb.FacturaDetalleFacade;
import ec.edu.ups.ejb.PedidoCabeceraFacade;
import ec.edu.ups.ejb.PedidosDetallesFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.PedidoDetalle;
import ec.edu.ups.modelo.PedidosCabecera;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidosDetallesBeans implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB PedidosDetallesFacade ejbPedidosDetallesFacade;
	@EJB PedidoCabeceraFacade  ejbPedidoCabeceraFacade;
	@EJB UsuarioFacade  ejbUsuarioFacade;
	@EJB FacturaCabeceraFacade ejbFacturaCabeceraFacade;
	@EJB FacturaDetalleFacade ejbFacturaDetalleFacade;
	@EJB UsuarioFacade ejbUsuarioFacade2;
	@EJB ProductoFacade ejbProductoFacade;
	
	private int cantidad;
	private double subtotalDetalle;
	private double total;
	private List<Producto> listProductos;
	private List<PedidoDetalle> listPedidosDetalles;
	private List<PedidosCabecera> listPeidodsCabeceras;
	private String correo; 
	private FacturaCabecera cabecera;
	private String NombreCliente;
	
	//Variables para el for normal y la cabecera 
	private PedidoDetalle pedidoDetalle;
	

	public PedidosDetallesBeans() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		listPeidodsCabeceras=ejbPedidosDetallesFacade.PedidosPorFacturar();
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotalDetalle() {
		return subtotalDetalle;
	}

	public void setSubtotalDetalle(double subtotalDetalle) {
		this.subtotalDetalle = subtotalDetalle;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Producto> getListProductos() {
		return listProductos;
	}

	public void setListProductos(List<Producto> listProductos) {
		this.listProductos = listProductos;
	}

	public List<PedidoDetalle> getListPedidosDetalles() {
		return listPedidosDetalles;
	}

	public void setListPedidosDetalles(List<PedidoDetalle> listPedidosDetalles) {
		this.listPedidosDetalles = listPedidosDetalles;
	}

	public List<PedidosCabecera> getListPeidodsCabeceras() {
		return listPeidodsCabeceras;
	}

	public void setListPeidodsCabeceras(List<PedidosCabecera> listPeidodsCabeceras) {
		this.listPeidodsCabeceras = listPeidodsCabeceras;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	

//Metodos para agregar, listar, modificar y Eliminar
	
	public String remove(PedidoDetalle pd) {
		ejbPedidosDetallesFacade.remove(pd);
		listPedidosDetalles=ejbPedidosDetallesFacade.findAll();
		return null;
	}
	
	public String edit(PedidoDetalle pd) {
		pd.setEditable(true);
		return null;
	}
	
	public String save(PedidoDetalle pd) {
		ejbPedidosDetallesFacade.edit(pd);
		pd.setEditable(false);
		return null;
	}
	
	public String Facturar() {
		System.out.println("Se procede a facturar el pedido");
		List<PedidoDetalle> PedidoDetalleList = ejbPedidosDetallesFacade.pedidosDetallesFacturacion();
		System.out.println(PedidoDetalleList);
		String estado="A";
		
		
	for (PedidoDetalle pedidoDetalle : PedidoDetalleList) {
		System.out.println("Fecha"+pedidoDetalle.getPedidosCabID().getFecha());
		System.out.println("TOtal"+pedidoDetalle.getPedidosCabID().getTotal());
		System.out.println("CantidadProducto"+pedidoDetalle.getCantidad());
		System.out.println("Cliente cedula "+pedidoDetalle.getPedidosCabID().getCliente().getId());
		
	
		
		Usuario usuario = ejbPedidosDetallesFacade.BUscarBycedula(pedidoDetalle.getPedidosCabID().getCliente().getId());
		Producto producto =  ejbProductoFacade.find(pedidoDetalle.getProid().getId());
		System.out.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU---->"+usuario);
		
		NombreCliente=usuario.getNombre();
		System.out.println("Nombre del cliente******"+NombreCliente);
		cabecera = new FacturaCabecera(pedidoDetalle.getPedidosCabID().getFecha(),
				pedidoDetalle.getPedidosCabID().getTotal(),estado,usuario);
		
		FacturaDetalle detalle = new FacturaDetalle(pedidoDetalle.getCantidad(),pedidoDetalle.getSubtotalDetalle(),
			pedidoDetalle.getPedidosCabID().getTotal(),0.0,cabecera,producto);
		
		System.out.println("FACTURA CABEZERA---->"+cabecera.toString());
		System.out.println("FACTURA DETALLE----->"+detalle.toString());
		//System.out.println("Producto recuperado por le ID--->"+producto);
		
		//Se procede Persistir en la BD
		ejbFacturaCabeceraFacade.create(cabecera);
		ejbFacturaDetalleFacade.create(detalle);
		
		
		PedidosCabecera pedido= new PedidosCabecera();
		pedido=pedidoDetalle.getPedidosCabID();
		pedido.setEstadoPedido("Facturado");
		ejbPedidoCabeceraFacade.edit(pedido);
		
		
		listPeidodsCabeceras=ejbPedidosDetallesFacade.PedidosPorFacturar();

		
	}
		
		
		
		return "funciona";
	}

	public String prueba() {
		List<PedidoDetalle> lista= ejbPedidosDetallesFacade.pedidosDetalle(usu());
		System.out.println("coreo entrante");
		System.out.println(correo);
		System.out.println("kjdfnldkjfg Listaaaaaa de pedidos por correo");
		System.out.println(lista);
		return null;
		
	}
	public Usuario usu() {
		Usuario u= ejbUsuarioFacade.buscarid(correo);
		return u;
	}


}
