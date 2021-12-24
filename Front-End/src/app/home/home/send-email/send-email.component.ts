import { Component, OnInit } from '@angular/core';
import { sendEmailService } from './send-email.services';

@Component({
  selector: 'app-send-email',
  templateUrl: './send-email.component.html',
  styleUrls: ['./send-email.component.css']
})
export class SendEmailComponent implements OnInit {

  attachmentUploaded : File;
  attachmentSend : FormData = new FormData();


  constructor(private service:sendEmailService) {}

  ngOnInit(): void {
  }

  uploadFile(attachment : File){
    this.attachmentUploaded = attachment;
    console.log(this.attachmentUploaded);
    this.attachmentSend.append("file", this.attachmentUploaded, this.attachmentUploaded.name);
  }
  postFile(){
    this.service.postFile(this.attachmentSend).subscribe((data : string)=>{
      console.log(data);
    });
    
  }
}
