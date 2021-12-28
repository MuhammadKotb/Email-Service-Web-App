import { Component, OnInit } from '@angular/core';
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

  constructor(private placer : InboxComponent  ) { 
    this.listOfReceivers = []
    this.receiverCount = 0
    this.viewArray = []
    this.listPreSize = this.viewArray.length
    this.iterationsNum = 0
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



}
