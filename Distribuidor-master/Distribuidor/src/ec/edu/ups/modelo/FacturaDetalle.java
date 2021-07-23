package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FacturaDetalle
 *
 */
@Entity

public class FacturaDetalle implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int cantidad;
    private double subtotal;
    private double descuento;
    private double total;
    @Transient
	private boolean editable;
    

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	@ManyToOne
    private FacturaCabecera faccabeid;
    //productoooooooooooooooooooo
    @ManyToOne
    private Producto proid;
   
	public FacturaDetalle() {
		
	}

	public FacturaDetalle(int cantidad, double subtotal, double total, double descuento,
			Producto proid) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.total = total;
		this.descuento = descuento;
		this.proid = proid;
	}
	
	//Creacion de constructor
	public FacturaDetalle(int cantidad, double subtotal, double total, double descuento,
			FacturaCabecera faccabeid,Producto proid) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.total = total;
		this.descuento = descuento;
		this.faccabeid=faccabeid;
		this.proid = proid;
	}

	

	public Producto getProid() {
		return proid;
	}

	public void setProid(Producto proid) {
		this.proid = proid;
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}


	public FacturaCabecera getFaccabeid() {
		return faccabeid;
	}

	public void setFaccabeid(FacturaCabecera faccabeid) {
		this.faccabeid = faccabeid;
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
		FacturaDetalle other = (FacturaDetalle) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FacturaDetalle [id=" + id + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", descuento="
				+ descuento + ", total=" + total + ", editable=" + editable + ", faccabeid=" + faccabeid + ", proid="
				+ proid + "]";
	}

	
		
   
}
