import { Component, OnInit } from '@angular/core';
import { AttachmentI, HomeComponent } from '../home.component';
import { InboxComponent } from '../inbox/inbox.component';
import $ from "jquery"





@Component({
  selector: 'app-send-email',
  templateUrl: './send-email.component.html',
  styleUrls: ['./send-email.component.css']
})
export class SendEmailComponent implements OnInit {
  private listOfReceivers : string[] 
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
    this.viewArray = []
    this.listPreSize = this.viewArray.length
    this.iterationsNum = 3
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
    this.listOfReceivers.push(receiver_input)
    this.listPreSize = this.viewArray.length
    this.viewArray[this.viewArray.length] = []
    this.viewArray[this.viewArray.length-1][0] = receiver_input
    this.viewArray[this.viewArray.length-1][1] = this.viewArray.length.toString()
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





