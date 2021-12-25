import { Component, OnInit } from '@angular/core';
import { EmailI } from '../home.component'
import { InboxComponent } from '../inbox/inbox.component';


@Component({
  selector: 'app-draft',
  templateUrl: './draft.component.html',
  styleUrls: ['./draft.component.css']
})
export class DraftComponent implements OnInit {
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
      emailType: '',
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
      emailType: '',
      priority: 'Important'
    }
    var Z : EmailI = {
      senderUsername: '',
      timeSent: "هيخو",
      subject: "birthday",
      body: '',
      owner: '',
      recieverUsername: "otb",
      emailID: '',
      emailType: '',
      priority: 'Non-essential'
    }
    var w : EmailI = {
      senderUsername: '',
      timeSent: "لول",
      subject: "birthday",
      body: '',
      owner: '',
      recieverUsername: "deffo",
      emailID: '',
      emailType: '',
      priority: 'Skipable'
    }

    this.listOfEmails.push(x)
    this.listOfEmails.push(y)
    this.listOfEmails.push(Z)
    this.listOfEmails.push(w)

    this.parseArray()
    let placer = new InboxComponent()
    placer.place(this.viewArray,4)
}
parseArray(){
  for (let email=0; email < this.listOfEmails.length;email++){
    this.viewArray[email] = [] 
    this.viewArray[email][0] = this.listOfEmails[email].recieverUsername
    this.viewArray[email][1] = this.listOfEmails[email].timeSent
    this.viewArray[email][2] = this.listOfEmails[email].subject
  }
}


}