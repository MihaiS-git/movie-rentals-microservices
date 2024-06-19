import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { MovieInboxService } from 'src/app/service/movie-inbox.service';

@Component({
  selector: 'app-movie-inbox',
  templateUrl: './movie-inbox.component.html',
  styleUrls: ['./movie-inbox.component.css']
})
export class MovieInboxComponent implements OnInit, OnDestroy {
  message = '';
  private messageSubscription: Subscription = new Subscription();

  constructor(private movieInboxService: MovieInboxService) { }

  ngOnInit(): void {
    this.messageSubscription = this.movieInboxService.getMessage().subscribe(
      (msg: string) => {
        console.log(msg);
        this.message = msg;
      },
      (error) => {
        console.error('Error receiving message:', error);
      }
    );
  }

  ngOnDestroy(): void {
    if (this.messageSubscription) {
      this.messageSubscription.unsubscribe();
    }
  }
}

