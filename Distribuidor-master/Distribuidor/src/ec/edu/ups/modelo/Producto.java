package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Distribuidora
 *
 */
@Entity

public class Producto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String descripcion;
	private double preciounitario;
	private double preciopublico;
	private int stock;
	@Transient
	private int cantidad;
	@Transient
	private boolean editable;	
	@OneToMany(mappedBy = "producto")
	private Collection<Stock>listStock;	
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "proid")
	private Set<FacturaDetalle>facturaDetalle;	
	@ManyToOne
	private Categoria categoria;
	 
		public Producto() {
			
		}
		
		public Producto( String nombre, String descripcion, double preciounitario, double preciopublico, int stock,
				int cantidad) {
			super();
			
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.preciounitario = preciounitario;
			this.preciopublico = preciopublico;
			this.stock = stock;
			this.cantidad = cantidad;
		}


	public Producto( String nombre,String descripcion,Double preciounitario,
			Double preciopublico,Categoria categoria,int stock) {
		super();
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.preciounitario=preciounitario;
		this.preciopublico=preciopublico;
		this.categoria=categoria;
		this.stock=stock;		
	}

	//Creo un nuevo Constructor para el Serializa
	public Producto(int id,String nombre,String descripcion,Double preciounitario, 
			Double preciopublico,int stock) {
		this.id=id;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.preciounitario=preciounitario;
		this.preciopublico=preciopublico;
		this.stock=stock;
	}

	public Producto( String nombre,String descripcion,Double preciounitario, Double preciopublico,int stock) {
		super();
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.preciounitario=preciounitario;
		this.preciopublico=preciopublico;
		this.stock=stock;

	}
	
	
	
	
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

	public String getDescripcion() {
		return descripcion;
	}

	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPreciounitario() {
		return preciounitario;
	}

	public void setPreciounitario(Double preciounitario) {
		this.preciounitario = preciounitario;
	}

	public Double getPreciopublico() {
		return preciopublico;
	}

	public void setPreciopublico(Double preciopublico) {
		this.preciopublico = preciopublico;
	}
	
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setPreciounitario(double preciounitario) {
		this.preciounitario = preciounitario;
	}

	public void setPreciopublico(double preciopublico) {
		this.preciopublico = preciopublico;
	}

	public boolean isEditable() {
		return editable;
	}
	
	public void setEditable(boolean editable) {
		this.editable = editable;
	}	
	
	
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

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
		Producto other = (Producto) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	private static Producto producto;
	public static List<Producto> serializeProducto(List<Producto> productos) {
		List<Producto> productoList = new ArrayList<>();
		
		productos.forEach(
				e->{
					Categoria categoria = new Categoria(e.getId(),e.getNombre());
					
					producto = new Producto(e.getNombre(), e.getDescripcion(), e.getPreciounitario(), e.getPreciopublico(), categoria, e.getStock());
					productoList.add(producto);
				}
		);
		
		return productoList;
	}

	
	public Collection<Stock> getListStock() {
		return listStock;
	}

	public void setListStock(Collection<Stock> listStock) {
		this.listStock = listStock;
	}

	public Set<FacturaDetalle> getFacturaDetalle() {
		return facturaDetalle;
	}

	public void setFacturaDetalle(Set<FacturaDetalle> facturaDetalle) {
		this.facturaDetalle = facturaDetalle;
	}

	@Override
	public String toString() {
		return " Nombre=" + nombre + ", descripcion=" + descripcion + ", preciounitario="
				+ preciounitario + ", preciopublico=" + preciopublico + ", categoria="
				+ categoria+ ", stock="	+ stock ;
	}

}
