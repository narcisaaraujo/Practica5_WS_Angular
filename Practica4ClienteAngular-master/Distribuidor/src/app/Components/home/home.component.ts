import { Component, OnInit } from '@angular/core';
import { IniciosesionService } from '../../Services/iniciosesion.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

//import {Router} from '@angular/router';






@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public correop:any
  public coo:any
  constructor(public dataService: IniciosesionService,private actRoute:ActivatedRoute,  public router: Router) { 
  this.correop =actRoute.snapshot.params.correop;
  }


  //constructor(private router:Router) { }


  ngOnInit(): void {
   
  }


  eliminar(){
   
   console.log(this.correop)
   this.dataService.eliminacion(this.correop).subscribe((data)  => {
    this.redi()
  })
}

redi(){
    //console.log('redi')
    this.router.navigate(['/InicioSesion'])
}

  mensaje(){
    console.log('FUNCIONA')
    this.router.navigate(['CarritoCompras/',this.correop])
  }

  Mensaje2(){
    console.log('FUNCIONA')
    this.router.navigate(['Pedidos/',this.correop])
  }
  actualizar(){
    console.log(this.correop)
    this.router.navigate(['/Modificar',this.correop])
  }


}
