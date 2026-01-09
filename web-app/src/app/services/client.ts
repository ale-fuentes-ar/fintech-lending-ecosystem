import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { firstValueFrom } from 'rxjs';

// Definimos la interfaz del Cliente para que TypeScript nos ayude
export interface Client {
  dni: string;
  fullName: string;
  income: number;
  creditScore?: number;
  riskLevel?: string;
}

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private http = inject(HttpClient);
  // URL de tu Microservicio A (ms-client)
  private apiUrl = 'http://localhost:8082/api/v1/clients';
  clientSignal = signal<Client | null>(null);
  loading = signal<boolean>(false);
  errorMessage = signal<string | null>(null);

  async getClient(dni: string) {
    this.loading.set(true);
    this.errorMessage.set(null);
    try {
      const data = await firstValueFrom(this.http.get<Client>(`${this.apiUrl}/${dni}`));
      this.clientSignal.set(data);
    } catch (error: any) {
      console.error('Error:', error);
      this.clientSignal.set(null);
      if (error.status === 404) {
        this.errorMessage.set('El cliente no existe en nuestra base de datos.');
      } else {
        this.errorMessage.set('Hubo un problema de conexión. Intente más tarde.');
      }
    } finally {
      this.loading.set(false);
    }
  }


}