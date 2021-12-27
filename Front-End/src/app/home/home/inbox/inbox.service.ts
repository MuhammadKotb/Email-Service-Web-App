import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginComponent } from 'src/app/login/login/login.component';
import { EmailI } from '../home.component';

@Injectable({
  providedIn: 'root'
})
export class InboxService {
  loginUsername = LoginComponent.globalUsername

  constructor(private http : HttpClient) { }

  getEmails(loginUsername:string) : Observable<EmailI[]>{

    return this.http.get<EmailI[]>("http://localhost:8080/getEmails?username=" + loginUsername);
  }
  delete(loginUsername:string,email:EmailI) : Observable<EmailI[]>{

    return this.http.post<EmailI[]>("http://localhost:8080/delete?username=" + loginUsername, email);
  }
  show(loginUsername:string,email:EmailI) : Observable<EmailI>{

    return this.http.post<EmailI>("http://localhost:8080/show?username=" + loginUsername, email);

  }

  
  
}
