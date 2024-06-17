/* import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Message, Stomp } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClientInboxService {
  private stompClient: any;
  private messageSubject: Subject<string> = new Subject<string>();

  constructor() {
    this.initializeWebSocketConnection();
  }

  private initializeWebSocketConnection(): void {
    const serverUrl = environment.websocketUrls.clientEntityApiUrl;
    const ws = new SockJS(serverUrl);
    this.stompClient = Stomp.over(ws);

    this.stompClient.configure({
      reconnectDelay: 1000, // Automatically reconnect with a delay
      heartbeatIncoming: 1000, // Check if the server is alive every 4 seconds
      heartbeatOutgoing: 1000, // Tell the server that the client is alive every 4 seconds
      onConnect: (frame: any) => this.onConnected(frame),
      onStompError: (frame: any) => this.onError(frame),
      onWebSocketClose: (evt: CloseEvent) => this.onWebSocketClose(evt),
      onWebSocketError: (evt: Event) => this.onWebSocketError(evt)
    });

    this.stompClient.activate();
  }

  private onConnected(frame: any): void {
    console.log('Connected: ' + frame);
    this.stompClient.subscribe('/topic/clientmessage', (message: Message) => {
      try {
        const parsedMessage = JSON.parse(message.body);
        if (parsedMessage.message) {
          this.messageSubject.next(parsedMessage.message);
        }
      } catch (error) {
        console.error('Error parsing message body:', error);
      }
    });
  }

  private onError(frame: any): void {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
  }

  private onWebSocketClose(evt: CloseEvent): void {
    console.error('WebSocket closed. Reconnecting...', evt);
  }

  private onWebSocketError(evt: Event): void {
    console.error('WebSocket error. Reconnecting...', evt);
  }

  getMessage(): Observable<string> {
    return this.messageSubject.asObservable();
  }
}
 */
