import {Injectable} from '@angular/core';

import {HttpClient, HttpHeaders} from "@angular/common/http";


import {Observable, throwError} from "rxjs";
import {catchError, map} from "rxjs/operators";
import { Movie } from '../model/movie.model';
import { environment } from 'src/environments/environment';


@Injectable()
export class MovieService {
  /* private moviesUrl = "http://localhost:9097/api/movies"; */
  private moviesUrl = `${environment.apiUrl}/api/movies`;

  constructor(private httpClient: HttpClient) {
  }

  getMovies(): Observable<Movie[]> {
    return this.httpClient
      .get<Array<Movie>>(this.moviesUrl);
  }

  getMovie(id: number): Observable<Movie | undefined> {
    return this.getMovies()
      .pipe(
        map(movies => movies.find(movie => movie.id === id))
      );
  }

  update(movie: Movie): Observable<Movie> {
      const url = movie.id ? `${this.moviesUrl}/${movie.id}` : this.moviesUrl;
      if (movie.id) {
        return this.httpClient.put<Movie>(url, movie);
      } else {
        return this.httpClient.post<Movie>(url, movie);
      }
  }

  delete(movieId: number): Observable<void> {
    const url = `${this.moviesUrl}/${movieId}`;
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.httpClient.delete<void>(url, { headers }).pipe(
      catchError((error) => {
        console.error('Error deleteing movie', error);
        return throwError(error);
      })
    )
  }
}
