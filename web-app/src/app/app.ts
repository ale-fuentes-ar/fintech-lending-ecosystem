import { Component, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ClientService } from './services/client'; // Importación simplificada

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrls: ['./app.scss']
})
export class AppComponent {
  private clientService = inject(ClientService);
  
  client = this.clientService.clientSignal;
  loading = this.clientService.loading;
   errorMessage = this.clientService.errorMessage; 
  
  dniInput = signal<string>('');

  searchClient() {
    const dni = this.dniInput().trim();
    if (dni) {
      this.clientService.getClient(dni);
    }
  }
}