import { Component, OnInit } from '@angular/core';
import { ITS_JUST_ANGULAR } from '@angular/core/src/r3_symbols';
import { element } from 'protractor';
import { JsonPipe } from '@angular/common';
import { Producto } from '../../Modelo/Producto';
import { ProductosService } from '../../Services/productos.service';
import { ActivatedRoute } from '@angular/router';
import {Router} from '@angular/router';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})
export class CarritoComponent implements OnInit {
  public CarritoProductos: any=[];
  public index: any;
  public total: any;

  public total2:any=[];
  public totalF:number=0;
  public totalIva :number=0;
  public Arreglo: any=[];
  public correoP: string;
  public subtotal: number=0;

  constructor(private proService: ProductosService,private actRoute:ActivatedRoute,public router: Router) {this.cargarProductos(),this.calcular() 
    this.correoP=actRoute.snapshot.params.correop;
  
  
  
  
  }
  

  ngOnInit(): void {
  }

  cargarProductos(){
    this.CarritoProductos=JSON.parse(localStorage.getItem('ListProducts'));
    console.log("LISTA DE COMPRAS",this.CarritoProductos)
  }


  calcular(){

    console.log('recupero y calculo',this.CarritoProductos)
    //Creacion de foreach
    let cantidades: string;
    let precio: string;
    for(let productos of this.CarritoProductos){
      cantidades=(productos.cantidad)
      precio=(productos.pun)
      console.log(cantidades)
      console.log(precio) 

      var total: number;
      total=parseFloat (precio)*parseFloat(cantidades);
      console.log('Resultado de la suma es de',total) 
      this.total2.push(total)
    }
    console.log('total2------------->',this.total2)
    for(let totales of this.total2){
      console.log(totales)
      this.subtotal=this.subtotal+totales;
      this.totalIva=(this.subtotal*12/100);
    }
    //this.subtotal=this.totalF;
    this.totalF=this.subtotal+this.totalIva
    console.log('valor a pagar con iva',this.totalIva)
    console.log('Valor total a pagar',this.totalF)
    console.log('SUBTOTAL A PAGAR:',this.subtotal)
  }


  eliminaritem(nombre: number){
    console.log(nombre)
    //Permite eliminar y actualizar la lista
    var indice=this.CarritoProductos.indexOf(0);
    this.CarritoProductos.splice(nombre,1)
    console.log("Areglo eliminao un producto",this.CarritoProductos)
    localStorage.setItem('ListProducts',JSON.stringify(this.CarritoProductos))
    this.Arreglo=localStorage.getItem('ListProducts')
    console.log("Seteado en un local storange",this.Arreglo)
    window.location.reload()
  }

  facturar(){
    this.facturarTotal()

    this.Arreglo=JSON.parse(localStorage.getItem('ListProducts'));

    console.log(this.Arreglo)

    this.proService.AddProductosCarito2(this.Arreglo)
  .subscribe( (data) =>{
    //this.pro=data;
    console.log(data) ;
    localStorage.removeItem('ListProducts');
    
  }, (error) =>{
    console.log(error)
  }
  );
    console.log('Se procede a persistir en la BD',this.Arreglo)
  }

  facturarTotal(){
    console.log(this.correoP)

    console.log('Se pasa el totoal y la fecha',this.totalF)
    let Totalfactura: string;
    let SubtotalFactura :string;
    Totalfactura=this.totalF.toString();
    SubtotalFactura=this.subtotal.toString();
    this.proService.facturarTotal(Totalfactura,this.correoP,SubtotalFactura)
    .subscribe( (data) =>{
      //this.pro=data;
      console.log(data) ;
      
    }, (error) =>{
      console.log(error)
    }
    );
    this.router.navigate(['/Bodegas/',this.correoP])
  }
}
