import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router) { }
  path:string = ""
  ngOnInit(): void {
    this.router.navigate([{outlets:{branching:['/home/inbox']}}]);

  }

}
