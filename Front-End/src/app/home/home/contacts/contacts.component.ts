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
  public static listOfContacts : ContactI[]
  private viewArray : string[][]
  private listPreSize : number
  private iterationsNum : number
  private listOfButtons : NodeList

  constructor(private router : Router, private serveMe1: ContactService) {
    ContactsComponent.listOfContacts = []
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

    ContactsComponent.listOfContacts.push(x)
    ContactsComponent.listOfContacts.push(y)
    ContactsComponent.listOfContacts.push(z)
    ContactsComponent.listOfContacts.push(w)

  // this.serveMe1.getContacts(LoginComponent.globalUsername).subscribe((data : ContactI[])=> {ContactsComponent.listOfContacts = data; console.log(ContactsComponent.listOfContacts);});

  this.listPreSize = this.viewArray.length
  this.parseArray()

    this.place(this.viewArray,this.iterationsNum,this.listPreSize,"Send Email")
     this.listOfButtons = document.querySelectorAll("td  > button")
    this.checkClick()
}
parseArray(){
  for (let contact=0; contact < ContactsComponent.listOfContacts.length;contact++){
    this.viewArray[contact] = []
    this.viewArray[contact][0] = ContactsComponent.listOfContacts[contact].username
    this.viewArray[contact][1] = ContactsComponent.listOfContacts[contact].additionalEmails[0]
  }
}

addContact(){

  var username_input = (<HTMLInputElement>document.getElementById("username")).value
  var email_input = (<HTMLInputElement>document.getElementById("email")).value
  console.log(username_input)
  console.log(email_input)
  var contact : ContactI = {
    username: username_input,
    additionalEmails: [email_input]
  }

  ContactsComponent.listOfContacts.push(contact)
  this.listPreSize = this.viewArray.length
  this.viewArray.length = 0
  this.viewArray[0] = []
  this.viewArray[0][0] = contact.username
  this.viewArray[0][1] = ContactsComponent.listOfContacts[0].additionalEmails[0]
  this.place(this.viewArray,this.iterationsNum,this.listPreSize,"Send Email")


  this.serveMe1.addContact(LoginComponent.globalUsername,contact).subscribe((data : ContactI[])=> {ContactsComponent.listOfContacts = data;});

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
sortContacts(input : ContactI[]){
  this.listPreSize = ContactsComponent.listOfContacts.length;
  ContactsComponent.listOfContacts = input
  this.parseArray();
  this.place(this.viewArray,this.iterationsNum,this.listPreSize);
  this.listOfButtons = document.querySelectorAll("td  > button");
  this.checkClick();
}
filterContacts(input : ContactI[]){
  console.log(input.length)
  this.listPreSize = ContactsComponent.listOfContacts.length;
  console.log("INPUT LENGTH ", input.length)
  ContactsComponent.listOfContacts = input
  console.log("COMP LENGTH ", ContactsComponent.listOfContacts.length);

  this.parseArray();
  console.log(this.viewArray.length);
  if(input.length == 0){
    this.viewArray = [];
  }

  this.place(this.viewArray,this.iterationsNum,this.listPreSize);
  this.listOfButtons = document.querySelectorAll("td  > button");
  this.checkClick();
}
searchContacts(input : ContactI[]){
  console.log(input.length)
  this.listPreSize = ContactsComponent.listOfContacts.length;
  console.log("INPUT LENGTH ", input.length)
  ContactsComponent.listOfContacts = input
  console.log("COMP LENGTH ", ContactsComponent.listOfContacts.length);

  this.parseArray();
  console.log(this.viewArray.length);
  if(input.length == 0){
    this.viewArray = [];
  }

  this.parseArray();
  this.place(this.viewArray,this.iterationsNum,this.listPreSize);
  this.listOfButtons = document.querySelectorAll("td  > button");
  this.checkClick();
}



    deleteClicked(e: any){
      try{
        const buttonNum = parseInt(e.target.id)
        this.serveMe1.removeContact(LoginComponent.globalUsername,ContactsComponent.listOfContacts[(buttonNum-1)/2].username).subscribe((data : ContactI[])=> {
          this.router.navigateByUrl('/home',{skipLocationChange:true}).then(()=>{
            this.router.navigate(["/home/contacts"])

          })
        });
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
      place(viewArray : string[][],iterationsNum : number,listPreSize: number,btnName: string = "Show"){
        var body = document.getElementById("mybody")
        var buttonCount = 0
        for (let i=0;i<listPreSize;i++){
          console.log("REMOVED CHILD");
          body?.removeChild(body?.childNodes[0])
        }
        console.log(viewArray)
        for (let i=0;i<viewArray.length;i++){
          var node = document.createElement("tr");
          node.style.width = "300px"
          node.style.textAlign = "center"
          node.style.padding = "7px"
          node.style.margin = "50px"
          for (let j=0;j<iterationsNum;j++){
              var node2 = document.createElement("td");
              if (j!=iterationsNum-1){
                var textNode = document.createTextNode(viewArray[i][j]);
                node2.appendChild(textNode);
              }else{
                if (btnName!="Delete"){
                  var node3 = document.createElement("button");
                  node3.style.marginRight = "5px"
                  var textNode = document.createTextNode(btnName);
                  node3.appendChild(textNode);
                  node3.type = "button";
                  node3.id = (buttonCount).toString()
                  node2.appendChild(node3);
                  buttonCount++
                }
                var textNode2 = document.createTextNode("Delete");
                var node4 = document.createElement("button");
                node4.style.marginRight = "5px"
                node4.appendChild(textNode2);
                node4.type = "button";
                node4.id = (buttonCount).toString()
                node2.appendChild(node4);
                buttonCount++
              }
              node.appendChild(node2);
          }
          document.getElementById("mybody")?.appendChild(node);
      }
    }
  }
