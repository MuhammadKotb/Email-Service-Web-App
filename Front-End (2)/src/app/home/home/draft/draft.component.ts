import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/login/login/login.component';
import { EmailI } from '../home.component'
import { InboxComponent } from '../inbox/inbox.component';
import {InboxService } from '../inbox/inbox.service';
import { TrashService } from '../trash/trash.service';


@Component({
  selector: 'app-draft',
  templateUrl: './draft.component.html',
  styleUrls: ['./draft.component.css']
})
export class DraftComponent implements OnInit {
  private listOfEmails : EmailI[] 
  private viewArray : string[][] 
  private listPreSize : number
  private iterationsNum : number
  private listOfButtons : NodeList


  constructor(private serveMe1: InboxService, private serveMe2 : TrashService, private placer : InboxComponent  ) { 
    this.listOfEmails = []
    this.viewArray = []
    this.listPreSize = this.viewArray.length
    this.iterationsNum = 5
  }
  

  ngOnInit(): void {
    // var x : EmailI = {
    //   senderUsername: '',
    //   timeSent: "27/9/2001",
    //   subject: "birthday",
    //   body: '',
    //   owner: '',
    //   recieverUsername: "Joe",
    //   emailID: '',
    //   emailType: '',
    //   priority: 'Urgent'
    // }
    // var y : EmailI = {
    //   senderUsername: '',
    //   timeSent: "4/6/2001",
    //   subject: "birthday",
    //   body: '',
    //   owner: '',
    //   recieverUsername: "Meniem",
    //   emailID: '',
    //   emailType: '',
    //   priority: 'Important'
    // }
    // var Z : EmailI = {
    //   senderUsername: '',
    //   timeSent: "هيخو",
    //   subject: "birthday",
    //   body: '',
    //   owner: '',
    //   recieverUsername: "otb",
    //   emailID: '',
    //   emailType: '',
    //   priority: 'Non-essential'
    // }
    // var w : EmailI = {
    //   senderUsername: '',
    //   timeSent: "لول",
    //   subject: "birthday",
    //   body: '',
    //   owner: '',
    //   recieverUsername: "deffo",
    //   emailID: '',
    //   emailType: '',
    //   priority: 'Skipable'
    // }

    // this.listOfEmails.push(x)
    // this.listOfEmails.push(y)
    // this.listOfEmails.push(Z)
    // this.listOfEmails.push(w)


    this.listPreSize = this.viewArray.length
    
    this.listOfButtons = document.querySelectorAll("td  > button")
    this.parseArray()
    this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Edit")
    this.checkClick()
}
parseArray(){
  for (let email=0; email < this.listOfEmails.length;email++){
    this.viewArray[email] = [] 
    this.viewArray[email][0] = this.listOfEmails[email].recieverUsername
    this.viewArray[email][1] = this.listOfEmails[email].timeSent
    this.viewArray[email][2] = this.listOfEmails[email].subject
  }
}

checkClick(){
  var listOfButtons = document.querySelectorAll("td  > button")
    for (var i =  0 ; i < listOfButtons.length ; i++){
      if (i%2){
        listOfButtons[i].addEventListener("click", e =>{
          this.serveMe2?.deleteForever(this.serveMe2.loginUsername,this.listOfEmails[(i-1)/2]).subscribe((data : EmailI[])=> {this.listOfEmails = data; console.log(this.listOfEmails);});
        })
        this.listPreSize = this.viewArray.length
        this.parseArray()
        this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Edit")
      }else{
        listOfButtons[i].addEventListener("click", e =>{
          this.show(this.listOfEmails[(i)/2]);
          });
        
      }
      
    }
}
  show(email: EmailI) {
    throw new Error('Method not implemented.');
  }


}