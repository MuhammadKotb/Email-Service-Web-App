import { Component, OnInit } from '@angular/core';
import { InboxComponent } from '../../inbox/inbox.component';
import { EmailI } from '../../home.component';

@Component({
  selector: 'app-specific-folder',
  templateUrl: './specific-folder.component.html',
  styleUrls: ['./specific-folder.component.css']
})
export class SpecificFolderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }


}
