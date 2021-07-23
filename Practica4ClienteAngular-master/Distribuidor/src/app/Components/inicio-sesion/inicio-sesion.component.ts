import { Component, OnInit,Input } from '@angular/core';
import {Router} from '@angular/router';
import {Usuario} from 'src/app/Modelo/persona';
import { IniciosesionService } from '../../Services/iniciosesion.service';


@Component({
  selector: 'app-inicio-sesion',
  templateUrl: './inicio-sesion.component.html',
  styleUrls: ['./inicio-sesion.component.css']
})
export class InicioSesionComponent implements OnInit {
  usuario :Usuario
  

  @Input() InicioDetails = {
    correo:'', contrasena:''
  }

  constructor(
    public dataService: IniciosesionService,
    public router: Router,
  ) { 
    
  }

  ngOnInit(): void {

  }
  

  addInicio(dataBill) {
    this.dataService.iniciar(this.InicioDetails).subscribe((data: {}) => {
      console.log('data')
      let correop=data
      console.log('Estamos en el ADDINICIOSESION')
      console.log(correop)
      if(correop =='No creado'){
        return this.router.navigate(['/InicioSesion'])
      }else{
        return this.router.navigate(['/home/',correop])
      }
      
    })
  }



}
