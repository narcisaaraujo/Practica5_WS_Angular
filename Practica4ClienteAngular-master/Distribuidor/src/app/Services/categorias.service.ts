import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoriasService {
  public productos: any=[];

  constructor(private http: HttpClient) { }
  getCategorias(){
    return this.http.get("/Distribuidor/rest/prueba/Categorias");
  }
}
