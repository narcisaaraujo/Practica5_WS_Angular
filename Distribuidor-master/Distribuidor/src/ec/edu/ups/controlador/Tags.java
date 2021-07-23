package ec.edu.ups.controlador;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Tags {
	 private String text;
	    private String secret;
	    private String hidden;
	    private String area;
	    private boolean checkbox;
	    private String[] mapValue = { "cero", "uno", "dos" };
	    private List<String> manyCheckbox;
	    private String[] manyCheckboxMap;
	    private String oneListbox;
	    private List<String> manyListbox;
	    private String oneMenu;
	    private List<String> manyMenu;
	    private Bean myClass = new Bean();

	    public Tags() {
		this.hidden = "oculto";
	    }

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getSecret() {
			return secret;
		}

		public void setSecret(String secret) {
			this.secret = secret;
		}

		public String getHidden() {
			return hidden;
		}

		public void setHidden(String hidden) {
			this.hidden = hidden;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}

		public boolean isCheckbox() {
			return checkbox;
		}

		public void setCheckbox(boolean checkbox) {
			this.checkbox = checkbox;
		}

		public String[] getMapValue() {
			return mapValue;
		}

		public void setMapValue(String[] mapValue) {
			this.mapValue = mapValue;
		}

		public List<String> getManyCheckbox() {
			return manyCheckbox;
		}

		public void setManyCheckbox(List<String> manyCheckbox) {
			this.manyCheckbox = manyCheckbox;
		}

		public String[] getManyCheckboxMap() {
			return manyCheckboxMap;
		}

		public void setManyCheckboxMap(String[] manyCheckboxMap) {
			this.manyCheckboxMap = manyCheckboxMap;
		}

		public String getOneListbox() {
			return oneListbox;
		}

		public void setOneListbox(String oneListbox) {
			this.oneListbox = oneListbox;
		}

		public List<String> getManyListbox() {
			return manyListbox;
		}

		public void setManyListbox(List<String> manyListbox) {
			this.manyListbox = manyListbox;
		}

		public String getOneMenu() {
			return oneMenu;
		}

		public void setOneMenu(String oneMenu) {
			this.oneMenu = oneMenu;
		}

		public List<String> getManyMenu() {
			return manyMenu;
		}

		public void setManyMenu(List<String> manyMenu) {
			this.manyMenu = manyMenu;
		}

		public Bean getMyClass() {
			return myClass;
		}

		public void setMyClass(Bean myClass) {
			this.myClass = myClass;
		}
	    
		/**
		 * Metodos
		 */
		 public String process() {
				System.out.println("Se procesa...");
				System.out.println("text: " + this.text);
				System.out.println("secret: " + this.secret);
				System.out.println("hidden: " + this.hidden);
				System.out.println("area: " + this.area);
				System.out.println("checkbox: " + this.checkbox);
				System.out.println("manyCheckbox: ");
				this.manyCheckbox.forEach(System.out::println);
				System.out.println("manyCheckboxMap: ");
				System.out.println(Arrays.toString(this.manyCheckboxMap));
				System.out.println("oneListbox: " + this.oneListbox);
				System.out.println("manyListbox: ");
				this.manyListbox.forEach(System.out::println);
				System.out.println("oneMenu: " + this.oneMenu);
				System.out.println("manyMenu: ");
				this.manyMenu.forEach(System.out::println);
				System.out.println("myClass: " + this.myClass.getName());
				return null;
			    }
		 
		 public String cambioPagina() {
			 String valor="cambioP";
			 System.out.println(valor);
			 
			return valor;
			 
		 }
}
