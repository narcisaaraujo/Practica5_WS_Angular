package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Producto;

public class Roww implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre1;
	private String descripcion;
	private double pun;
	private double ppu;
	private int stock;
	private int cantidad;
	private double subtotal;
	
	
	public Roww() {
		super();
	}


	public Roww(String nombre1, String descripcion, double pun, double ppu, int stock) {
		
		this.nombre1 = nombre1;
		this.descripcion = descripcion;
		this.pun = pun;
		this.ppu = ppu;
		this.stock = stock;
	}
	
	
	public Roww(String nombre1, String descripcion, double pun, double ppu, int stock, int cantidad) {
		super();
		this.nombre1 = nombre1;
		this.descripcion = descripcion;
		this.pun = pun;
		this.ppu = ppu;
		this.stock = stock;
		this.cantidad=cantidad;
	}
	
	
	
	
	public Roww(String nombre1, String descripcion, double pun, double ppu, int stock, int cantidad, double subtotal) {
		super();
		this.nombre1 = nombre1;
		this.descripcion = descripcion;
		this.pun = pun;
		this.ppu = ppu;
		this.stock = stock;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}


	public String getNombre1() {
		return nombre1;
	}


	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPun() {
		return pun;
	}


	public void setPun(double pun) {
		this.pun = pun;
	}


	public double getPpu() {
		return ppu;
	}


	public void setPpu(double ppu) {
		this.ppu = ppu;
	}

	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	private static Roww row;
	public static List<Roww> serializeRoww(List<Roww> rows) {
		List<Roww> rowList = new ArrayList<>();
		
		rows.forEach(
				e->{
					
					row = new Roww(e.getNombre1(),e.getDescripcion(),e.getPun(),e.getPpu(),e.getStock(),e.getCantidad());
					rowList.add(row);
				}
		);
		
		return rowList;
	}


	@Override
	public String toString() {
		return "Roww [nombre1=" + nombre1 + ", descripcion=" + descripcion + ", pun=" + pun + ", ppu=" + ppu
				+ ", stock=" + stock + ", cantidad=" + cantidad + ", subtotal=" + subtotal + "]";
	}

}
