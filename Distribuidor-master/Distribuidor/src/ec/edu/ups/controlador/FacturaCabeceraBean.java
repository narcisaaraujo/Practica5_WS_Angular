package ec.edu.ups.controlador;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.FacturaCabeceraFacade;
import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacturaCabeceraBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FacturaCabeceraFacade ejbFacturaCabeceraFacade;
	private PersonaFacade personaFacade;
	private String fecha;
	private double total;
	private String estado;
	private String persona;
	private List<Usuario> personalist;
	private Set<FacturaCabecera> listaFacturaCabe;
	
	
	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public FacturaCabeceraBean() {
	
	}
	
	@PostConstruct
	public void init() {
		//ejbProductoFacade.create(new Producto("Papel","Scot",1.35,1.12));
		//ejbProductoFacade.create(new Producto("Deja","Ariel",2.49,1.89));
		//listaFacturaCabe= ejbFacturaCabeceraFacade.findAll();
		personalist = new ArrayList<Usuario>();	
		buscar();
	}

	public FacturaCabeceraFacade getEjbFacturaCabeceraFacade() {
		return ejbFacturaCabeceraFacade;
	}

	public void setEjbFacturaCabeceraFacade(FacturaCabeceraFacade ejbFacturaCabeceraFacade) {
		this.ejbFacturaCabeceraFacade = ejbFacturaCabeceraFacade;
	}

	public PersonaFacade getPersonaFacade() {
		return personaFacade;
	}

	public void setPersonaFacade(PersonaFacade personaFacade) {
		this.personaFacade = personaFacade;
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

	public FacturaCabecera[] getListaFacturaCabe() {
		return listaFacturaCabe.toArray(new FacturaCabecera[0]);
	}

	public void setListaFacturaCabe(Set<FacturaCabecera> listaFacturaCabe) {
		this.listaFacturaCabe = listaFacturaCabe;
	}
	public List<Usuario> getPersonalist() {
		return personalist;
	}

	public void setPersonalist(List<Usuario> personalist) {
		this.personalist = personalist;
	}

	//Metodos para agregar, listar, modificar y Eliminar
	public String add() {
	
	
	//ejbFacturaCabeceraFacade.create(new FacturaCabecera(this.fecha,this.total,this.estado,buscar()));								
	//listaFacturaCabe= ejbFacturaCabeceraFacade.findAll();
		
	return null;
	}
	
	public String remove(FacturaCabecera fc) {
		ejbFacturaCabeceraFacade.remove(fc);
		//listaFacturaCabe = ejbFacturaCabeceraFacade.findAll();
		return null;
	}
	
	public String edit(FacturaCabecera fc) {
		fc.setEditable(true);
		return null;
	}

	
	public String save(FacturaCabecera fc) {
		ejbFacturaCabeceraFacade.edit(fc);
		fc.setEditable(false);
		return null;
	}
	
	public List<Usuario> buscar() {
		
		System.out.println("Si entroooooo");
		personalist = ejbFacturaCabeceraFacade.validarper();
		System.out.println("Lista:" +personalist);
	
		return personalist;
		
	}
}