import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { Movie } from 'src/app/model/movie.model';
import { MovieService } from 'src/app/service/movie.service';
import { log } from 'console';

@Component({
  moduleId: module.id,
  selector: 'movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css'],
})
export class MovieListComponent implements OnInit {
  errorMessage: string = '';
  movies: Array<Movie> = [];
  displayedMovies: Array<Movie> = [];
  selectedMovie: Movie | undefined;
  searchTitle: string = '';

  constructor(
    private movieService: MovieService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getMovies();
  }

  getMovies() {
    this.movieService.getMovies()
      .subscribe({
        next: (movies) => {
          this.movies = movies;
          this.displayedMovies = this.movies;
        },
        error: (err: any) => {
          this.errorMessage = err;
        },
        complete: () => { },
      });
  }

  onSelect(movie: Movie): void {
    this.selectedMovie = movie;
  }

  gotoDetail(): void {
    this.router.navigate(['/movie/detail', this.selectedMovie?.id]);
  }

  deleteMovie(): void {
    if (this.selectedMovie) {
      this.movieService.delete(this.selectedMovie.id).subscribe({
        next: () => {
          this.movies = this.movies.filter(
            (movie) => movie.id !== this.selectedMovie?.id
          );
          this.selectedMovie = undefined;
        },
        error: (err: any) => {
          console.error('Error deleting movie: ', err);
        },
        complete: () => { },
      });
    }
  }

  addNewMovie(): void {
    this.router.navigate(['/movie/detail', 'new']);
  }

  sortMoviesOrderedByTitleAsc() {
    this.displayedMovies.sort((a, b) => a.title.localeCompare(b.title));
  }

  sortMoviesOrderedByTitleDesc() {
    this.displayedMovies.sort((a, b) => b.title.localeCompare(a.title));
  }

  findMoviesByTitle(searchTitle: string) {
    const filteredMovies = this.movies.filter(movie =>
      movie.title.toLowerCase().includes(searchTitle.toLowerCase())
    );
    this.displayedMovies = filteredMovies;
  }

  resetFilter() {
    this.searchTitle = '';
    this.displayedMovies = this.movies;
  }
}
