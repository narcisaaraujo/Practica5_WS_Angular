package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;


import ec.edu.ups.ejb.FacturaCabeceraFacade;
import ec.edu.ups.ejb.FacturaDetalleFacade;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Stock;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class buscarFact implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private FacturaDetalleFacade ejbBodegaFacade;
	private List<FacturaDetalle>lista;
	private String fact;
	@PostConstruct
	public void init() {
		lista= ejbBodegaFacade.findAll();

	}
	//
	public FacturaDetalleFacade getEjbBodegaFacade() {
		return ejbBodegaFacade;
	}

	public void setEjbBodegaFacade(FacturaDetalleFacade ejbBodegaFacade) {
		this.ejbBodegaFacade = ejbBodegaFacade;
	}

	public List<FacturaDetalle> getLista() {
		return lista;
	}

	public void setLista(List<FacturaDetalle> lista) {
		this.lista = lista;
	}

	public String getFact() {
		return fact;
	}
	public void setFact(String fact) {
		this.fact = fact;
	}
		
	public List<FacturaDetalle> add() {		
			lista=ejbBodegaFacade.factura(this.fact) ;
			System.out.println("Lista booodea invenentario");
			System.out.println(lista);
			return lista;
				
	}
}
