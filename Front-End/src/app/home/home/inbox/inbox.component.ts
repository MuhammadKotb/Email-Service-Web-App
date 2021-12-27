import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/login/login/login.component';
import { EmailI } from '../home.component'
import { InboxService } from './inbox.service';


@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})

export class InboxComponent implements OnInit {
  private listOfEmails : EmailI[] = []
  private viewArray : string[][] = []
  private serveMe: InboxService | undefined
  private listPreSize = this.viewArray.length
  private iterationsNum = 5

  constructor() { 
  }

  ngOnInit(): void {    
    // var x : EmailI = {
    //   senderUsername: "Joe",
    //   timeSent: "27/9/2001",
    //   subject: "birthday",
    //   body: '',
    //   owner: '',
    //   recieverUsername: '',
    //   emailID: '',
    //   emailType: '',
    //   priority: 'Urgent'
    // }
    // var y : EmailI = {
    //   senderUsername: "Meniem",
    //   timeSent: "4/6/2001",
    //   subject: "birthday",
    //   body: '',
    //   owner: '',
    //   recieverUsername: '',
    //   emailID: '',
    //   emailType: '',
    //   priority: 'Important'
    // }
    
    // var z : EmailI = {
    //   senderUsername: "Qotb",
    //   timeSent: "هيخو",
    //   subject: "birthday",
    //   body: '',
    //   owner: '',
    //   recieverUsername: '',
    //   emailID: '',
    //   emailType: '',
    //   priority: 'Non-essential'
    // }
    // var w : EmailI = {
    //   senderUsername: "Deffo",
    //   timeSent: "لول",
    //   subject: "birthday",
    //   body: '',
    //   owner: '',
    //   recieverUsername: '',
    //   emailID: '',
    //   emailType: '',
    //   priority: 'Skippable'
    // }

    // var q : EmailI = {
    //   senderUsername: "Ahmed",
    //   timeSent: "23/12/21",
    //   subject: "birthday",
    //   body: '',
    //   owner: '',
    //   recieverUsername: '',
    //   emailID: '',
    //   emailType: '',
    //   priority: 'Important'
    // }

    // this.listOfEmails.push(x)
    // this.listOfEmails.push(y)
    // this.listOfEmails.push(z)
    // this.listOfEmails.push(w)
    this.serveMe?.getEmails(LoginComponent.globalUsername).subscribe((data : EmailI[])=> {this.listOfEmails = data; console.log(this.listOfEmails);});
    this.listPreSize = this.viewArray.length
    this.parseArray()
    this.place(this.viewArray,5,this.listPreSize)
    this.checkClick()
}
  
parseArray(){
  for (let email=0; email < this.listOfEmails.length;email++){
    this.viewArray[email] = [] 
    this.viewArray[email][0] = this.listOfEmails[email].senderUsername
    this.viewArray[email][1] = this.listOfEmails[email].timeSent
    this.viewArray[email][2] = this.listOfEmails[email].subject
    this.viewArray[email][3] = this.listOfEmails[email].priority
  }
}

place(viewArray : string[][], iterationsNum: number,listPreSize: number,btnName: string = "Show"){
  var body = document.getElementById("mybody")
  for (let i=0;i<listPreSize;i++)
    body?.removeChild(body?.childNodes[0])

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
            node2.appendChild(node3);
          }
          var textNode2 = document.createTextNode("Delete");
          var node4 = document.createElement("button");
          node4.style.marginRight = "5px"
          node4.appendChild(textNode2);
          node4.type = "button";
          node2.appendChild(node4);
        }
        node.appendChild(node2);
    }
    document.getElementById("mybody")?.appendChild(node);
}
}
checkClick(){
  var listOfButtons = document.querySelectorAll("td  > button")
    for (var i =  0 ; i < listOfButtons.length ; i++){
      if (i%2){
        listOfButtons[i].addEventListener("click", e =>{
          this.serveMe?.delete(this.serveMe.loginUsername,this.listOfEmails[(i-1)/2]).subscribe((data : EmailI[])=> {this.listOfEmails = data; console.log(this.listOfEmails);});
        })
        this.listPreSize = this.viewArray.length
        this.parseArray()
        this.place(this.viewArray,5,this.listPreSize)
      }else{
        listOfButtons[i].addEventListener("click", e =>{
          this.show(this.listOfEmails[(i)/2]);
        })
        
      }
      
    }
}
    
  show(email:EmailI){
    //where we show email
}

}
