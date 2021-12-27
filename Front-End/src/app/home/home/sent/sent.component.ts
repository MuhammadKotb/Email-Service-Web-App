import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/login/login/login.component';
import { EmailI } from '../home.component'
import { InboxComponent } from '../inbox/inbox.component';
import { InboxService } from '../inbox/inbox.service';


@Component({
  selector: 'app-sent',
  templateUrl: './sent.component.html',
  styleUrls: ['./sent.component.css']
})
export class SentComponent implements OnInit {
  private listOfEmails : EmailI[] = []
  private viewArray : string[][] = []
  private listPreSize : number  = this.viewArray.length
  private placer = new InboxComponent()


  constructor(private serveMe:InboxService) { 
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

    this.serveMe?.getEmails(LoginComponent.globalUsername).subscribe((data : EmailI[])=> {this.listOfEmails = data; console.log(this.listOfEmails);});
    this.listPreSize  = this.viewArray.length
    this.parseArray()
    this.placer.place(this.viewArray,4,this.listPreSize)
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
          this.serveMe?.delete(LoginComponent.globalUsername,this.listOfEmails[(i-1)/2]).subscribe((data : EmailI[])=> {this.listOfEmails = data; console.log(this.listOfEmails);});
        })
        this.listPreSize = this.viewArray.length
        this.parseArray()
        this.placer.place(this.viewArray,4,this.listPreSize)
    }else{
        listOfButtons[i].addEventListener("click", e =>{
          this.serveMe?.show(LoginComponent.globalUsername,this.listOfEmails[(i-1)/2]).subscribe((data : EmailI)=> {var email = data; console.log(this.listOfEmails);
          this.show(email);
          });
        })
        
      }
      
    }
}

  show(email:EmailI){
    //
  }



}
