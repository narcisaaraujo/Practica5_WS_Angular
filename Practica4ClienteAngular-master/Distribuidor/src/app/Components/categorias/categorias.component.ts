import {  Component, OnInit,Input} from '@angular/core';
import { CategoriasService } from '../../Services/categorias.service';
import { ActivatedRoute } from '@angular/router';
import { BodegasService } from '../../Services/bodegas.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css']
})
export class CategoriasComponent implements OnInit {
  @Input() bodeg= {
    nombre: ''
  }
 public nombre:string;
 public correop: string;

  public categorias: any=[];
  public productos: any=[];
  
  constructor(private CatServise: CategoriasService,private actRoute:ActivatedRoute,private BodService: BodegasService,private router:Router) {
   //this.produc();
   this.nombre=actRoute.snapshot.params.nombre;
   this.correop=actRoute.snapshot.params.correop;
   console.log(this.nombre)
   }

  ngOnInit(): void {
    this.CatServise.getCategorias()
    .subscribe( (data) =>{
      this.categorias=data;
      console.log(data) ;
    }, (error) =>{
      console.log(error)
    }
    );
  }
  mensaje(){
    console.log('FUNCIONA')
    this.router.navigate(['CarritoCompras/',this.correop])
  }

 /* produc(){
    this.nombre=this.actRoute.snapshot.params.nombre;   
    console.log(this.nombre)
    this.BodService.getBodegaNombre(this.nombre).subscribe(data=>{
      console.log("Consume")
      this.productos=data;
      console.log(this.productos)

    });
  }*/

}
