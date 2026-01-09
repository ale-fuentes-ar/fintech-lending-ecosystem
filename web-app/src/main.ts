import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app'; // 1. Cambiar 'App' por 'AppComponent'

bootstrapApplication(AppComponent, appConfig) // 2. Usar 'AppComponent' aquí
  .catch((err) => console.error(err));