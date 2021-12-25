import { Component, IterableDiffers, OnInit } from '@angular/core';
import { EmailI } from '../home.component'
import { InboxComponent } from '../inbox/inbox.component';


@Component({
  selector: 'app-send-email',
  templateUrl: './send-email.component.html',
  styleUrls: ['./send-email.component.css']
})
export class SendEmailComponent implements OnInit {
  private recieverCount : number = 0
  private viewArray : string[][] = []

  constructor() { }

  ngOnInit(): void {
    this.addReciever("Joe")
    this.addReciever("Mn3m")
    this.addReciever("Deffo")
    this.addReciever("Otb")
    let placer = new InboxComponent()
    placer.place(this.viewArray,4)

  }

  addReciever(reciever: string){
    this.viewArray[this.recieverCount] = []
    this.viewArray[this.recieverCount][0] = reciever
    this.viewArray[this.recieverCount][1] = ((this.recieverCount++)+1).toString()
  }

  

}

