import { Component, OnInit } from '@angular/core';
import { EmailI } from '../home.component'


@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})

export class InboxComponent implements OnInit {
  private listOfEmails : EmailI[] = []
  private viewArray : string[][] = []

  constructor() { 
  }

  ngOnInit(): void {
    var x : EmailI = {
      senderUsername: "Joe",
      timeSent: "27/9/2001",
      subject: "birthday",
      body: '',
      owner: '',
      recieverUsername: '',
      emailID: '',
      emailType: '',
      priority: 'Urgent'
    }
    var y : EmailI = {
      senderUsername: "Meniem",
      timeSent: "4/6/2001",
      subject: "birthday",
      body: '',
      owner: '',
      recieverUsername: '',
      emailID: '',
      emailType: '',
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
      emailType: '',
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
      emailType: '',
      priority: 'Skipable'
    }

    this.listOfEmails.push(x)
    this.listOfEmails.push(y)
    this.listOfEmails.push(Z)
    this.listOfEmails.push(w)

    this.parseArray()
    // width: 300px;
    // text-align: center;
    // padding: 7px;
    // margin: 50px;
    this.place(this.viewArray,5)
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

place(viewArray : string[][],iterationsNum: number,btnName: "Show" | "Send Email" | "Delete" = "Show"){
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
            node2.appendChild(node3);
          }
          var textNode2 = document.createTextNode("Delete");
          var node4 = document.createElement("button");
          node4.style.marginRight = "5px"
          node4.appendChild(textNode2);
          node2.appendChild(node4);
        }
        node.appendChild(node2);
    }
    document.getElementById("mybody")?.appendChild(node);
}
}

}