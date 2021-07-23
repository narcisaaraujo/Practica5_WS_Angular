import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { PedidosService } from '../../Services/pedidos.service';
import { error } from '@angular/compiler/src/util';


@Component({
  selector: 'app-pedidos',
  templateUrl: './pedidos.component.html',
  styleUrls: ['./pedidos.component.css']
})
export class PedidosComponent implements OnInit {
  public correoP:string;
  public Pedidos: any=[];
  public size:number;

  constructor(private actRoute:ActivatedRoute,  public router: Router,private pedidoServicio: PedidosService) { 
    this.correoP =actRoute.snapshot.params.correop;


  }

  ngOnInit(): void {
    this.pedidoServicio.getPedidos(this.correoP)
    .subscribe( (data) =>{
      console.log('ESTE ES EL CORREO',this.correoP)
      this.Pedidos=data;
      console.log(data) ;
    }, (error) =>{
      console.log(error)
    }
    );
  }

  Contador(){
    for(let i=0; i<this.Pedidos.length; i++){
      this.size=this.size+i
    }
  }

  Mensaje2(){
    console.log('FUNCIONA')
    this.router.navigate(['Pedidos/',this.correoP])
  }

}
