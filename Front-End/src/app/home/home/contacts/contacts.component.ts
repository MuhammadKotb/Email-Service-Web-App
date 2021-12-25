import { Component, OnInit } from '@angular/core';
import { EmailI } from '../home.component'
import { InboxComponent } from '../inbox/inbox.component';


export interface ContactI{
  username: string
  number: string
}



@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css']
})
export class ContactsComponent implements OnInit {
  private listOfContacts : ContactI[] = []
  private viewArray : string[][] = []

  constructor() { 
  }

  ngOnInit(): void {
   var x : ContactI = {
     username: "Joe",
     number: "01117070754"
   }
   var y : ContactI = {
    username: "Mn3m",
    number: "01204538296"
  }
  var z : ContactI = {
    username: "Deffo",
    number: "01121798861"
  }
  var w : ContactI = {
    username: "otb",
    number: "01143330116"
  }

    this.listOfContacts.push(x)
    this.listOfContacts.push(y)
    this.listOfContacts.push(z)
    this.listOfContacts.push(w)

    this.parseArray()
    let placer = new InboxComponent()
    placer.place(this.viewArray,3,"Send Email")
}
parseArray(){
  for (let email=0; email < this.listOfContacts.length;email++){
    this.viewArray[email] = [] 
    this.viewArray[email][0] = this.listOfContacts[email].username
    this.viewArray[email][1] = this.listOfContacts[email].number
  }
}



}
