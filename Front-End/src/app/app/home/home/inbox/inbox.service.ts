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

    return this.http.post<EmailI[]>("http://localhost:8080/getEmails", loginUsername);
  }
  loginToAccount(accountDetails:string) : Observable<string>{

    return this.http.post("http://localhost:8080/getProfile", accountDetails, {responseType : "text"});
  }
}
