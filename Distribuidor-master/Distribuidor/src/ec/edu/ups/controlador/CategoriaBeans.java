package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.modelo.Categoria;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CategoriaBeans implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private CategoriaFacade ejbCategoriaFacade;
	private List<Categoria> listaCategorias;
	private String nombre;
	
	public CategoriaBeans() {
		
	}

	@PostConstruct
	public void init() {
		listaCategorias=ejbCategoriaFacade.findAll();
	}

	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
