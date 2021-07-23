package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PedidosCabecera
 *
 */
@Entity

public class PedidosCabecera implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String fecha;
	private double total;
	private String estadoPedido;
	@Transient
	private boolean editable;
	@OneToMany(mappedBy = "pedidosCabID")
	private Set<PedidoDetalle> listPedidosDetalles;
	
	@ManyToOne
	private Persona cliente;
	
	public PedidosCabecera(String fecha,double total,String estadoPedido, Persona usuario) {
		super();
		this.fecha=fecha;
		this.total=total;
		this.estadoPedido=estadoPedido;
		this.cliente=usuario;
	}
	
	//Se crea un nuevo constructor
	public PedidosCabecera(int id,String fecha,double total,String estadoPedido) {
		this.fecha=fecha;
		this.total=total;
		this.estadoPedido=estadoPedido;
	}

	public PedidosCabecera() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Set<PedidoDetalle> getListPedidosDetalles() {
		return listPedidosDetalles;
	}

	public void setListPedidosDetalles(Set<PedidoDetalle> listPedidosDetalles) {
		this.listPedidosDetalles = listPedidosDetalles;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
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
		PedidosCabecera other = (PedidosCabecera) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PedidosCabecera [id=" + id + ", fecha=" + fecha + ", total=" + total + ", estadoPedido=" + estadoPedido
				+ ", editable=" + editable + ", listPedidosDetalles=" + listPedidosDetalles + ", cliente=" + cliente
				+ "]";
	}
	//Debe Funcionar
	
}
