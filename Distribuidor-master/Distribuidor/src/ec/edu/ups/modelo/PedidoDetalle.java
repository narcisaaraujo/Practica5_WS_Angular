package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PedidoDetalle
 *
 */
@Entity

public class PedidoDetalle implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private int cantidad;
	private double subtotalDetalle;
    @Transient
	private boolean editable;
    @ManyToOne
    private  PedidosCabecera pedidosCabID;
    @ManyToOne
    private Producto proid;
    
    
    
    
    

	public PedidoDetalle(int cantidad, double subtotalDetalle,PedidosCabecera pedidosCabID, Producto proid) {
		super();
		this.cantidad = cantidad;
		this.subtotalDetalle = subtotalDetalle;
		this.pedidosCabID = pedidosCabID;
		this.proid = proid;
	}



	public PedidoDetalle() {
		super();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public boolean isEditable() {
		return editable;
	}



	public void setEditable(boolean editable) {
		this.editable = editable;
	}



	public PedidosCabecera getPedidosCabID() {
		return pedidosCabID;
	}



	public void setPedidosCabID(PedidosCabecera pedidosCabID) {
		this.pedidosCabID = pedidosCabID;
	}



	public Producto getProid() {
		return proid;
	}



	public void setProid(Producto proid) {
		this.proid = proid;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoDetalle other = (PedidoDetalle) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	private static PedidoDetalle pedidoDetalle;
	private static PedidosCabecera pedidoCabecera;
	private static Producto producto2;
	
	private static List<PedidosCabecera> pedidosCabeceraList = new ArrayList<>();
	private static List<Producto> productosList = new ArrayList<>();
	public static List<PedidoDetalle> serializePedidoDetalles(List<PedidoDetalle> Detalles) {
		List<PedidoDetalle> PedidoDetalleList = new ArrayList<>();
		
		Detalles.forEach(
				d->{
					pedidoCabecera = new PedidosCabecera(d.getPedidosCabID().getId(),d.getPedidosCabID().getFecha(),d.getPedidosCabID().getTotal(),d.getPedidosCabID().getEstadoPedido());
					producto2 = new Producto(d.getProid().getId(),d.getProid().getNombre(),d.getProid().getDescripcion(),d.getProid().getPreciounitario(),d.getProid().getPreciopublico(),d.getProid().getStock());
					pedidoDetalle = new PedidoDetalle(d.getCantidad(),d.getSubtotalDetalle(),pedidoCabecera,producto2);
					PedidoDetalleList.add(pedidoDetalle);
				}
				
				);
		
		return PedidoDetalleList;
	}
	
	@Override
	public String toString() {
		return "PedidoDetalle [id=" + id + ", cantidad=" + cantidad + ", subtotalDetalle=" + subtotalDetalle  + ", pedidosCabID=" + pedidosCabID + ", proid=" + proid
				+ "]";
	}
   
}
