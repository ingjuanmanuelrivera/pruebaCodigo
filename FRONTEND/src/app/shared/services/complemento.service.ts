import { Injectable } from '@angular/core';

import axios from 'axios';

@Injectable({
  providedIn: 'root',
})
export class Complemento {

  private headers_service: any = '';

  constructor( ){


  }



  headers = async (token?: string) => {
    return (this.headers_service = {

      'Content-Type': 'application/json',
    });
  };

  async retorno_post(url: string, data: any){
    let retorno = await axios
      .post(url, data, {
        headers: this.headers_service,
      })
      .then((response: { data: any; }) => response.data)
      .catch(function (error: { response: { data: any; status: any; headers: any; }; }) {
        if (error.response) {
          console.log(error.response.data);
          console.log(error.response.status);
          console.log(error.response.headers);
        }
      });;
    return retorno;
  }

  async retorno_get(url: string){
    let retorno = await axios
      .get(url, {
        headers: this.headers_service,
      })
      .then((response: { data: any; }) => response.data)
      .catch(function (error: { response: { data: any; status: any; headers: any; }; }) {
        if (error.response) {
          console.log(error.response.data);
          console.log(error.response.status);
          console.log(error.response.headers);
        }
      });
    return retorno;
  }

}
