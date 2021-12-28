  import { Component, OnInit } from '@angular/core';
  import { LoginComponent } from 'src/app/login/login/login.component';
  import { EmailI } from '../home.component'
  import { InboxComponent } from '../inbox/inbox.component';
  import { InboxService } from '../inbox/inbox.service';
  import $ from "jquery"



  @Component({
    selector: 'app-sent',
    templateUrl: './sent.component.html',
    styleUrls: ['./sent.component.css']
  })
  export class SentComponent implements OnInit {
    private listOfEmails : EmailI[] 
    private viewArray : string[][] 
    private listPreSize : number
    private iterationsNum : number
    private listOfButtons : NodeList


    constructor(private serveMe: InboxService, private placer : InboxComponent  ) { 
      this.listOfEmails = []
      this.viewArray = []
      this.listPreSize = this.viewArray.length
      this.iterationsNum = 4
    }

    ngOnInit(): void {
      var x : EmailI = {
        senderUsername: 'vfsf',
        timeSent: "27/9/2001",
        subject: "birthday",
        body: 'vfvsv',
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

      // this.serveMe?.getEmails(LoginComponent.globalUsername).subscribe((data : EmailI[])=> {this.listOfEmails = data; console.log(this.listOfEmails);});
      this.listPreSize  = this.viewArray.length

      this.parseArray()
      this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize)
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
        this.listOfButtons[i].addEventListener("click",$.proxy(this.showClicked,this));
      }
      
    }
}


    closeEmailPopup(){
      (<HTMLElement>document.getElementById("email-popup")).style.display = "none";
  } 
      
    show(email:EmailI){
      var contentsToBeDeleted = document.querySelectorAll("div > p");
      for (var i = 0; i<contentsToBeDeleted.length; i++)
      switch(i){
        case 0 : document.getElementById("sender-container")?.removeChild(document.getElementById("sender-container")?.childNodes[1])
                break
        case 1 : document.getElementById("date-container")?.removeChild(document.getElementById("date-container")?.childNodes[1])
                break
        case 2 : document.getElementById("subject-container")?.removeChild(document.getElementById("subject-container")?.childNodes[1])
                break
        case 3 : document.getElementById("message-container")?.removeChild(document.getElementById("message-container")?.childNodes[1])
                break
      }
      var emailContents = document.querySelectorAll("div.email-container > div");
      for (var i = 0; i<emailContents.length; i++){
        var node = document.createElement("P")
        node.style.marginTop  = "0"
        var textNode = document.createTextNode(email.senderUsername)
        var destinationNode = document.getElementById("sender-container")
        switch(i){
          case 0 : node.id = "sender"
                  break
          case 1 : node.id = "date"
                  textNode = document.createTextNode(email.timeSent)
                  destinationNode = document.getElementById("date-container")
                  break
          case 2 : node.id = "subject"
                  textNode = document.createTextNode(email.subject)
                  destinationNode = document.getElementById("subject-container")
                  break
          case 3 : node.id = "message"
                   textNode = document.createTextNode(email.body)
                   destinationNode = document.getElementById("message-container")
                   break
        }
        node.appendChild(textNode)
        destinationNode?.appendChild(node)
        
      }
      (<HTMLElement>document.getElementById("email-popup")).style.display = "block"

  }
  deleteClicked(e: any){
    try{
    //   const buttonNum = parseInt(e.target.id)
    //   this.serveMe?.delete(this.serveMe.loginUsername,this.listOfEmails[(buttonNum-1)/2]).subscribe((data : EmailI[])=> {
    //     this.listOfEmails = data; 
    //     console.log(this.listOfEmails)
    // this.listPreSize = this.viewArray.length
    // this.parseArray()
    // this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize)
    //   })
    }catch (error){
      console.log(error)
    }
  }
    showClicked(e: any){
      try{
        const buttonNum = parseInt(e.target.id)
        this.show(this.listOfEmails[buttonNum/2]);
      }catch (error){
        console.log(error)
      }
    }
  

}
