import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router) { }
  path:string = ""
  ngOnInit(): void {
    this.router.navigate([{outlets:{branching:['inbox']}}]);

  }
  switchToSendEmail(){
    this.router.navigate([{outlets:{branching:['sendEmail']}}]);

  }
  switchToSent(){
    this.router.navigate([{outlets:{branching:['sent']}}]);

  }
  switchToInbox(){
    this.router.navigate([{outlets:{branching:['inbox']}}]);

  }
  switchToTrash(){
    this.router.navigate([{outlets:{branching:['trash']}}]);

  }
  switchToDraft(){
    this.router.navigate([{outlets:{branching:['draft']}}]);

  }
  switchToContacts(){
    this.router.navigate([{outlets:{branching:['contacts']}}]);

  }
}
