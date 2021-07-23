package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario extends Persona implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String correo;
	private String contraseña;
	@Transient
	private boolean editable;
	 @ManyToOne
	private Rol roles;
	
	private String estado ="A";
	
	public Usuario() {
		super();
	}

	public Usuario(int id,String nombre, String apellido, String telefono,String correo, String contraseña,Rol roles,String estado) {
		super(id,nombre, apellido, telefono);
		this.correo = correo;
		this.contraseña = contraseña;
		this.roles=roles;
		this.estado=estado;
	}



	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Rol getRoles() {
		return roles;
	}

	public void setRoles(Rol roles) {
		this.roles = roles;
	}

//usuario
	

	public boolean isEditable() {
		return editable;
	}



	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	
	
	
	
	//@Override
	//public String toString() {
	//	return "Usuario [correo=" + correo + ", contraseña=" + contraseña + ", roles=" + roles +"]";
	//}
	
	
	
	
   
	
}
