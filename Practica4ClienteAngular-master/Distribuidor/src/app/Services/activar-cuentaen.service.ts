import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Usuario } from '../Modelo/persona';

@Injectable({
  providedIn: 'root'
})
export class ActivarCuentaenService {
  private url: string;
  constructor(private http:HttpClient) {
    this.url='/Distribuidor/rest/prueba/activar';
   }

   activar(usuario:Usuario){

    console.log(usuario);

    const body = new HttpParams()
    .set('correo',usuario.correo)

    return this.http.post(
      this.url,
      body.toString(),
      {
        headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded'),
        responseType: 'text'
      }
    );
    //return this.http.post<Usuario>(this.url,usuario);

  }

}
