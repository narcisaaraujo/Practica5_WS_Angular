import { Component, OnInit,Input} from '@angular/core';
import {Router} from '@angular/router';
import {Usuario} from 'src/app/Modelo/persona';
import { ActivarCuentaenService } from '../../Services/activar-cuentaen.service';

@Component({
  selector: 'app-activar-cuenta',
  templateUrl: './activar-cuenta.component.html',
  styleUrls: ['./activar-cuenta.component.css']
})
export class ActivarCuentaComponent implements OnInit {
  usuario :Usuario

  @Input() InicioDetails = {
    correo:'',
  }
  
  constructor(
    public dataService: ActivarCuentaenService,
    public router: Router,
  ) { }

  ngOnInit(): void {
  }

  activar(dataBill) {
    this.dataService.activar(this.InicioDetails).subscribe((data: {}) => {
    })
  }

}
