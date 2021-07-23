package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Stock
 *
 */
@Entity

public class Stock implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn
	private Bodega bodega;
	@ManyToOne
	@JoinColumn
	private Producto producto;
	public Stock() {
		
	}
	
	
	
	public Stock(Bodega bodega, Producto producto) {
		super();
		this.bodega = bodega;
		this.producto = producto;
	}



	public Stock(int id,Producto producto,Bodega bodega) {
		this.id=id;
		this.producto=producto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	private static Stock stock;
	private static Producto producto2;
	private static Bodega bodega2;
	
	private static List<Producto> productoList = new ArrayList<>();
	public static List<Stock> serializeStock(List<Stock> stocks) {
		List<Stock> stockList = new ArrayList<>();
		/*
		productoList.forEach(
				p->{
					producto2 = new Producto(p.getId(),p.getNombre(),p.getDescripcion(),p.getPreciounitario(),p.getPreciopublico(),p.getStock());
				}
				);
				**/
		
		stocks.forEach(
				s->{
					
					producto2 = new Producto(s.getProducto().getId(),s.getProducto().getNombre(),s.getProducto().getDescripcion(),s.getProducto().getPreciounitario(),s.getProducto().getPreciopublico(),s.getProducto().getStock());
					bodega2 = new Bodega(s.getBodega().getNombre(),s.getBodega().getCiudad());
					
					
					System.out.println("Productos recuperados----"+producto2);
					stock=new Stock(s.getId(),producto2,bodega2);	
					stockList.add(stock);
				}
				);
		
		return stockList;
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Stock [id=" + id + ", bodega=" + bodega + ", producto=" + producto + "]";
	}

	
   
}
