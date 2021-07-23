import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Usuario } from '../Modelo/persona';


@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  private url: string;
 
  
  constructor(private http:HttpClient) { 
    this.url='/Distribuidor/rest/prueba/personas';
    
  }
  

  
  createUsuario(usuario:Usuario){

    console.log(usuario);

    const body = new HttpParams()
    .set('nombres', usuario.nombres)
    .set('apellidos', usuario.apellidos)
    .set('telefono', usuario.telefono)
    .set('cedula',usuario.cedula)
    .set('correo',usuario.correo)
    .set('contrasena',usuario.contrasena);

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
