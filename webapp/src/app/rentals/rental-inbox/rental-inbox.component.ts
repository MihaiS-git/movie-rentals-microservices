import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { RentalInboxService } from 'src/app/service/rental-inbox.service';

@Component({
  selector: 'app-rental-inbox',
  templateUrl: './rental-inbox.component.html',
  styleUrls: ['./rental-inbox.component.css']
})
export class RentalInboxComponent implements OnInit, OnDestroy {
  message = '';
  private messageSubscription: Subscription = new Subscription();

  constructor(private rentalInboxService: RentalInboxService) { }

  ngOnInit(): void {
    this.messageSubscription = this.rentalInboxService.getMessage().subscribe(
      (msg: string) => {
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

