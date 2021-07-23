import { Component, OnInit } from '@angular/core';
import { ProductosService } from '../../Services/productos.service';
import { ActivatedRoute } from '@angular/router';
import {Router} from '@angular/router';
import { Producto } from '../../Modelo/Producto';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {

  public productos: any=[];
  public option: any;
  public item:any;
  public obj:any;
  public opcion:any;
  public nombre:string;
  public categoria:string;
  public produ: any=[];

  //Variables para la cnatidad de productos
  public cantidad:string;
  public productosFactura: any=[];

  public ObjProductos: any=[];
  public correoP: string;
  
  constructor(private proService: ProductosService,private actRoute:ActivatedRoute, private router:Router ) { 
   // this.nombre=actRoute.snapshot.params.nombre;
   // this.categoria=actRoute.snapshot.params.categoria;
   this.correoP=actRoute.snapshot.params.correop;
    this.produc();
    console.log(this.nombre);
    console.log(this.categoria);
  }

  ngOnInit(): void {
    /*
    this.proService.getProductos()
    .subscribe( (data) =>{
      this.productos=data;
      console.log(data) ;
    }, (error) =>{
      console.log(error)
    }
    );*/
  }
 

  produc(){
    this.nombre=this.actRoute.snapshot.params.nombre; 
    this.categoria=this.actRoute.snapshot.params.categoria;  
    console.log(this.nombre)
    console.log(this.categoria)
    this.proService.getBodegaNombreCategoria(this.nombre,this.categoria)
    .subscribe((data)=>{
      console.log(data)
      this.productos=data;
      console.log('Hola putitos')
      console.log(this.productos)

    });
}
addProductos(nombre,descripcion,preciopublico,preciounitario,stock,cantidad){
  console.log('Producto---->: ' ,nombre)
  console.log('Descripcion---->: ' ,descripcion)
  console.log('preciopublico--->',preciopublico)
  console.log('preciounitario--->',preciounitario)
  console.log('Cantidad----->',cantidad)
  console.log('Stock----->',stock);

 //let  producto= new Producto()
 let producto=<Producto>{};
 producto.nombre1=nombre;
 producto.descripcion=descripcion;
 producto.ppu=preciopublico;
 producto.pun=preciounitario;
 producto.cantidad=cantidad;
 producto.stock=stock;


 this.productosFactura=(producto)


 console.log('OBJETO PRODUCTO--->',producto)
 console.log("lista de PRODUCTOS-----***>",this.productosFactura)


 this.proService.AddProductosCarito(producto,cantidad)
 .subscribe( (data) =>{
  //this.pro=data;
  console.log(data) ;
}, (error) =>{
  console.log(error)
}
);
}

addProductoLocalStorange(nombre,descripcion,preciopublico,preciounitario,stock,cantidad){
  console.log('Producto---->: ' ,nombre)
  console.log('Descripcion---->: ' ,descripcion)
  console.log('preciopublico--->',preciopublico)
  console.log('preciounitario--->',preciounitario)
  console.log('Stock----->',stock);

 //let  producto= new Producto()
 let producto=<Producto>{};
 producto.nombre1=nombre;
 producto.descripcion=descripcion;
 producto.ppu=preciopublico;
 producto.pun=preciounitario;
 producto.cantidad=cantidad;
 producto.stock=stock;
 

 if(localStorage.getItem('ListProducts')){
   
  this.ObjProductos=JSON.parse(localStorage.getItem('ListProducts'));

  this.ObjProductos=[producto,...this.ObjProductos];
 }else{
  this.ObjProductos=[producto];
 }
 localStorage.setItem('ListProducts', JSON.stringify(this.ObjProductos));

 this.produ =localStorage.getItem('ListProducts');

 //JSON.stringify(produ)

 console.log('Producto obtenido',this.produ)
 console.log('Objeto Productos', this.ObjProductos)
console.log('---Productos agregados a la lista---', this.ObjProductos)

}
mensaje(){
  console.log('FUNCIONA')
  this.router.navigate(['CarritoCompras/',this.correoP])
}
/*
factura(){

  this.proService.AddProductosCarito2(this.ObjProductos)
  .subscribe( (data) =>{
    //this.pro=data;
   console.log('producto tipo JSON Factura', this.produ)
    console.log(data) ;
  }, (error) =>{
    console.log(error)
  }
  );
  */
 
}

