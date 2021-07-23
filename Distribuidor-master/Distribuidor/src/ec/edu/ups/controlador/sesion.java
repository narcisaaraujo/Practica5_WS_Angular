package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import ec.edu.ups.modelo.Usuario;

@Named
@ViewScoped
public class sesion implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void verificar() {
	System.out.println("verificar");
	try {
		FacesContext context= FacesContext.getCurrentInstance();
				
		Usuario usuario=(Usuario)context.getCurrentInstance().getExternalContext().getSessionMap().get("admin");
	if (usuario== null) {
		System.out.println("Nooooooooooooo");
		FacesContext.getCurrentInstance().getExternalContext().redirect("../Login.xhtml");
		
	}
	
	} catch (Exception e) {
		// TODO: handle exception
	}
}

public void verifica() {
	System.out.println("verificar");
	try {
		FacesContext context= FacesContext.getCurrentInstance();
				
		Usuario usuario=(Usuario)context.getCurrentInstance().getExternalContext().getSessionMap().get("admin");
	if (usuario== null) {
		System.out.println("Nooooooooooooo");
		FacesContext.getCurrentInstance().getExternalContext().redirect("Login.xhtml");
		
	}
	
	} catch (Exception e) {
		// TODO: handle exception
	}
}
public void verific() {
	System.out.println("verificar");
	try {
		FacesContext context= FacesContext.getCurrentInstance();
				
		Usuario usuario=(Usuario)context.getCurrentInstance().getExternalContext().getSessionMap().get("admin");
	if (usuario== null) {
		System.out.println("Nooooooooooooo");
		FacesContext.getCurrentInstance().getExternalContext().redirect("../Login.xhtml");
		
	}
	
	} catch (Exception e) {
		// TODO: handle exception
	}
}
public void verificar2() {
	System.out.println("empleado");
	try {
		FacesContext context= FacesContext.getCurrentInstance();
				
		Usuario usuario=(Usuario)context.getCurrentInstance().getExternalContext().getSessionMap().get("emple");
	if (usuario== null) {
		System.out.println("empleado");
		FacesContext.getCurrentInstance().getExternalContext().redirect("../Login.xhtml");		
	}
	
	} catch (Exception e) {
		// TODO: handle exception
	}
}


public void cerrar() {
	System.out.println("cerrar");
	try {
		FacesContext context = FacesContext.getCurrentInstance();

		ExternalContext externalContext = context.getExternalContext();

		Object session = externalContext.getSession(false);		
		if (session!= null) {
		System.out.println("Entro o no");		
		HttpSession httpSession = (HttpSession) session;
		httpSession.invalidate();
		FacesContext.getCurrentInstance().getExternalContext().redirect("../Login.xhtml");		
	}
	
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
//
