import { Component, OnInit } from '@angular/core';
import { sendEmailService } from './send-email.services';

@Component({
  selector: 'app-send-email',
  templateUrl: './send-email.component.html',
  styleUrls: ['./send-email.component.css']
})
export class SendEmailComponent implements OnInit {

  attachmentSend : FormData = new FormData();
  attachmentUplodad : File[] = [];


  constructor(private service:sendEmailService) {}

  ngOnInit(): void {
  }


  uploadFile(input : any){
    for(let i = 0; i < input.files.length; i++){
      this.attachmentSend.append("file", input.files.item(i));
    }
    console.log(this.attachmentSend);
  }
 
  postFile(){

    
   
    this.service.postFile(this.attachmentSend).subscribe((data : string)=>{
      console.log(data);
    })

  }
}
