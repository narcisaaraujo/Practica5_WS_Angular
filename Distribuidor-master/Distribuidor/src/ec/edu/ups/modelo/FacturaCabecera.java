package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: FacturaCabecera
 *
 */
@Entity

public class FacturaCabecera implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fecha;
    private double total;
    private String estado;
    @Transient
	private boolean editable;
    @ManyToOne
    private Persona facturacab;
    @OneToMany(mappedBy = "faccabeid")
    private Set<FacturaDetalle> listFacturaDetalle;   
	
    public FacturaCabecera() {
		
	}
	
	
	
	public FacturaCabecera(String fecha, double total, String estado, Persona facturacab) {
		super();
		
		this.fecha = fecha;
		this.total = total;
		this.estado = estado;
		this.facturacab = facturacab;
		
		
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Persona getFacturacab() {
		return facturacab;
	}

	public void setFacturacab(Persona facturacab) {
		this.facturacab = facturacab;
	}

	public Set<FacturaDetalle> getListFacturaDetalle() {
		return listFacturaDetalle;
	}

	public void setListFacturaDetalle(Set<FacturaDetalle> listFacturaDetalle) {
		this.listFacturaDetalle = listFacturaDetalle;
	}
	
	public void addFacturaDetalle(FacturaDetalle facdet) {
		if(this.listFacturaDetalle==null) {
			listFacturaDetalle= new HashSet<FacturaDetalle>();
		}
		
		this.listFacturaDetalle.add(facdet);
		
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
		FacturaCabecera other = (FacturaCabecera) obj;
		if (id != other.id)
			return false;
		return true;
	}
	///
	@Override
	public String toString() {
		return "FacturaCabecera [id=" + id + ", fecha=" + fecha + ", total=" + total + ", estado=" + estado
				+ ", facturacab=" + facturacab + "]";
	}
}
