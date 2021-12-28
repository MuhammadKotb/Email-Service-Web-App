import { Component, OnInit } from '@angular/core';
import { InboxComponent } from '../../inbox/inbox.component';
import { EmailI, HomeComponent } from '../../home.component';

@Component({
  selector: 'app-specific-folder',
  templateUrl: './specific-folder.component.html',
  styleUrls: ['./specific-folder.component.css']
})
export class SpecificFolderComponent implements OnInit {

  constructor() { 
    HomeComponent.pageIndicator = "Specific Folder"
  }

  ngOnInit(): void {
  }


}
