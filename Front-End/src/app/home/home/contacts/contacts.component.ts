import { Placeholder } from '@angular/compiler/src/i18n/i18n_ast';
import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/login/login/login.component';
import { EmailI, HomeComponent } from '../home.component';
import { InboxComponent } from '../inbox/inbox.component';
import { InboxService } from '../inbox/inbox.service';
import { ContactService } from './contacts.service';


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
  public static listOfContacts : ContactI[] 
  private viewArray : string[][] 
  private listPreSize : number
  private iterationsNum : number
  private listOfButtons : NodeList

  constructor(private serveMe1: ContactService, private placer : InboxComponent  ) { 
    ContactsComponent.listOfContacts = []
    this.viewArray = []
    this.listPreSize = this.viewArray.length
    this.iterationsNum = 3
    HomeComponent.pageIndicator = "Contacts"

  }



  ngOnInit(): void {
  //  var x : ContactI = {
  //    username: "Joe",
  //    number: "01117070754"
  //  }
  //  var y : ContactI = {
  //   username: "Mn3m",
  //   number: "01204538296"
  // }
  // var z : ContactI = {
  //   username: "Deffo",
  //   number: "01121798861"
  // }
  // var w : ContactI = {
  //   username: "otb",
  //   number: "01143330116"
  // }

  //   ContactsComponent.listOfContacts.push(x)
  //   ContactsComponent.listOfContacts.push(y)
  //   ContactsComponent.listOfContacts.push(z)
  //   ContactsComponent.listOfContacts.push(w)

  this.serveMe1.getContacts(LoginComponent.globalUsername).subscribe((data : ContactI[])=> {ContactsComponent.listOfContacts = data; console.log(ContactsComponent.listOfContacts);});
  this.listPreSize = this.viewArray.length
    this.parseArray()
    this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Send Email")   
     this.listOfButtons = document.querySelectorAll("td  > button")
    this.checkClick()
}
parseArray(){
  for (let contact=0; contact < ContactsComponent.listOfContacts.length;contact++){
    this.viewArray[contact] = [] 
    this.viewArray[contact][0] = ContactsComponent.listOfContacts[contact].username
    this.viewArray[contact][1] = ContactsComponent.listOfContacts[contact].number
  }
}

addContact(){

  var username_input = (<HTMLInputElement>document.getElementById("username")).value
  var phone_input = (<HTMLInputElement>document.getElementById("phone")).value
  var contact : ContactI = {
    username: username_input,
    number: phone_input
  }

  ContactsComponent.listOfContacts.push(contact)
  this.listPreSize = this.viewArray.length
  this.viewArray.length = 0
  this.viewArray[0] = []
  this.viewArray[0][0] = contact.username
  this.viewArray[0][1] = contact.number
  this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Send Email")

}
checkClick(){
    for (var i =  0 ; i < this.listOfButtons.length ; i++){
      if (i%2){
        this.listOfButtons[i].addEventListener("click", e =>{
          this.serveMe1?.deleteContact(LoginComponent.globalUsername,ContactsComponent.listOfContacts[(i-1)/2].username).subscribe((data : ContactI[])=> {
            ContactsComponent.listOfContacts = data;
             console.log(ContactsComponent.listOfContacts)
        this.listPreSize = this.viewArray.length
        this.parseArray()
        this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Send Email")
      });})

      }else{
        //ROUTE TO SEND EMAIL WITH RECIEVER
        }
        
      }
      
    }
  }
