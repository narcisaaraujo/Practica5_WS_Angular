
package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CiudadFacade;
import ec.edu.ups.ejb.ProvinciaFacade;
import ec.edu.ups.modelo.Ciudad;
import ec.edu.ups.modelo.Pais;
import ec.edu.ups.modelo.Provincia;
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CiudadBean  implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private CiudadFacade ejbCiudadFacade;
	private List<Ciudad> listaCiudad;
	private String nombre;
	private String provincia;
		//kdjfndkfkdfn
	public CiudadBean() {
		
	}
	
	@PostConstruct
	public void init() {
	//	ejbProvinciaFacade.create(new Provincia("Ecuador", pais));	
		listaCiudad = ejbCiudadFacade.findAll();
	}
	
	

	
	public CiudadFacade getEjbCiudadFacade() {
		return ejbCiudadFacade;
	}

	public void setEjbCiudadFacade(CiudadFacade ejbCiudadFacade) {
		this.ejbCiudadFacade = ejbCiudadFacade;
	}

	public List<Ciudad> getListaCiudad() {
		return listaCiudad;
	}

	public void setListaCiudad(List<Ciudad> listaCiudad) {
		this.listaCiudad = listaCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String process() {
			System.out.println("Se procesa...");
			System.out.println("Objetoooooo: " + this.provincia);
		
			return null;
	}
}
