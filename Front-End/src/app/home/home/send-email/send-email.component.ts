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
  private listOfReceivers : ReceiverI[] = []
  private receiverCount : number = 0
  private viewArray : string[][] = []
  private listPreSize = this.viewArray.length

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



}
