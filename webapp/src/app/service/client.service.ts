import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from "@angular/common/http";


import { Observable, throwError } from "rxjs";
import { catchError, map } from "rxjs/operators";
import { Client } from '../model/client.model';
import { environment } from 'src/environments/environment';


@Injectable()
export class ClientService {
  /* private clientsUrl = "http://localhost:9096/api/clients"; */
  private clientsUrl = `${environment.apiUrl}/api/clients`;

  constructor(private httpClient: HttpClient) {
  }

  getClients(): Observable<Client[]> {
    return this.httpClient
      .get<Array<Client>>(this.clientsUrl);
  }

  getClient(id: number): Observable<Client | undefined> {
    return this.getClients()
      .pipe(
        map(clients => clients.find(client => client.id === id))
      );
  }

  update(client: Client): Observable<Client> {
    const url = client.id ? `${this.clientsUrl}/${client.id}` : this.clientsUrl;
    if (client.id) {
      return this.httpClient.put<Client>(url, client);
    } else {
      return this.httpClient.post<Client>(url, client);
    }
  }

  delete(clientId: number): Observable<void> {
    const url = `${this.clientsUrl}/${clientId}`;
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.httpClient.delete<void>(url, { headers }).pipe(
      catchError((error) => {
        console.error('Error deleteing client', error);
        return throwError(error);
      })
    )
  }
}
