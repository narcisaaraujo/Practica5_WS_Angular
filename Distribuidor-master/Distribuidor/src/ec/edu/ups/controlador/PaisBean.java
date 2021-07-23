package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.PaisFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Ciudad;
import ec.edu.ups.modelo.Pais;
import ec.edu.ups.modelo.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped

public class PaisBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private PaisFacade ejbPaisFacade;
	private List<Pais> listaPais;
	private String nombre;
	private String provincia;
	public PaisBean() {

	} 

	@PostConstruct
	public void init() {
	
		listaPais = ejbPaisFacade.findAll();
	}
	public Pais[] getList() {
			return listaPais.toArray(new Pais[0]);
	}

	public PaisFacade getEjbPaisFacade() {
		return ejbPaisFacade;
	}

	public void setEjbPaisFacade(PaisFacade ejbPaisFacade) {
		this.ejbPaisFacade = ejbPaisFacade;
	}
	public void setListaPais(List<Pais> listaPais) {
		this.listaPais = listaPais;
	}

	public List<Pais> getListaPais() {
		return listaPais;
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
}
