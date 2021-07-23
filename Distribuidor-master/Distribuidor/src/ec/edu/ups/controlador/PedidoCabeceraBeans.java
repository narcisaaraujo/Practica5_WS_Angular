package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.PedidoCabeceraFacade;
import ec.edu.ups.ejb.PedidosDetallesFacade;
import ec.edu.ups.modelo.PedidosCabecera;
import ec.edu.ups.modelo.Usuario;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidoCabeceraBeans implements Serializable {


	private static final long serialVersionUID = 1L;
	@EJB private PedidoCabeceraFacade ejbCabeceraFacade;
	private String fecha;
	private double total;
	private String estadoPedido;
	private List<PedidosCabecera> listPedidosCabecera;
	private List<Usuario> personalist;


	public PedidoCabeceraBeans() {

	}
	@PostConstruct
	public void init() {
		listPedidosCabecera = ejbCabeceraFacade.findAll();
	}
	
//Getters And Setters
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
	public String getEstadoPedido() {
		return estadoPedido;
	}
	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	public List<PedidosCabecera> getListPedidosCabecera() {
		return listPedidosCabecera;
	}
	public void setListPedidosCabecera(List<PedidosCabecera> listPedidosCabecera) {
		this.listPedidosCabecera = listPedidosCabecera;
	}
	public List<Usuario> getPersonalist() {
		return personalist;
	}
	public void setPersonalist(List<Usuario> personalist) {
		this.personalist = personalist;
	}
	
	

}
