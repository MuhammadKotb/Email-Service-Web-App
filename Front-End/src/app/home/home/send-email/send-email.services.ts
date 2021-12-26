import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Attachmnet } from './send-email.component';

@Injectable({
  providedIn: 'root'
})
export class sendEmailService {

  constructor(private http : HttpClient) { }

  postFile(attachment : FormData){
     return this.http.post("http://localhost:8080/attachment", attachment);
  }

  getAttachment() : Observable<Attachmnet>{
    return this.http.get<Attachmnet>("http://localhost:8080/getAttachment");
  }
  
}
