import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginComponent } from 'src/app/login/login/login.component';
import { EmailI } from '../home.component';
import { FoldersI } from './folders.component';
import { ContactI } from '../contacts/contacts.component';

@Injectable({
  providedIn: 'root'
})
export class FolderService {
  loginUsername = LoginComponent.globalUsername

  constructor(private http : HttpClient) { }
  
  getFolders(loginUsername:string) : Observable<FoldersI[]>{

    return this.http.get<FoldersI[]>("http://localhost:8080/getFolders?username=" + loginUsername);
  }
  
  deleteFolder(loginUsername:string,folderName:string) : Observable<FoldersI[]>{

    return this.http.delete<FoldersI[]>("http://localhost:8080/deleteFolder?username=" + loginUsername + "&folder=" + folderName);
  }

  addFolder(loginUsername:string,folderName:string) : Observable<FoldersI[]>{

    return this.http.post<FoldersI[]>("http://localhost:8080/addFolder?username=" + loginUsername,folderName);
  }
}
