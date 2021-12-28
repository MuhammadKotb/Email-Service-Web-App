import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginComponent } from 'src/app/login/login/login.component';
import { EmailI, HomeComponent } from './home/home.component';


@Injectable({
    providedIn: 'root'
  })
  export class HomeService {
    loginUsername = LoginComponent.globalUsername
    filterOption = HomeComponent.globalFilterOption
    filterText = HomeComponent.globalFilterText
    sortOption = HomeComponent.globalSortOption
    sortOrder = HomeComponent.globalSortOrder
    searchOption = HomeComponent.globalSearchOption
    searchText = HomeComponent.globalSearchText
  
    constructor(private http : HttpClient) { }
  
    filter(loginUsername:string,filterOption:string, filterText:string) : Observable<EmailI[]>{
  
      return this.http.get<EmailI[]>("http://localhost:8080/filter?username=" + loginUsername + "&filteroption=" + filterOption + "&filtertext=" + filterText);
    }
    sort(loginUsername:string,sortOption:string, sortOrder: string) : Observable<EmailI[]>{
  
        return this.http.get<EmailI[]>("http://localhost:8080/sort?username=" + loginUsername + "&sortoption=" + sortOption + "&sortorder=" + sortOrder);
      }

    search(loginUsername:string,searchOption:string, searchText:string) : Observable<EmailI[]>{
  
        return this.http.get<EmailI[]>("http://localhost:8080/search?username=" + loginUsername + "&searchoption=" + searchOption + "&searchtext=" + searchText);
      }
  }