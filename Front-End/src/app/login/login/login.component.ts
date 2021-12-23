import { HomeComponent } from './../../home/home/home.component';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router,private server: LoginService, private home :HomeComponent) { }

  ngOnInit(): void {
  }
  create(){
    var username :string = (<HTMLInputElement> document.getElementById("username")).value;
    var password :string = (<HTMLInputElement> document.getElementById("password")).value;
    var container :string;
    this.server.createAccount(username.concat("$").concat(password)).subscribe((response:string)=>{
      container = response;
      console.log(container)
      if(container.toUpperCase() == "CREATED FOLDER SUCCESSFULLY"){
        this.router.navigate([{outlets:{registeration:['/home']}}]);
      }else {
        alert("These username and password already exists")
      }
    });
  }

  login(){
    var username :string = (<HTMLInputElement> document.getElementById("username")).value;
    var password :string = (<HTMLInputElement> document.getElementById("password")).value;
    var container :string;

    this.server.loginToAccount(username.concat("$").concat(password)).subscribe((response:string)=>{
      container = response;
      console.log(container)
      if(container.toUpperCase() == "COULD NOT FIND FOLDER BY THIS NAME"){
        alert("There is no account by such credintials");
      }else{
        this.home.path=container;
        this.router.navigate([{outlets:{registeration:['/home']}}]);
      }
    });

  }
}
