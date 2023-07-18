import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BackendmapServiceEnsayos {
  BASE_URL = environment.base_url;
  BASE_BACKEND: string = this.BASE_URL;
  BASE_PRUEBA: string = this.BASE_BACKEND +'api/';

  //Informacion de los endpoints de sprintboot
  URL_USUARIO: string = this.BASE_PRUEBA+'usuarios';

  URL_VIAJE: string = this.BASE_PRUEBA+'viajes';

  URL_VIAJE_CAPITULO1: string = this.BASE_PRUEBA+'viajeCapitulo1s';
  URL_VIAJE_CAPITULO1_QUIENES: string = this.BASE_PRUEBA+'viajeCapitulo1Quieness';

  URL_VIAJE_CAPITULO2: string = this.BASE_PRUEBA+'viajeCapitulo2s';
  URL_VIAJE_CAPITULO2_SERVICIOS: string = this.BASE_PRUEBA+'viajeCapitulo2Servicios';

  URL_VIAJE_CAPITULO2_GASTOS: string = this.BASE_PRUEBA+'viajeCapitulo3Gastoss';
  URL_VIAJE_CAPITULO2_VISITA: string = this.BASE_PRUEBA+'viajeCapitulo2Visitas';

  constructor() { }
}
