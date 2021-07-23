package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Provincia
 *
 */
@Entity

public class Provincia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	
	@ManyToOne
	private Pais pais;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "provincia")
	private List<Ciudad> listaCiudades;
	
	public Provincia(String nombre,Pais pais) {
		super();
		this.pais=pais;
		this.nombre=nombre;
	}
	
	public Provincia() {
		
	}

//Getters and Setters.
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Ciudad> getListaCiudades() {
		return listaCiudades;
	}

	public void setListaCiudades(List<Ciudad> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}

//HashCode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Provincia other = (Provincia) obj;
		if (id != other.id)
			return false;
		return true;
	}

//toString
	@Override
	public String toString() {
		return  nombre ;
	}
	
   
}
