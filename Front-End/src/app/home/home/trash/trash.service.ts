import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginComponent } from 'src/app/login/login/login.component';
import { EmailI } from '../home.component';

@Injectable({
  providedIn: 'root'
})
export class TrashService {
  loginUsername = LoginComponent.globalUsername

  constructor(private http : HttpClient) { }

  restore(loginUsername:string,email:EmailI) : Observable<EmailI>{

    return this.http.post<EmailI>("http://localhost:8080/restore?username=" + loginUsername, email);

  }

  deleteForever(loginUsername:string,email:EmailI) : Observable<EmailI[]>{

    return this.http.delete<EmailI[]>("http://localhost:8080/deleteForever?username=" + loginUsername, email);

  }
  
  
}
