package ec.edu.ups.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.PreUpdate;
import javax.ws.rs.Consumes;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.api.Param;

import com.sun.rowset.internal.Row;

import ec.edu.ups.controlador.Roww;
import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.PedidoCabeceraFacade;
import ec.edu.ups.ejb.PedidosDetallesFacade;
import ec.edu.ups.ejb.ProductoFacade;

import ec.edu.ups.ejb.UsuarioFacade;

import ec.edu.ups.ejb.StockFacade;
import ec.edu.ups.modelo.Bodega;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.PedidoDetalle;
import ec.edu.ups.modelo.PedidosCabecera;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Stock;
import ec.edu.ups.modelo.Usuario;




import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  

@Path("/prueba")
public class ApiREST {
	private Usuario usuario;
	private Usuario usu;
	List<Roww> listRow = new ArrayList<Roww>();
	private List<Roww> list;
	private PedidosCabecera pedidoCabecera;
	private static double total;
	private static String correo;
	private static String cedula;
	private static double subtotal;
	
	@EJB
	private ProductoFacade ejbProductoFacade;
	@EJB private CategoriaFacade ejbCategoriaFacade;

	@EJB private UsuarioFacade ejbUsuarioFacade;

	@EJB private BodegaFacade ejbBodegaFacade;
	@EJB private StockFacade ejbStockFacade;
	@EJB private PedidoCabeceraFacade ejbPedidoCabeceraFacade;
	@EJB private PedidosDetallesFacade ejbPedidosDetallesFacade;
	
	
	
	public ApiREST() {
		this.list= new ArrayList<>();
		this.pedidoCabecera= new PedidosCabecera();
	}
	
	
	//Variables
	List<Producto> lisProducto = new ArrayList<Producto>();
	



	
    @GET
    @Path("/ListaProductos/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listProductos() {
    	List<Producto> list = new ArrayList<Producto>();
    	Jsonb jsonb = JsonbBuilder.create();
    	//list=ejbProductoFacade.findAll();
    	list = Producto.serializeProducto(ejbProductoFacade.findAll());
		return Response.ok(jsonb.toJson(list))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    	
    }
    //Metod Funcionando
    
    @GET
    @Path("/Categorias/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listCategorias() {
    	List<Categoria> list = new ArrayList<Categoria>();
    	Jsonb jsonb = JsonbBuilder.create();
    	
    	list=Categoria.serializeCategoria(ejbCategoriaFacade.findAll());
		return Response.ok(jsonb.toJson(list))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }
    
    @GET
    @Path("/Bodegas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listBodegas() {
    	List<Bodega> list = new ArrayList<Bodega>();
    	Jsonb jsonb = JsonbBuilder.create();
    	
    	list=Bodega.serializeBodega(ejbBodegaFacade.findAll());
		return Response.ok(jsonb.toJson(list))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }
    

    @Path("/ProductosByBodega/{nombreB}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listProductosBodega(@PathParam("nombreB") String nombreB) {
    	Jsonb jsonb = JsonbBuilder.create();
    	
    	Bodega bo= new Bodega();
		bo=Bodega.serializeBodega2(ejbBodegaFacade.nombreBodega(nombreB));
		
		System.out.println(ejbStockFacade.listaInventario(bo));
		List<Stock> lisStocks = new ArrayList<Stock>();
		//lisStocks=ejbStockFacade.listaInventario(bo);
		lisStocks=Stock.serializeStock(ejbStockFacade.listaInventario(bo));
    	
    	
		return Response.ok(jsonb.toJson(lisStocks))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }
    
    @POST
    //@Path("/personas")
    //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/bode/{nombre}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response bode(@PathParam("nombre")String nombre) {
    	//Jsonb jsonb = JsonbBuilder.create();    	
    	System.out.println("Aquiiiiiiiiiiiiiiiiiiiiii");      	
    	System.out.println(nombre);
    	return Response.ok("aquiiiiiiiiii"+nombre)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    	
    	
    }
    
    
    @POST
    @Path("/personas")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(@FormParam("nombres") String nombre,@FormParam("apellidos") String apellidos,@FormParam("telefono") String telefono,
    		@FormParam("cedula") int ced,@FormParam("correo") String correo,@FormParam("contrasena") String contrasena)
          throws IOException{
    	System.out.println("Metodo crear");

    	System.out.println("Nombre " + nombre);
    	System.out.println("Apellido " + apellidos);
    	System.out.println("Telefono " + telefono);
    	System.out.println("Cedula " + ced);
    	System.out.println("Correo " + correo);
    	System.out.println("Contrasena " + contrasena);
    	
    	Usuario usu4=new Usuario();
    	Usuario usu3=new Usuario();
    	usu3.setEstado("A");
    	Rol rol3=new Rol();
	    rol3.setNombre("cliente");

    	usu=new Usuario(ced,nombre,apellidos,telefono,correo,contrasena,rol3,usu3.getEstado());
    	System.out.println("Usuario tipo Usuario-------------------->"+usu.toString());
    	ejbUsuarioFacade.create(usu);

    	return Response.ok("Creado")
    			.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }




    @POST
    @Path("/inicio")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response inicio(@FormParam("correo") String correo,@FormParam("contrasena") String contrasena)
          throws IOException{
    	System.out.println("Metodo crear");
        Usuario us=new Usuario();
    	System.out.println("Correo " + correo);
    	System.out.println("Contrasena " + contrasena);
    	
    	Usuario usu=new Usuario();
    	usu.setCorreo(correo);
    	String correoo=usu.getCorreo();
    	
    	usu.setContraseña(contrasena);
    	String contrasenaa=usu.getContraseña();
    	
    	try {
    	us = ejbUsuarioFacade.inicioo(correoo, contrasenaa);
        if(us !=null) 
        {
    	return Response.ok(correo)
        
    			.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
        }
    	}catch(Exception ex) {
        return Response.ok("No creado").build();
        
    	}
    	 return Response.ok("No creado").build();
    }

    
    @POST
    @Path("/ProductosByBodegaCategorias/{nombreB}/{nombreC}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listProductosBodegaCategorias(@PathParam("nombreB") String nombreB,@PathParam("nombreC")String nombreC) {
    	Jsonb jsonb = JsonbBuilder.create();
    	
    	System.out.println(nombreB);
    	System.out.println(nombreC);
    	
    	
    	//Bodega bo= new Bodega();
		
		System.out.println(ejbStockFacade.bodegasCategorias_Productos(nombreB, nombreC));
		List<Stock> lisStocks = new ArrayList<Stock>();
		//lisStocks=ejbStockFacade.listaInventario(bo);
		lisStocks=Stock.serializeStock(ejbStockFacade.bodegasCategorias_Productos(nombreB, nombreC));
		System.out.println(lisStocks);
		
    	
    	
		return Response.ok(jsonb.toJson(lisStocks))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();

    }
    /*
    @POST
    @Path("/AgregarProductosLista")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ListaProductos(@PathParam("nombre")String nombre,@PathParam("descripcion")String descripcion,
    		@PathParam("preciopublico")String preciopublico, @PathParam("stock")String stock, @PathParam("cantidad")String cantidad
    		,@PathParam("preciounitario")String preciounitario) {
    	
    	System.out.println("NombreProducto-->"+nombre);
    	System.out.println("DescripcionProducto-->"+descripcion);
    	System.out.println("PrecioProducto-->"+preciopublico);
    	System.out.println("StockProducto-->"+stock);
    	System.out.println("CantidadProducto-->"+cantidad);
    	
    	
    	double precioP= Double.parseDouble(preciopublico);
    	double precioU=Double.parseDouble(preciounitario);
    	int stockP = Integer.valueOf(stock);
    	int Cantidad = Integer.valueOf(cantidad);
    	
    	System.out.println("Lleegooo");
    	this.listRow.add(new Roww(nombre,descripcion,precioP,precioU,stockP,Cantidad));
    	System.out.println(listRow);
    	
    	
		return null;
    	
    }*/
    
    @POST
    @Path("/facturarTotal/{TotalF}/{correoP}/{subtotalF}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response Pasartotal(@PathParam("TotalF")String TotalF,@PathParam("correoP")String correoP,@PathParam("subtotalF")String subtotalF) {
    	System.out.println("Correo para insertar el pedido---------->"+correoP);
    	System.out.println("valorTotal--------------------------->"+TotalF);
    	System.out.println("SUBTOTAL A PAGAR------------------------>>>"+subtotalF);
    	total=Double.parseDouble(TotalF);
    	this.correo=correoP;
    	subtotal=Double.parseDouble(subtotalF);
    	
    	
    	return Response.ok("Total")
    			.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    	
    }
    
    
    
    
    
    
    
    @POST
    @Path("/AgregarProductosLista")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response ListaProductos(String jsonproducto) {
    	System.out.println("Obtenemos el total desde Agregar productos"+total);
    	System.out.println("Obtenemos el correo desde Agregar productos"+correo);
    	System.out.println("Obtenemos el subtotal dese agregar productos"+subtotal);
    	Jsonb jsonb = JsonbBuilder.create();
    	System.out.println("JSONPRODUCTO----------------->"+jsonproducto);
    	String EstadoPedido="Recibido";
    	
    	
    	
    	//Se obtiene la Fecha
    	 Date date = new Date(); 
    	
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
        String strDate = formatter.format(date);  
        System.out.println("Date Format with MM/dd/yyyy : "+strDate); 
            		
    	Persona usuario = ejbUsuarioFacade.buscarid(correo);
    	PedidosCabecera cabecera = new PedidosCabecera(strDate,total,EstadoPedido,usuario);
    	System.out.println(cabecera.toString());
    	ejbPedidoCabeceraFacade.create(cabecera);
    	
    	
    	
    	 list = jsonb.fromJson(jsonproducto, new ArrayList<Roww>() {}.getClass().getGenericSuperclass());
    	
    	for (Roww row : list) {
			Producto producto = ejbProductoFacade.nombreProducto(row.getNombre1());
			PedidoDetalle detalle = new PedidoDetalle(row.getCantidad(),subtotal,cabecera,producto);
			System.out.println(detalle);
			ejbPedidosDetallesFacade.create(detalle);
    		
    		System.out.println("Nombre--->" +row.getNombre1());
    		System.out.println("Descripcion--->" +row.getDescripcion());
    		System.out.println("Punitario--->" +row.getPun());
    		System.out.println("Ppublico--->" +row.getPpu());
    		System.out.println("Stock--->" +row.getStock());
    		System.out.println("Cantidad--->" +row.getCantidad());
		} 
			
		
    	System.out.println("La lista es :" +list);
    		
    //	System.out.println("Lleegooo");
    	//this.listRow.add(new Roww(nombre,descripcion,precioP,precioU,stockP,Cantidad));
    //	System.out.println(listRow);
    	
    	return Response.ok("Creado")
    			.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();	
    }
    
  
    @POST
    @Path("/eliminar/{correop}")
    @Consumes(MediaType.APPLICATION_JSON)
   // @Produces(MediaType.TEXT_PLAIN)
    public Response eliminar(@PathParam("correop") String correo)
          throws IOException{
    	System.out.println("Metodo crear");
    	System.out.println("Correo " + correo);
    	
    	Usuario us=new Usuario();
    	us =ejbUsuarioFacade.buscarid(correo);
    	System.out.println("idd--------------------------");
    	System.out.println(us.getId());
    	int id=us.getId();
    	System.out.println(id);
    	
    	System.out.println("Elimina");
    	ejbUsuarioFacade.elimina(id);
    	return Response.ok(true)
    			.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }
    
    @POST
    @Path("/eliminarfactura/{cedula}")
    @Consumes(MediaType.APPLICATION_JSON)
   // @Produces(MediaType.TEXT_PLAIN)
    public Response eliminarfactura(@PathParam("cedula") String cedula)
          throws IOException{
    	System.out.println("Metodo eliminar");
    	System.out.println("Correo " + cedula);
    	
    	Usuario us=new Usuario();
    	us =ejbUsuarioFacade.buscarid(correo);
    	System.out.println("idd--------------------------");
    	System.out.println(us.getId());
    	int id=us.getId();
    	System.out.println(id);
    	
    	System.out.println("Elimina");
    	ejbUsuarioFacade.elimina(id);
    	return Response.ok(true)
    			.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }
    
    //metodo activar cuenta
    @POST
    @Path("/activar")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response activar(@FormParam("correo") String correo)
          throws IOException{
    	System.out.println("Metodo crear");
        Usuario us=new Usuario();
    	System.out.println("Correo " + correo);
    	
    	
    	Usuario usu=new Usuario();
    	usu.setCorreo(correo);
    	String correoo=usu.getCorreo();
    	
    	
    	us =ejbUsuarioFacade.buscarid(correoo);
    	System.out.println("idd--------------------------");
    	System.out.println(us.getId());
    	int id=us.getId();
    	System.out.println(id);
    	
    	System.out.println("Elimina");
    	ejbUsuarioFacade.acti(id);
    	return Response.ok("Activado")
        
    			.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
       
    }
    

    @POST
    @Path("/actualizarr")
    //@Consumes(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   // @Produces(MediaType.TEXT_PLAIN)
    public Response actualizar(@FormParam("nombres") String nombre,@FormParam("apellidos") String apellidos,@FormParam("telefono") String telefono,
    		@FormParam("correo") String correo,@FormParam("contrasena") String contrasena)
          throws IOException{
    	
    	/*
    	Usuario usu=new Usuario();
    	usu.setCorreo(correoo);
    	String correoo1=usu.getCorreo();
    	
    	
    	Usuario usu1=new Usuario();
    	usu1 =ejbUsuarioFacade.buscarid(correoo1);
    	int idd=usu1.getId();
    	*/
    	
    	System.out.println("---nombres---"+nombre);
    	System.out.println("----apellidos---" +apellidos);
    	System.out.println("---telefono--"+telefono);
    	System.out.println("---correo--"+correo);
    	System.out.println("---contraseña--"+contrasena);
    	
    	/*
    	Usuario usu2=new Usuario();
        usu2.setId(idd);
        usu2.setNombre(nombre);
        usu2.setApellido(apellidos);
    	usu2.setTelefono(telefono);
    	usu2.setCedula(cedula);
    	usu2.setCorreo(correo);
    	usu2.setContraseña(contrasena);
    	usu2.setEstado("A");
    	
    	Rol rol3=new Rol();
	    rol3.setNombre("cliente");
	    
	    usu2.setRoles(rol3);
    	
    	ejbUsuarioFacade.edit(usu2);
    	*/
    	
    	return Response.ok(true)
    			.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }
    
    @POST
    @Path("/actualizar/{correop}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response actualiza(@PathParam("correop") String co2,@FormParam("nombres") String nombre,@FormParam("apellidos") String apellidos,@FormParam("telefono") String telefono,
    		@FormParam("correo") String correo,@FormParam("contrasena") String contrasena)
          throws IOException{
    	System.out.println("Metodo crear");

    	System.out.println("co id " + co2);
    	System.out.println("Nombre " + nombre);
    	System.out.println("Apellido " + apellidos);
    	System.out.println("Telefono " + telefono);
    	System.out.println("Correo " + correo);
    	System.out.println("Contrasena " + contrasena);
    	
    	Usuario usu=new Usuario();
    	usu.setCorreo(co2);
    	String correoo1=usu.getCorreo();
    	
    	
    	Usuario usu1=new Usuario();
    	usu1 =ejbUsuarioFacade.buscarid(correoo1);
    	int idd=usu1.getId();
    	
    	System.out.println(idd); 	
    	Usuario usu2=new Usuario();
        usu2.setId(idd);
        usu2.setNombre(nombre);
        usu2.setApellido(apellidos);
    	usu2.setTelefono(telefono);
    	usu2.setCorreo(correo);
    	usu2.setContraseña(contrasena);
    	usu2.setEstado("A");
    	
    	Rol rol3=new Rol();
	    rol3.setNombre("cliente");
	    
	    usu2.setRoles(rol3);
    	System.out.println(usu2);
    	ejbUsuarioFacade.edit(usu2);
      	System.out.println("pasoooo");

    	return Response.ok("Creado")
    			.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }

    
    @GET
    @Path("/ListarPedidos/{correoP}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ListarPedidos(@PathParam("correoP")String correoP)  throws IOException{
    	System.out.println("Correo en el metodo listar pedidos."+correoP);
    	
    	Jsonb jsonb = JsonbBuilder.create();
    	
    	System.out.println("THIS IS THE EMAIL"+correoP);
    	Usuario usuario = new Usuario();
    	usuario=ejbUsuarioFacade.buscarid(correoP);
    	System.out.println("Usuario Recolectado---------------------------->"+usuario);
    	//System.out.println(ejbPedidosDetallesFacade.pedidosDetalle(usuario));
    	
    	List<PedidoDetalle> ListarPedidos = new ArrayList<PedidoDetalle>();
    	
    	ListarPedidos=PedidoDetalle.serializePedidoDetalles(ejbPedidosDetallesFacade.pedidosDetalle(usuario));
		System.out.println("LISTA DE PEDIDOS-------------------------------->"+ListarPedidos);
		
    	return Response.ok(jsonb.toJson(ListarPedidos))
    			.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    	
    }
  

  }    