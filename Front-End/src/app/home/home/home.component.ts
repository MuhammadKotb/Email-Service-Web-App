import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';


export interface EmailI{
  subject : string;
  body : string;
  owner : string;
  senderUsername: string;
  recieverUsername: string;
  emailID: string;
  emailType: string;
  timeSent: string;
  priority: string;
}
  

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router) { }

  path:string = ""
  ngOnInit(): void {
    this.router.navigate(['/home/inbox']);

  }
  switchToSendEmail(){
    this.router.navigate(['/home/sendEmail']);

  }
  switchToSent(){
    this.router.navigate(['/home/sent']);

  }
  switchToInbox(){
    this.router.navigate(['/home/inbox']);

  }
  switchToTrash(){
    this.router.navigate(['/home/trash']);

  }
  switchToDraft(){
    this.router.navigate(['/home/draft']);

  }
  switchToContacts(){
    this.router.navigate(['/home/contacts']);

  }
  logOut(){
    this.router.navigate(['']);
  }

}
