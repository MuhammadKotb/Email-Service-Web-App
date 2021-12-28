import { Component, OnInit } from '@angular/core';
import { AttachmentI, HomeComponent } from '../home.component';
import { InboxComponent } from '../inbox/inbox.component';

export interface ReceiverI{
  username: string
  num: number
}


@Component({
  selector: 'app-send-email',
  templateUrl: './send-email.component.html',
  styleUrls: ['./send-email.component.css']
})
export class SendEmailComponent implements OnInit {
  private listOfReceivers : ReceiverI[] 
  private receiverCount : number 
  private viewArray : string[][] 
  private listPreSize : number
  private iterationsNum : number
  private priority: string 
  private subject: string 
  private Attachment: AttachmentI 
  private fileObject = new FormData
  private message: string 

  constructor(private placer : InboxComponent  ) { 
    this.listOfReceivers = []
    this.receiverCount = 0
    this.viewArray = []
    this.listPreSize = this.viewArray.length
    this.iterationsNum = 0
    this.priority = ""
    this.subject = ""
    this.message = ""
    this.Attachment = {
      encoded: "",
      name: "",
      type: ""
    }
    HomeComponent.pageIndicator = "Send Email"
  }


  ngOnInit(): void {

  }


  showReceiver(){
    var receiver_input = (<HTMLInputElement>document.getElementById("receiver")).value
    var receiver : ReceiverI = {
      username: receiver_input,
      num: this.receiverCount
    }
    this.listOfReceivers.push(receiver)
    this.listPreSize = this.viewArray.length
    this.viewArray.length = 0
    this.viewArray[0] = []
    this.viewArray[0][0] = receiver.username
    this.viewArray[0][1] = ((this.receiverCount++)+1).toString()
    this.iterationsNum = this.receiverCount
    this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Delete")
  }

  getPriority(){
    var e = (<HTMLSelectElement>document.getElementById("priority_select"))
    this.priority = e.options[e.selectedIndex].text

  }

  getSubject(){
    this.subject = (<HTMLInputElement>document.getElementById("subject")).value
    console.log(this.subject)

  }

  getAttachment(input : any){
    var files: File[]
    files = input.files
    for(let i = 0; i <files.length; i++){
      this.fileObject.append("file", files[i])
    }

  }

  getMessage(){
    this.message = (<HTMLInputElement>document.getElementById("message")).value
    console.log(this.message)
  }

  sendEmail(){

    

  }


}





