import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams  } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PedidosService {

  constructor(private http: HttpClient) { }

getPedidos(correoP){
  console.log(correoP)
  return this.http.get("/Distribuidor/rest/prueba/ListarPedidos/"+correoP);
}

}

