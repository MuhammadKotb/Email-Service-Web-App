import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from 'src/app/login/login/login.component';
import { EmailI, HomeComponent } from '../home.component'
import { InboxComponent } from '../inbox/inbox.component';
import {InboxService } from '../inbox/inbox.service';
import { TrashService } from '../trash/trash.service';
import $ from "jquery"
import { DraftService } from './draft.service';


@Component({
  selector: 'app-draft',
  templateUrl: './draft.component.html',
  styleUrls: ['./draft.component.css']
})
export class DraftComponent implements OnInit {
  public static listOfEmails : EmailI[] 
  private viewArray : string[][] 
  private listPreSize : number
  private iterationsNum : number
  private listOfButtons : NodeList


  constructor(private router : Router, private serveMe1: DraftService, private placer : InboxComponent  ) { 
    DraftComponent.listOfEmails = []
    this.viewArray = []
    this.listPreSize = this.viewArray.length
    this.iterationsNum = 4
    HomeComponent.pageIndicator = "Draft"

  }
  

  ngOnInit(): void {
    // var x : EmailI = {
    //   senderUsername: '',
    //   timeSentString: "27/9/2001",
    //   subject: "birthday",
    //   body: '',
    //   owner: '',
    //   receiversUsernames: ["Joe"],
    //   emailID: '',
    //   emailType: '',
    //   priority: 'Urgent'
    // }
    // var y : EmailI = {
    //   senderUsername: '',
    //   timeSentString: "4/6/2001",
    //   subject: "birthday",
    //   body: '',
    //   owner: '',
    //   receiversUsernames: ["Meniem"],
    //   emailID: '',
    //   emailType: '',
    //   priority: 'Important'
    // }
    // var Z : EmailI = {
    //   senderUsername: '',
    //   timeSentString: "هيخو",
    //   subject: "birthday",
    //   body: '',
    //   owner: '',
    //   receiversUsernames: ["otb"],
    //   emailID: '',
    //   emailType: '',
    //   priority: 'Non-essential'
    // }
    // var w : EmailI = {
    //   senderUsername: '',
    //   timeSentString: "لول",
    //   subject: "birthday",
    //   body: '',
    //   owner: '',
    //   receiversUsernames: ["deffo"],
    //   emailID: '',
    //   emailType: '',
    //   priority: 'Skipable'
    // }

    // DraftComponent.listOfEmails.push(x)
    // DraftComponent.listOfEmails.push(y)
    // DraftComponent.listOfEmails.push(Z)
    // DraftComponent.listOfEmails.push(w)

    this.serveMe1.getDraft(LoginComponent.globalUsername).subscribe((data : EmailI[])=> {
      DraftComponent.listOfEmails = data;
       console.log(DraftComponent.listOfEmails);
       this.listPreSize = this.viewArray.length
       this.parseArray()
       this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Edit")
       this.listOfButtons = document.querySelectorAll("td  > button")
       this.checkClick()});
}
parseArray(){
  for (let email=0; email < DraftComponent.listOfEmails.length;email++){
    this.viewArray[email] = [] 
    this.viewArray[email][0] = DraftComponent.listOfEmails[email].receiversUsernames.toString()
    this.viewArray[email][1] = DraftComponent.listOfEmails[email].timeSentString
    this.viewArray[email][2] = DraftComponent.listOfEmails[email].subject
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
    //   const buttonNum = parseInt(e.target.id)
    //   this.serveMe2?.deleteForever(this.serveMe2.loginUsername,DraftComponent.listOfEmails[(buttonNum-1)/2]).subscribe((data : EmailI[])=> {
    //     DraftComponent.listOfEmails = data;
    //      console.log(DraftComponent.listOfEmails)
    // this.listPreSize = this.viewArray.length
    // this.parseArray()
    // this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Edit")
  // });
    }catch (error){
      console.log(error)
    }
  }
    editClicked(e: any){
      try{
        console.log(DraftComponent.listOfEmails)
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
