package ec.edu.ups.controlador;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Bean2 {
	private String property;
	public Bean2() {
		this.property="Soy Bean2 Mamiii";
		
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	

}
