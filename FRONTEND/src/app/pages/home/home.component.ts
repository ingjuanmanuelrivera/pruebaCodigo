import { Component } from '@angular/core';
import { BackendmapServiceEnsayos } from '../../shared/services/backendmap.service';
import { Transversal } from 'src/app/shared/services/dane.service';

@Component({
  templateUrl: 'home.component.html',
  styleUrls: [ './home.component.scss' ]
})

export class HomeComponent {

  isVisible = false;

  type = 'info';

  message = '';

  baseFormulario: boolean = false;
  listaSexo: string[];
  limiteCantidad: any;
  mostrarOtro: boolean = false;
  mostrarCuantasPersonasViajan: boolean = false;
  verOpc7: boolean = false;
  listaAcompanamiento: any = [
    'Solo','Amigos','Familia','Compañeros de trabajo y/o estudio','Otro'
  ]
  listaMotivos: any =  [
    {
      ID: 1,
      Name: 'Visita a familiares o amigos'
    },{
      ID: 2,
      Name: 'Vacaciones (recreación, ocio, sol y playa)'
    },{
      ID: 3,
      Name: 'Compras'
    },{
      ID: 4,
      Name: 'Turismo Cultural'
    },{
      ID: 5,
      Name: 'Asistencia a eventos artísticos remunerado en destino) y/o deportivos destino'
    },{
      ID: 6,
      Name: 'Estudio y/o formación'
    },{
      ID: 7,
      Name: 'Tratamiento de salud y belleza'
    },{
      ID: 8,
      Name: 'Religioso'
    },{
      ID: 9,
      Name: 'Asistencia a Congresos, Seminarios convenciones'
    },{
      ID: 10,
      Name: 'Trabajo remunerado en destino  '
    },{
      ID: 11,
      Name: 'Trabajo o negocio (no remunerado en destino)'
    },{
      ID: 12,
      Name: 'Participación en eventos artísticos y/o deportivos'
    },{
      ID: 13,
      Name: 'Tránsito'
    }
  ]

  listaSiNo: any = ['Si', 'No']
  listaTipoMoneda: any = ['COP', 'USD']
  listaPaises: any = ['Venezuela', 'Paraguay', 'Chile', 'Panama', 'Argentina']

  constructor(public endpoint: Transversal) {
    this.listaSexo = [
      'Masculino',
      'Femenino'
    ];

  }

  ngOnInit(): void {
  }


  operarAcompanamiento = (e: any): Promise<boolean> => {
    if (e.event === undefined) {
      // event was triggered by code
      return Promise.resolve(false);
    }
    return new Promise(async (resolve, reject) => {

      if(e.value === 'Solo'){
        this.mostrarCuantasPersonasViajan = false;
      }
      else {
        this.mostrarCuantasPersonasViajan = true;
      }

      if( e.value === 'Otro'){
        this.mostrarOtro = true;
      }
      else {
        this.mostrarOtro = false;
      }

    });
  }

  validarMotivo(e: any) {
    if(e.value == 1){
      this.verOpc7 = true;
    }
    else{
      this.verOpc7 = false;
    }
  }

  cambiarVisualizacion(){
    this.baseFormulario = !this.baseFormulario;
  }

  async guardarPrueba(){
    /*
    await this.endpoint.viajes(this.formPrueba.viajes);

    await this.endpoint.viajeCapitulo1(this.formPrueba.viajeCapitulo1);
    await this.endpoint.viajeCapitulo1Quienes(this.formPrueba.viajeCapitulo1Quienes);
    await this.endpoint.viajeCapitulo2(this.formPrueba.viajeCapitulo2);

    await this.endpoint.viajeCapitulo2Servicios(this.formPrueba.viajeCapitulo2Servicios);
    await this.endpoint.viajeCapitulo2Gastos(this.formPrueba.viajeCapitulo2Gastos);
    await this.endpoint.viajeCapitulo2Visita(this.formPrueba.viajeCapitulo2Visita);
    */

    this.type = "success";
    this.message = "Guardado de forma exitosa";
    this.isVisible = true;
  }



}


