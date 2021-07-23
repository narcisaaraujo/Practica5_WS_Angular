import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Producto } from '../Modelo/Producto';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {
  private url : string;
  private urlProductos: string;
  private urlfacturarTotal: string;
  private cantidad:number;





  constructor(private http: HttpClient) { 
  this.url = '/Distribuidor/rest/prueba/ProductosByBodegaCategorias/'
  this.urlProductos='/Distribuidor/rest/prueba/AgregarProductosLista/'
  this.urlfacturarTotal='/Distribuidor/rest/prueba/facturarTotal/'
  }
  /*
  getProductos(){
    return this.http.get('http://localhost:8080/Distribuidor/rest/prueba/ListaProductos');
    //http://localhost:8080/Distribuidor/rest/prueba/Categorias
    //http://localhost:8080/Distribuidor/rest/prueba/ListaProductos
  }*/

  getBodegaNombreCategoria(nombre:string, categoria:string){

    console.log(nombre)
    console.log(categoria)

    return this.http.post(this.url+nombre+'/'+categoria,
      {
       headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded'),
       responseType: 'text'
     }
   );
  }
  //Metodo agregar producto a la factura
  AddProductosCarito(producto:Producto,cantidad){
    console.log('llega informacion al servicio')
    //console.log('CAntidad--->',cantidad)
    //console.log(nombre)
    const body = new HttpParams()
    .set('nombre',producto.nombre1)
    .set('descripcion',producto.descripcion)
    .set('preciopublico',producto.ppu)
    .set('stock',producto.stock)
    

    console.log(producto)
    return this.http.post(
      this.urlProductos,body.toString(),{
        headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded'),
        responseType: 'text'
      }
    )
  }
  AddProductosCarito2(listaproductos:any){
    console.log('Estoy n el pinche servcio',listaproductos)
    console.log('llega informacion al servicio')
    console.log('Lista de productos',listaproductos)
    //console.log('CAntidad--->',cantidad)
    //console.log(nombre)
    //let productosObtenidos: any=[];
    //productosObtenidos =(localStorage.getItem('ListProducts'));
    //console.log('llave productosObtenidos',productosObtenidos)

    //const body = new HttpParams()
    
    //.set('nombre',productosObtenidos[0].nombre)
    //.set('descripcion',productosObtenidos[0].descripcion)
    //.set('preciopublico',productosObtenidos[0].preciopublico)
    //.set('stock',productosObtenidos[0].stock)
    

    //console.log(producto)
    return this.http.post(
      this.urlProductos,listaproductos,{
        headers: new HttpHeaders().set('Content-Type', 'application/json'),
        responseType: 'text'
      }
    )
  }

  facturarTotal(TotalF:string,correoP: string,subtotal:string){
    console.log('total final en angular',TotalF)
    return this.http.post(
      this.urlfacturarTotal+TotalF+"/"+correoP+"/"+subtotal,{
        headers: new HttpHeaders().set('Content-Type', 'application/json'),
        responseType: 'text'
      }
    )
  }
}
