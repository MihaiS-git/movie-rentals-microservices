import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ClientInboxService } from 'src/app/service/client-inbox.service';

@Component({
  selector: 'app-clients-inbox',
  templateUrl: './clients-inbox.component.html',
  styleUrls: ['./clients-inbox.component.css']
})
export class ClientsInboxComponent implements OnInit, OnDestroy {
  message = '';
  private messageSubscription: Subscription = new Subscription();

  constructor(private clientInboxService: ClientInboxService) { }

  ngOnInit(): void {
    this.messageSubscription = this.clientInboxService.getMessage().subscribe(
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

