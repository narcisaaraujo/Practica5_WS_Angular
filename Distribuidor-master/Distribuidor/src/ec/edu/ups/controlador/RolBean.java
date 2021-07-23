package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class RolBean  implements Serializable{

	 @EJB
	 private RolFacade ejbRolFacade;
	 private List<Rol> list;
	 private List<Usuario> usuario;
	 private String nombre;
	 private String descripcion;
	 
	 public RolBean() {
		
	 }
	 
	 @PostConstruct
	 public void init() {
		 //ejbRolFacade.create(new Rol("admin","administracion"));
		// ejbRolFacade.create(new Rol("emple","Empleado"));
		 list= ejbRolFacade.findAll();
	 }

	public Rol[] getList() {
		return list.toArray(new Rol[0]);
	}

	public void setList(List<Rol> list) {
		this.list = list;
	}
	 
	 public String add() {
		    ejbRolFacade.create(new Rol(this.nombre,this.descripcion));
			list = ejbRolFacade.findAll();
			return null;
		    }

		    public String delete(Rol c) {	
		    	ejbRolFacade.remove(c);
			list = ejbRolFacade.findAll();
			return null;
		    }

		    
		    //para que se muestren los editables del proyecto (input) para editar
		    public String edit(Rol c) {
			c.setEditable(true);
			return null;
		    }

		    public String save(Rol c) {
		    	ejbRolFacade.edit(c);
			c.setEditable(false);
			return null;
		    }

			public List<Usuario> getUsuario() {
				return usuario;
			}

			public void setUsuario(List<Usuario> usuario) {
				this.usuario = usuario;
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

   
}
