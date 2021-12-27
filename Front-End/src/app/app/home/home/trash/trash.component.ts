import { Component, OnInit } from '@angular/core';
import { EmailI } from '../home.component';
import { InboxComponent } from '../inbox/inbox.component';

@Component({
  selector: 'app-trash',
  templateUrl: './trash.component.html',
  styleUrls: ['./trash.component.css']
})
export class TrashComponent implements OnInit {
  private listOfEmails : EmailI[] = []
  private viewArray : string[][] = []

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

    this.parseArray()
    let placer = new InboxComponent()
    placer.place(this.viewArray,5)
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



}
