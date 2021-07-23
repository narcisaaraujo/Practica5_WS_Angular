package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity

public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String nombre;
	private String apellido;
	private String telefono;
	
	@OneToMany(mappedBy = "facturacab")
	private Set<FacturaCabecera> listFacturasCab;
	@Transient
	private boolean editable;
	@OneToMany(mappedBy = "cliente")
	private Set<PedidosCabecera> listPedidos;
    
	
	
	public Persona() {

	}
	

	

	public Persona(int id, String nombre, String apellido, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<FacturaCabecera> getListFacturasCab() {
		return listFacturasCab;
	}

	public void setListFacturasCab(Set<FacturaCabecera> listFacturasCab) {
		this.listFacturasCab = listFacturasCab;
	}

	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
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
		Persona other = (Persona) obj;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return   nombre ;
	}	
}
