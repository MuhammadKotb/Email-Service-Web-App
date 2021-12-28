import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from 'src/app/login/login/login.component';
import { EmailI, HomeComponent } from '../home.component'
import { InboxComponent } from '../inbox/inbox.component';
import {InboxService } from '../inbox/inbox.service';
import { TrashService } from '../trash/trash.service';
import $ from "jquery"


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


  constructor(private router : Router, private serveMe1: InboxService, private serveMe2 : TrashService, private placer : InboxComponent  ) { 
    this.listOfEmails = []
    this.viewArray = []
    this.listPreSize = this.viewArray.length
    this.iterationsNum = 4
    HomeComponent.pageIndicator = "Draft"

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

    // this.serveMe1?.getEmails(LoginComponent.globalUsername).subscribe((data : EmailI[])=> {this.listOfEmails = data; console.log(this.listOfEmails);});
    this.listPreSize = this.viewArray.length
    this.parseArray()
    this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Edit")
    this.listOfButtons = document.querySelectorAll("td  > button")
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
  for (var i =  0 ; i < this.listOfButtons.length ; i++){

    if (i%2){
      this.listOfButtons[i].addEventListener("click",$.proxy(this.deleteClicked,this));
    }else{
      this.listOfButtons[i].addEventListener("click",$.proxy(this.editClicked,this));
    }
    
  }
}


  deleteClicked(e: any){
    try{
      const buttonNum = parseInt(e.target.id)
      this.serveMe2?.deleteForever(this.serveMe2.loginUsername,this.listOfEmails[(buttonNum-1)/2]).subscribe((data : EmailI[])=> {
        this.listOfEmails = data;
         console.log(this.listOfEmails)
    this.listPreSize = this.viewArray.length
    this.parseArray()
    this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Edit")
  });
    }catch (error){
      console.log(error)
    }
  }
    editClicked(e: any){
      try{
        console.log(this.listOfEmails)
        const buttonNum = parseInt(e.target.id)
        this.showInSendEmail()
      }catch (error){
        console.log(error)
      }
    }

    showInSendEmail(){
      this.router.navigate(['/home/sendEmail']);
    }

}
