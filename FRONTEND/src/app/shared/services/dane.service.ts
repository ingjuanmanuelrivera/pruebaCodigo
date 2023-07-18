import { Injectable } from '@angular/core';

import { Complemento } from './complemento.service';
import { BackendmapServiceEnsayos } from './backendmap.service';




@Injectable({
  providedIn: 'root',
})
export class Transversal {

  constructor(private _backendService: BackendmapServiceEnsayos,  private common: Complemento) {
  }

  viajes = async (cadena: string) => {
    const url = `${this._backendService.URL_VIAJE+cadena}`;
    return await  this.common.retorno_get(url);
  }

  viajeCapitulo1 = async (data: any) => {
    const url = `${this._backendService.URL_VIAJE_CAPITULO1}`;
    return await  this.common.retorno_post(url,data);
  }

  viajeCapitulo1Quienes = async (data: any) => {
    const url = `${this._backendService.URL_VIAJE_CAPITULO1_QUIENES}`;
    return await  this.common.retorno_post(url,data);
  }

  viajeCapitulo2 = async (data: any) => {
    const url = `${this._backendService.URL_VIAJE_CAPITULO2}`;
    return await  this.common.retorno_post(url,data);
  }

  viajeCapitulo2Servicios = async (data: any) => {
    const url = `${this._backendService.URL_VIAJE_CAPITULO1}`;
    return await  this.common.retorno_post(url,data);
  }

  viajeCapitulo2Gastos = async (data: any) => {
    const url = `${this._backendService.URL_VIAJE_CAPITULO2_GASTOS}`;
    return await  this.common.retorno_post(url,data);
  }

  viajeCapitulo2Visita = async (data: any) => {
    const url = `${this._backendService.URL_VIAJE_CAPITULO2_VISITA}`;
    return await  this.common.retorno_post(url,data);
  }





}
