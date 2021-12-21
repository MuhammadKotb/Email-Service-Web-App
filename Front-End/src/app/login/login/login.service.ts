import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http : HttpClient) { }

  createAccount(accountDetails:string):Observable<string>{
    return this.http.post<string>("http://localhost:8080/createFolder", accountDetails);
  }
  loginToAccount(accountDetails:string):Observable<string>{
    return this.http.post<string>("http://localhost:8080/getFolder", accountDetails);
  }
}
