import { Component, Input, OnInit } from '@angular/core';
import { sendEmailService } from './send-email.services';

export interface Attachment {
  
}

@Component({
  selector: 'app-send-email',
  templateUrl: './send-email.component.html',
  styleUrls: ['./send-email.component.css']
})
export class SendEmailComponent implements OnInit {

  
  attachmentUplodad : File[] = [];
  attatchmentSent : FormData = new FormData();


  constructor(private service:sendEmailService) {}

  ngOnInit(): void {

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




}
