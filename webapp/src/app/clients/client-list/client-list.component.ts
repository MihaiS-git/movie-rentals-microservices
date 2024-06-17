import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from '../../model/client.model';
import { ClientService } from 'src/app/service/client.service';

@Component({
  moduleId: module.id,
  selector: 'client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {
  errorMessage: string = "";
  clients: Array<Client> = [];
  displayedClients: Array<Client> = [];
  selectedClient: Client | undefined;
  searchName: string = '';

  constructor(private clientService: ClientService,
    private router: Router) {
  }

  ngOnInit(): void {
    this.getClients();
  }

  getClients() {
    this.clientService.getClients()
      .subscribe({
        next: (clients) => {
          this.clients = clients
          this.displayedClients = this.clients;
        },
        error: (err: any) => {
          this.errorMessage = err
        },
        complete: () => {
        }
      })
  }

  onSelect(client: Client): void {
    this.selectedClient = client;
  }

  gotoDetail(): void {
    this.router.navigate(['/client/detail', this.selectedClient?.id]);
  }

  deleteClient(): void {
    if (this.selectedClient) {
      this.clientService.delete(this.selectedClient.id).subscribe({
        next: () => {
          this.clients = this.clients.filter(
            (client) => client.id !== this.selectedClient?.id
          );
          this.selectedClient = undefined;
        },
        error: (err: any) => {
          console.error("Error deleting client: ", err);
        },
        complete: () => { },
      });
    }
  }

  addNewClient(): void {
    this.router.navigate(['/client/detail', 'new']);
  }

  sortClientsOrderedByFirstNameAsc() {
    this.displayedClients.sort((a, b) => b.firstName.localeCompare(a.firstName));
  }

  sortClientsOrderedByFirstNameDesc() {
    this.displayedClients.sort((a, b) => a.firstName.localeCompare(b.firstName));
  }

  findClientsByFirstName(searchName: string) {
    const filteredClients = this.clients.filter(client =>
      client.firstName.toLowerCase().includes(searchName.toLowerCase()) ||
      client.lastName.toLowerCase().includes(searchName.toLowerCase()));
    this.displayedClients = filteredClients;
  }

  resetFilter() {
    this.searchName = '';
    this.displayedClients = this.clients;
  }
}
