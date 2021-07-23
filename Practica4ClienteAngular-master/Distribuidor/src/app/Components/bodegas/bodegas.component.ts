import { Component, OnInit,Input } from '@angular/core';
import { BodegasService } from '../../Services/bodegas.service';
import { Bodega } from '../../Modelo/Bodegas';
import { ActivatedRoute } from '@angular/router';
import {Router} from '@angular/router';
@Component({
  selector: 'app-bodegas',
  templateUrl: './bodegas.component.html',
  styleUrls: ['./bodegas.component.css'],
  providers:[BodegasService],
})
export class BodegasComponent implements OnInit {

  public bodegas: any=[]
  public bode:Bodega;
  public correoP:string;


  constructor(private BodService: BodegasService,private router:Router,private actRoute:ActivatedRoute) {
  this.correoP=actRoute.snapshot.params.correop;
   }

  ngOnInit(): void {
    this.BodService.getBodegas()
    .subscribe( (data) =>{
      this.bodegas=data;
      console.log(data) ;
    }, (error) =>{
      console.log(error)
    }
    );


  }
  mensaje(){
    console.log('FUNCIONA')
    this.router.navigate(['CarritoCompras/',this.correoP])
  }
}
