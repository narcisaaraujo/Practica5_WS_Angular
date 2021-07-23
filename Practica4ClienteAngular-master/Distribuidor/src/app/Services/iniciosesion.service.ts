import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Usuario } from '../Modelo/persona';

@Injectable({
  providedIn: 'root'
})
export class IniciosesionService {
  private url: string;
  private url1: string;
  private url2:string 
  constructor(private http:HttpClient) {
    this.url='/Distribuidor/rest/prueba/inicio';
    this.url1='/Distribuidor/rest/prueba/eliminar/';
    this.url2='/Distribuidor/rest/prueba/actualizar/';
  }

  
  iniciar(usuario:Usuario){

    console.log(usuario);

    const body = new HttpParams()
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
    //hecho
  }

  eliminacion(correop:any){
    
    return this.http.post(
      this.url1+correop,
      {
        headers: new HttpHeaders().set('Content-Type', 'application/json'),
        responseType: 'text'
      }
    );
  }

  createUsuario(correop:string,usuario:Usuario){

    console.log(usuario);

    const body = new HttpParams()
    .set('nombres', usuario.nombres)
    .set('apellidos', usuario.apellidos)
    .set('telefono', usuario.telefono)
    .set('correo',usuario.correo)
    .set('contrasena',usuario.contrasena);

    return this.http.post(
      this.url2+correop,
      body.toString(),
      {
        headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded'),
        responseType: 'text'
      }
    );
    //return this.http.post<Usuario>(this.url,usuario);

  }

  
  



  
}
