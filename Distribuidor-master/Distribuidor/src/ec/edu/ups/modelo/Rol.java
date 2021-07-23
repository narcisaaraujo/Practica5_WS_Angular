package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rol
 *
 */
@Entity

public class Rol implements Serializable {

	//
	private static final long serialVersionUID = 1L;
	@Id
    private String nombre;
    private String descripcion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private List<Usuario> rol;
    
    @Transient
	private boolean editable;
    
	public Rol() {
		super();
	}

	
	public Rol(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		
	}







	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	public List<Usuario> getRol() {
		return rol;
	}




	public boolean isEditable() {
		return editable;
	}


	public void setEditable(boolean editable) {
		this.editable = editable;
	}


	public void setRol(List<Usuario> rol) {
		this.rol = rol;
	}


	public boolean addUsuario(Usuario usuario) {
		return this.rol.add(usuario);
	}


	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return nombre;
	}

	

	
   
	
	
}
