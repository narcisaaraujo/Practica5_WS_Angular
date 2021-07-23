package ec.edu.ups.controlador;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import org.eclipse.persistence.internal.jpa.config.mappings.ManyToOneImpl;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.PaisFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.StockFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Ciudad;
import ec.edu.ups.modelo.Pais;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Provincia;
import ec.edu.ups.modelo.Stock;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class BodegaBeans implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private BodegaFacade ejbBodegaFacade;
	@EJB
	private StockFacade ejbStockFacade;
	private String listaBdoega;
	private String nombre;
	
	private Set<Producto> manyListbox;
	private String provincia;
	private String ciudad;
	private String producto;
	private List<Bodega> listaBodega;
	private PaisFacade ejbPaisFacade;
	private List<Pais> listaPais;
	private List<Provincia> listaProvincia;
	private List<Ciudad> listaCiudad;
	private String pais;
	public BodegaBeans() {

	}

	@PostConstruct
	public void init() {

		manyListbox = new HashSet<Producto>();
		listaCiudad = new ArrayList<Ciudad>();
		listaProvincia = new ArrayList<Provincia>();
		listaBodega = ejbBodegaFacade.findAll();

	}

	public List<Ciudad> getListaCiudad() {
		return listaCiudad;
	}

	public void setListaCiudad(List<Ciudad> listaCiudad) {
		this.listaCiudad = listaCiudad;
	}

	public List<Provincia> getListaProvincia() {
		return listaProvincia;
	}

	public void setListaProvincia(List<Provincia> listaProvincia) {
		this.listaProvincia = listaProvincia;
	}

	public List<Pais> getListaPais() {
		return listaPais;
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

	
	public void setListaBodega(List<Bodega> listaBodega) {
		this.listaBodega = listaBodega;
	}

	public Bodega[] getListaBodega() {
		return listaBodega.toArray(new Bodega[0]);
	}

	public BodegaFacade getEjbBodegaFacade() {
		return ejbBodegaFacade;
	}

	public void setEjbBodegaFacade(BodegaFacade ejbBodegaFacade) {
		this.ejbBodegaFacade = ejbBodegaFacade;
	}

	public String getListaBdoega() {
		return listaBdoega;
	}

	public void setListaBdoega(String listaBdoega) {
		this.listaBdoega = listaBdoega;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public StockFacade getEjbStockFacade() {
		return ejbStockFacade;
	}

	public void setEjbStockFacade(StockFacade ejbStockFacade) {
		this.ejbStockFacade = ejbStockFacade;
	}


	public Set<Producto> getManyListbox() {
		return manyListbox;
	}

	public void setManyListbox(Set<Producto> manyListbox) {
		this.manyListbox = manyListbox;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;

	}

	public String add() {
		
		System.out.println("Lista productos en bodegas");	
		ejbBodegaFacade.create(new Bodega(this.nombre, process()));
		listaBodega = ejbBodegaFacade.findAll();
		return null;

	}

	public String remove(Bodega p) {
		ejbBodegaFacade.remove(p);
		listaBodega = ejbBodegaFacade.findAll();
		return null;
	}

	public String edit(Bodega p) {
		p.setEditable(true);
		return null;
	}

	public String save(Bodega p) {
		ejbBodegaFacade.edit(p);
		p.setEditable(false);
		return null;
	}

	/**
	 * Metodos
	 */


	public Ciudad process() {
		Ciudad ciudadd = new Ciudad();
		ciudadd = ejbBodegaFacade.validar(ciudad);
		System.out.println("Ciudad");
		System.out.println(ciudadd.toString());
		return ciudadd;
	}

	public Pais retornarrpais() {
		Pais paisss = new Pais();
		paisss = ejbBodegaFacade.pais(pais);
		return paisss;
	}

	public Provincia retornarProvincia() {
		Provincia pro = new Provincia();
		pro = ejbBodegaFacade.recuperoProvincia(provincia);
		System.out.println(pro);
		return pro;
	}

	/*
	 * Ajaxxx
	 * 
	 */
	public void cargarProvincia(AjaxBehaviorEvent event) {
		listaProvincia = ejbBodegaFacade.provincia(retornarrpais());
		System.out.println(listaProvincia);
	}

	public void cargarCiudades(AjaxBehaviorEvent event) {
		listaCiudad = ejbBodegaFacade.ciudad(retornarProvincia());
		System.out.println(listaProvincia);
	}

	/**
	 * Inventario
	 */
	
}
