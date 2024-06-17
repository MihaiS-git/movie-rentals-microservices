import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import { MoviesComponent } from './movies/movies.component';
import { MovieListComponent } from './movies/movie-list/movie-list.component';
import { MovieDetailComponent } from './movies/movie-detail/movie-detail.component';
import { ClientsComponent } from './clients/clients.component';
import { ClientDetailComponent } from './clients/client-detail/client-detail.component';
import { ClientListComponent } from './clients/client-list/client-list.component';
import { RentalsComponent } from './rentals/rentals.component';
import { RentalListComponent } from './rentals/rental-list/rental-list.component';
import { RentalDetailComponent } from './rentals/rental-detail/rental-detail.component';
import { RentalService } from './service/rental.service';
import { ClientService } from './service/client.service';
/* import { RentalInboxComponent } from './rentals/rental-inbox/rental-inbox.component';
import { ClientsInboxComponent } from './clients/clients-inbox/clients-inbox.component';
import { MovieInboxComponent } from './movies/movie-inbox/movie-inbox.component'; */
import { MovieService } from './service/movie.service';
/* import { RentalInboxService } from './service/rental-inbox.service';
import { MovieInboxService } from './service/movie-inbox.service';
import { ClientInboxService } from './service/client-inbox.service'; */


@NgModule({
  declarations: [
    AppComponent,
    MoviesComponent,
    MovieListComponent,
    MovieDetailComponent,
    ClientsComponent,
    ClientDetailComponent,
    ClientListComponent,
    RentalsComponent,
    RentalListComponent,
    RentalDetailComponent,
/*     RentalInboxComponent,
    ClientsInboxComponent,
    MovieInboxComponent, */
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [MovieService, ClientService, RentalService, /* RentalInboxService, MovieInboxService, ClientInboxService */],
  bootstrap: [AppComponent]
})
export class AppModule {
}
