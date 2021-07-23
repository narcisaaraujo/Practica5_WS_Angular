import { Component, OnInit ,Input} from '@angular/core';
import { IniciosesionService } from '../../Services/iniciosesion.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Usuario } from '../../Modelo/persona';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-modificar',
  templateUrl: './modificar.component.html',
  styleUrls: ['./modificar.component.css']
})
export class ModificarComponent implements OnInit {
  public correop:any
  usuario:Usuario
  user:FormGroup
  @Input() ActualizarDetails = {
    nombres:'',apellidos:'',telefono:'',correo:'', contrasena:''
  }

  constructor(public dataService: IniciosesionService,private actRoute:ActivatedRoute,  public router: Router) {
    this.correop =actRoute.snapshot.params.correop;
   }

  ngOnInit(): void {
    this.user = new FormGroup({
      nombres: new FormControl('', Validators.required),
      apellidos:new FormControl('', Validators.required),
      telefono:new FormControl('', Validators.required),
      correo:new FormControl('', Validators.required),
      contrasena:new FormControl('', Validators.required)

  });
  }


  actualiza(dataBill){
   console.log(this.correop)
   this.dataService.createUsuario(this.correop,this.ActualizarDetails).subscribe((data)  => {
    this.router.navigate(['/InicioSesion'])
  })
}

atras(){
  this.router.navigate(['/home/',this.correop])
}

}
