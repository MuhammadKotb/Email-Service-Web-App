import { Component, IterableDiffers, OnInit } from '@angular/core';
import { EmailI } from '../home.component'
import { InboxComponent } from '../inbox/inbox.component';
import { sendEmailService } from './send-email.services';

@Component({
  selector: 'app-send-email',
  templateUrl: './send-email.component.html',
  styleUrls: ['./send-email.component.css']
})
export class SendEmailComponent implements OnInit {
  private recieverCount : number = 0
  private viewArray : string[][] = []

  
  attachmentUplodad : File[] = [];
  attatchmentSent : FormData = new FormData();


  constructor(private service:sendEmailService) {}

  ngOnInit(): void {
    this.addReciever("Joe")
    this.addReciever("Mn3m")
    this.addReciever("Deffo")
    this.addReciever("Otb")
    let placer = new InboxComponent()
    placer.place(this.viewArray,4)
  }

  uploadFile(input : any){
    this.attachmentUplodad = input.files;
    this.attatchmentSent.append("file", this.attachmentUplodad[0]);
    console.log(this.attatchmentSent.get("file"));
  }

  sendFile(){
    this.service.postFile(this.attatchmentSent).subscribe();
  }

  getFile(){

  }



    

  

  addReciever(reciever: string){
    this.viewArray[this.recieverCount] = []
    this.viewArray[this.recieverCount][0] = reciever
    this.viewArray[this.recieverCount][1] = ((this.recieverCount++)+1).toString()
  }

}

