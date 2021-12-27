import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/login/login/login.component';
import { EmailI } from '../home.component';
import { InboxComponent } from '../inbox/inbox.component';
import { InboxService } from '../inbox/inbox.service';
import { TrashService } from './trash.service';

@Component({
  selector: 'app-trash',
  templateUrl: './trash.component.html',
  styleUrls: ['./trash.component.css']
})
export class TrashComponent implements OnInit {
  private listOfEmails : EmailI[] = []
  private viewArray : string[][] = []
  private listPreSize : number = this.viewArray.length
  private placer = new InboxComponent()
  private serveMe1 : InboxService | undefined
  private serveMe2 : TrashService | undefined


  constructor() { 
  }

  ngOnInit(): void {
    var x : EmailI = {
      senderUsername: '',
      timeSent: "27/9/2001",
      subject: "birthday",
      body: '',
      owner: '',
      recieverUsername: "Joe",
      emailID: '',
      emailType: 'Recieved',
      priority: 'Urgent'
    }
    var y : EmailI = {
      senderUsername: '',
      timeSent: "4/6/2001",
      subject: "birthday",
      body: '',
      owner: '',
      recieverUsername: "Meniem",
      emailID: '',
      emailType: 'Recieved',
      priority: 'Important'
    }
    var Z : EmailI = {
      senderUsername: "otb",
      timeSent: "هيخو",
      subject: "birthday",
      body: '',
      owner: '',
      recieverUsername: '',
      emailID: '',
      emailType: 'Sent',
      priority: 'Non-essential'
    }
    var w : EmailI = {
      senderUsername: "deffo",
      timeSent: "لول",
      subject: "birthday",
      body: '',
      owner: '',
      recieverUsername: '',
      emailID: '',
      emailType: 'Sent',
      priority: 'Skipable'
    }

    this.listOfEmails.push(x)
    this.listOfEmails.push(y)
    this.listOfEmails.push(Z)
    this.listOfEmails.push(w)

    this.serveMe1?.getEmails(LoginComponent.globalUsername).subscribe((data : EmailI[])=> {this.listOfEmails = data; console.log(this.listOfEmails);});
    this.listPreSize  = this.viewArray.length
    this.parseArray()
    this.placer.place(this.viewArray,5,this.listPreSize,"Restore")
    this.checkClick()
}
parseArray(){
  for (let email=0; email < this.listOfEmails.length;email++){
    this.viewArray[email] = [] 
    let isSent = this.listOfEmails[email].emailType
    this.viewArray[email][0] = isSent
    if (isSent == "Sent" || isSent == "sent")
      this.viewArray[email][1] = this.listOfEmails[email].senderUsername
    else
      this.viewArray[email][1] = this.listOfEmails[email].recieverUsername
    this.viewArray[email][2] = this.listOfEmails[email].timeSent
    this.viewArray[email][3] = this.listOfEmails[email].subject

  }
}
checkClick(){
  var listOfButtons = document.querySelectorAll("td  > button")
    for (var i =  0 ; i < listOfButtons.length ; i++){
      if (i%2){
        listOfButtons[i].addEventListener("click", e =>{
          this.serveMe1?.delete(this.serveMe1.loginUsername,this.listOfEmails[(i-1)/2]).subscribe((data : EmailI[])=> {this.listOfEmails = data; console.log(this.listOfEmails);});
        })
        this.listPreSize = this.viewArray.length
        this.parseArray()
        this.placer.place(this.viewArray,this.listPreSize,5)
    }else{
        listOfButtons[i].addEventListener("click", e =>{
          this.serveMe2?.restore(this.serveMe2.loginUsername,this.listOfEmails[(i)/2]).subscribe((data : EmailI)=> {var email = data; console.log(this.listOfEmails);
          });
        })
        
      }
      
    }
}





}
