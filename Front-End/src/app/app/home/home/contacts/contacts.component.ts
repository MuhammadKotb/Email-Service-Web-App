import { Placeholder } from '@angular/compiler/src/i18n/i18n_ast';
import { Component, OnInit } from '@angular/core';
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
  private listOfContacts : ContactI[] =[]
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
  for (let contact=0; contact < this.listOfContacts.length;contact++){
    this.viewArray[contact] = [] 
    this.viewArray[contact][0] = this.listOfContacts[contact].username
    this.viewArray[contact][1] = this.listOfContacts[contact].number
  }
}

addContact(){

  var username_input = (<HTMLInputElement>document.getElementById("username")).value
  var phone_input = (<HTMLInputElement>document.getElementById("phone")).value
  var contact : ContactI = {
    username: username_input,
    number: phone_input
  }

  this.listOfContacts.push(contact)
  this.viewArray.length = 0
  this.viewArray[0] = []
  this.viewArray[0][0] = contact.username
  this.viewArray[0][1] = contact.number
  let placer = new InboxComponent()
  placer.place(this.viewArray,3,"Send Email")

}



}
