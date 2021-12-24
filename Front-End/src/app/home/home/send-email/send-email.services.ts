import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class sendEmailService {

  constructor(private http : HttpClient) { }

  postFile(attachment : FormData) : Observable<string>{
     return this.http.post<string>("http://localhost:8080/encodeFile", attachment);
  }
}
