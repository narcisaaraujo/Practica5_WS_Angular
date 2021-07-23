package ec.edu.ups.controlador;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Navigator {
 private String page;
//
public Navigator() {
	
}
	
	public String process() {
		if (page==null || page.trim().isEmpty()) 
			return null;
		else if (page.equalsIgnoreCase("inventario")) 
			return "inventario";
		else if (page.equalsIgnoreCase("distribuidora")) 
			return "Distribuidora";	
		
		return page;
		
	}
	
}
