import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductosComponent } from './Components/productos/productos.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { ProductosService } from './Services/productos.service';
import { CategoriasComponent } from './Components/categorias/categorias.component';
import { BodegasComponent } from './Components/bodegas/bodegas.component';
import { HomeComponent } from './Components/home/home.component';
import { UsuariosComponent } from './Components/usuarios/usuarios.component';
import { Page404Component } from './Components/page404/page404.component';
import { PersonaService } from './Services/persona.service';
import { InicioSesionComponent } from './Components/inicio-sesion/inicio-sesion.component';
import { BodegasService } from './Services/bodegas.service';


import { EliminarComponent } from './Components/eliminar/eliminar.component';
import { ActivarCuentaComponent } from './Components/activar-cuenta/activar-cuenta.component';

import { CarritoComponent } from './Components/carrito/carrito.component';

import { PedidosService } from './Services/pedidos.service';
import { PedidosComponent } from './Components/pedidos/pedidos.component';

import { ModificarComponent } from './Components/modificar/modificar.component';


//import { EliminarComponent } from './Components/eliminar/eliminar.component';
//import { ActivarCuentaComponent } from './Components/activar-cuenta/activar-cuenta.component';
//import { CarritoComponent } from './Components/carrito/carrito.component';



@NgModule({
  declarations: [
    AppComponent,
    ProductosComponent,
    CategoriasComponent,
    BodegasComponent,
    HomeComponent,
    UsuariosComponent,
    Page404Component,
    InicioSesionComponent,


    EliminarComponent,
    ActivarCuentaComponent,

    ModificarComponent,
    EliminarComponent,
    ActivarCuentaComponent,
    CarritoComponent,
    PedidosComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [ProductosService,PersonaService,BodegasService,PedidosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
