import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams  } from '@angular/common/http';
import { BodegasComponent } from '../Components/bodegas/bodegas.component';
import { Bodega } from '../Modelo/Bodegas';

@Injectable({
  providedIn: 'root'
})
export class BodegasService {
  private url: string;
  constructor(private http: HttpClient) { 
    this.url='/Distribuidor/rest/prueba/ProductosByBodega/';
  }
  getBodegas(){
    return this.http.get("/Distribuidor/rest/prueba/Bodegas");
  }
  getBodegaNombre(nombre:string){
   // const body=new HttpParams()
     // .set('nombre',bode.nombre);
     console.log(nombre)
     return this.http.post(this.url+nombre,
     {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded'),
      responseType: 'text'
      
    }
  );
}
  
}  

