import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/login/login/login.component';

export interface AttachmentI{
    encoded: string;
    name: string;
    type: string;
}

export interface EmailI{
  subject : string;
  body : string;
  owner : string;
  senderUsername: string;
  recieverUsername: string;
  emailID: string;
  emailType: string;
  timeSent: string;
  priority: string;
}



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router) { }

  public static globalFilterOption: string = ""
  public static globalFilterText: string = ""

  public static globalSortOption: string = ""
  public static globalSortOrder: string = "true"

  public static globalSearchOption: string = ""
  public static globalSearchText: string = ""

  path:string = ""
  ngOnInit(): void {

    this.router.navigate(['/home/inbox']);

  }

  filter(){
    var e = (<HTMLSelectElement>document.getElementById("filter_menu"))
    HomeComponent.globalFilterOption = e.options[e.selectedIndex].text

    HomeComponent.globalFilterText = (<HTMLInputElement>document.getElementById("filter_text")).value

    console.log(HomeComponent.globalFilterOption)
    console.log(HomeComponent.globalFilterText)

  }

  sort(){
    var e = (<HTMLSelectElement>document.getElementById("sort_menu")) 
    HomeComponent.globalSortOption = e.options[e.selectedIndex].text

    var e1 = (<HTMLSelectElement>document.getElementById("sort_order")) 
    var sortOrder = e1.options[e1.selectedIndex].text
    console.log(sortOrder)

    if(sortOrder == "Descending") {
      HomeComponent.globalSortOrder = "false"
    }
    else{
      HomeComponent.globalSortOrder = "true"
    }

    console.log(HomeComponent.globalSortOption)
    console.log(HomeComponent.globalSortOrder)
  }

  search(){
    var e = (<HTMLSelectElement>document.getElementById("search_menu"))
    HomeComponent.globalSearchOption = e.options[e.selectedIndex].text

    HomeComponent.globalSearchText = (<HTMLInputElement>document.getElementById("search_text")).value

    console.log(HomeComponent.globalSearchOption)
    console.log(HomeComponent.globalSearchText)
  }

  switchToFolders(){
    this.router.navigate(['/home/folders']);
    
  }
  switchToSendEmail(){
    this.router.navigate(['/home/sendEmail']);

  }
  switchToSent(){
    this.router.navigate(['/home/sent']);

  }
  switchToInbox(){
    this.router.navigate(['/home/inbox']);

  }
  switchToTrash(){
    this.router.navigate(['/home/trash']);

  }
  switchToDraft(){
    this.router.navigate(['/home/draft']);

  }
  switchToContacts(){
    this.router.navigate(['/home/contacts']);

  }
  logOut(){
    this.router.navigate(['']);
  }
}
