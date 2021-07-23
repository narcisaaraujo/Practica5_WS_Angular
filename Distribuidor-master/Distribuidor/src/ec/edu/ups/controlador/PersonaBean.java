package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Rol;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PersonaBean implements Serializable{
	@EJB
	private PersonaFacade ejbPersonaFacade;
	private List<Persona> list;
    private String nombre;
    private int id;
    private String apellido;
    private String telefono;
    private String cedula;
    private UsuarioBean ejbUsuarioBean;
    private String correo;
    private String contrasena;
    private Rol rol;
    
	public PersonaBean() {
		
	}
	
	 @PostConstruct
	    public void init() {
		//ejbPersonaFacade.create(new Persona("Helen","Companioni","0992726928","0151489812","Simon Bolivar"));
		list = ejbPersonaFacade.findAll();
	
	    }
	        
	    public Persona[] getList() {
		return list.toArray(new Persona[0]);
	    }

	    public void setList(List<Persona> list) {
		this.list = list;
	    }

	    public String add() {
	    ejbPersonaFacade.create(new Persona(this.id,this.nombre,this.apellido,this.telefono));
		list = ejbPersonaFacade.findAll();
		return null;
	    }

	    public String delete(Persona c) {	
	    	ejbPersonaFacade.remove(c);
		list = ejbPersonaFacade.findAll();
		return null;
	    }

	    
	    //para que se muestren los editables del proyecto (input) para editar
	    public String edit(Persona c) {
		c.setEditable(true);
		return null;
	    }

	    public String save(Persona c) {
	    	ejbPersonaFacade.edit(c);
		c.setEditable(false);
		return null;
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

		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public UsuarioBean getEjbUsuarioBean() {
			return ejbUsuarioBean;
		}

		public void setEjbUsuarioBean(UsuarioBean ejbUsuarioBean) {
			this.ejbUsuarioBean = ejbUsuarioBean;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		public String getContraseña() {
			return contrasena;
		}

		public void setContraseña(String contraseña) {
			this.contrasena = contraseña;
		}

		public String getContrasena() {
			return contrasena;
		}

		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}

		public Rol getRol() {
			return rol;
		}

		public void setRol(Rol rol) {
			this.rol = rol;
		}

		

	
}
