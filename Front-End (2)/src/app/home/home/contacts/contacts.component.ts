import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from 'src/app/login/login/login.component';
import { EmailI, HomeComponent } from '../home.component';
import { InboxComponent } from '../inbox/inbox.component';
import { ContactService } from './contacts.service';
import $ from "jquery"


export interface ContactI{
  username: string
  additionalEmails: string[]
}

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css']
})
export class ContactsComponent implements OnInit {
  private listOfContacts : ContactI[] 
  private viewArray : string[][] 
  private listPreSize : number
  private iterationsNum : number
  private listOfButtons : NodeList

  constructor(private router : Router, private serveMe1: ContactService, private placer : InboxComponent  ) { 
    this.listOfContacts = []
    this.viewArray = []
    this.listPreSize = this.viewArray.length
    this.iterationsNum = 3
    HomeComponent.pageIndicator = "Contacts"

  }



  ngOnInit(): void {
   var x : ContactI = {
     username: "Joe",
     additionalEmails: ["youssef.okab@gmail.com"]
   }
   var y : ContactI = {
    username: "Mn3m",
    additionalEmails: ["mono.ghost@gmail.com"]
  }
  var z : ContactI = {
    username: "Deffo",
    additionalEmails: ["deffo.he5o@gmail.com"]
  }
  var w : ContactI = {
    username: "otb",
    additionalEmails: ["otb@gmal.com"]
  }

    this.listOfContacts.push(x)
    this.listOfContacts.push(y)
    this.listOfContacts.push(z)
    this.listOfContacts.push(w)

  // this.serveMe1.getContacts(LoginComponent.globalUsername).subscribe((data : ContactI[])=> {this.listOfContacts = data; console.log(this.listOfContacts);});
  this.listPreSize = this.viewArray.length
    this.parseArray()
    this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Send Email")   
     this.listOfButtons = document.querySelectorAll("td  > button")
    this.checkClick()
}
parseArray(){
  for (let contact=0; contact < this.listOfContacts.length;contact++){
    this.viewArray[contact] = [] 
    this.viewArray[contact][0] = this.listOfContacts[contact].username
    this.viewArray[contact][1] = this.listOfContacts[contact].additionalEmails[0]
  }
}

addContact(){

  var username_input = (<HTMLInputElement>document.getElementById("username")).value
  var email_input = (<HTMLInputElement>document.getElementById("phone")).value
  var contact : ContactI = {
    username: username_input,
    additionalEmails: [email_input]
  }

  this.listOfContacts.push(contact)
  this.listPreSize = this.viewArray.length
  this.viewArray.length = 0
  this.viewArray[0] = []
  this.viewArray[0][0] = contact.username
  this.viewArray[0][1] = this.listOfContacts[0].additionalEmails[0]
  this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Send Email")

}

checkClick(){
  for (var i =  0 ; i < this.listOfButtons.length ; i++){

    if (i%2){
      this.listOfButtons[i].addEventListener("click",$.proxy(this.deleteClicked,this));
    }else{
      this.listOfButtons[i].addEventListener("click",$.proxy(this.sendEmailClicked,this));
    }
    
  }
}


    deleteClicked(e: any){
      try{
        const buttonNum = parseInt(e.target.id)
        // this.serveMe1?.deleteContact(LoginComponent.globalUsername,this.listOfContacts[(buttonNum-1)/2].username).subscribe((data : ContactI[])=> {
        //   this.listOfContacts = data;
        //   console.log(this.listOfContacts)
        //   this.listPreSize = this.viewArray.length
        //   this.parseArray()
        //   this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Send Email")
        // });
      }catch (error){
        console.log(error)
      }
    }
      sendEmailClicked(e: any){
        try{
          this.router.navigate(['/home/sendEmail']);

        }catch (error){
          console.log(error)
        }
      }
  }
