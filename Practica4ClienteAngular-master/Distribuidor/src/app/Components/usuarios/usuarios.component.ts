import { Component, OnInit,Input } from '@angular/core';
import { PersonaService } from '../../Services/persona.service';
import {Router} from '@angular/router';
import {Usuario} from 'src/app/Modelo/persona';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {
  usuario :Usuario
  user:FormGroup
  @Input() UsuarioDetails = {
    nombres: '', apellidos: '', telefono: '', cedula: '',
    correo:'', contrasena:''
  }

  constructor(
    public dataService: PersonaService,
    public router: Router,
  ) { 

   
  }

    
  ngOnInit(): void {
    this.user = new FormGroup({
        nombres: new FormControl('', Validators.required),
        apellidos:new FormControl('', Validators.required),
        telefono:new FormControl('', Validators.required),
        cedula:new FormControl('', Validators.required),
        correo:new FormControl('', Validators.required),
        contrasena:new FormControl('', Validators.required)

    });
  }
  //Meotodo para agregar Usuarios.


  add(dataBill) {
    this.dataService.createUsuario(this.UsuarioDetails).subscribe((data: {}) => {
      this.router.navigate(['/InicioSesion'])
    })
  }

 

}
