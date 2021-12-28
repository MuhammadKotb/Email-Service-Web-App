import { Component, OnInit } from '@angular/core';
import { InboxComponent } from '../inbox/inbox.component';
import { EmailI, AttachmentI } from '../home.component';

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
  private listOfReceivers : ReceiverI[] = []
  private receiverCount : number = 0
  private viewArray : string[][] = []
  private listPreSize = this.viewArray.length
  private priority: string = ""
  private subject: string = ""
  private Attachment: AttachmentI = {
    encoded: "",
    name: "",
    type: ""
  }
  private fileObject = new FormData
  
  private message: string ="" 

  constructor() { }

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
    let placer = new InboxComponent()
    placer.place(this.viewArray,3,this.listPreSize,"Delete")
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
