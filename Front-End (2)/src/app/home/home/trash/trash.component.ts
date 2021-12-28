import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/login/login/login.component';
import { EmailI } from '../home.component';
import { InboxComponent } from '../inbox/inbox.component';
import { InboxService } from '../inbox/inbox.service';
import { TrashService } from './trash.service';
import $ from "jquery"


@Component({
  selector: 'app-trash',
  templateUrl: './trash.component.html',
  styleUrls: ['./trash.component.css']
})
export class TrashComponent implements OnInit {
  private listOfEmails : EmailI[] 
  private viewArray : string[][] 
  private listPreSize : number
  private iterationsNum : number
  private listOfButtons : NodeList

  constructor(private serveMe1: InboxService, private serveMe2: TrashService, private placer : InboxComponent  ) { 
    this.listOfEmails = []
    this.viewArray = []
    this.listPreSize = this.viewArray.length
    this.iterationsNum = 5
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

    // this.serveMe1?.getEmails(LoginComponent.globalUsername).subscribe((data : EmailI[])=> {this.listOfEmails = data; console.log(this.listOfEmails);});
    this.listPreSize  = this.viewArray.length

    this.parseArray()
    this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Restore")
    this.listOfButtons = document.querySelectorAll("td  > button")

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
  for (var i =  0 ; i < this.listOfButtons.length ; i++){

    if (i%2){
      this.listOfButtons[i].addEventListener("click",$.proxy(this.deleteClicked,this));
    }else{
      this.listOfButtons[i].addEventListener("click",$.proxy(this.restoreClicked,this));
    }
    
  }
}

deleteClicked(e: any){
  try{
  //   const buttonNum = parseInt(e.target.id)
  //     this.serveMe1?.delete(this.serveMe1.loginUsername,this.listOfEmails[(buttonNum-1)/2]).subscribe((data : EmailI[])=> {
  //       this.listOfEmails = data; 
  //       console.log(this.listOfEmails);
  //   this.listPreSize = this.viewArray.length
  //   this.parseArray()
  //   this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Restore")
  // });
  }catch (error){
    console.log(error)
  }
}
  restoreClicked(e: any){
    try{
      // const buttonNum = parseInt(e.target.id)
      // this.serveMe2?.restore(this.serveMe2.loginUsername,this.listOfEmails[buttonNum/2]).subscribe((data : EmailI)=> {var email = data; console.log(this.listOfEmails);
      //     });
    }catch (error){
      console.log(error)
    }
  }



}
