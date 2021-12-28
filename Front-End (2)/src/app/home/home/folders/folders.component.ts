import { Component, OnChanges, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InboxComponent } from '../inbox/inbox.component';
import { EmailI } from '../home.component';
import { InboxService } from '../inbox/inbox.service';
import { FolderService } from './folders.service';
import { LoginComponent } from 'src/app/login/login/login.component';

export interface FoldersI{
  name: string
  listOfEmails: EmailI[]
}

@Component({
  selector: 'app-folders',
  templateUrl: './folders.component.html',
  styleUrls: ['./folders.component.css']
})
export class FoldersComponent implements OnInit{
  private listOfFolders : FoldersI[] 
  private viewArray : string[][] 
  private listPreSize : number
  private iterationsNum : number
  private listOfButtons : NodeList

  constructor(private router:Router,private serveMe: FolderService,private placer : InboxComponent ) { 
    this.listOfFolders = []
    this.viewArray = []
    this.listPreSize = this.viewArray.length
    this.iterationsNum = 2

  }



  ngOnInit(): void {

    var x : FoldersI = {
      name: "Joe",
      listOfEmails: []
    }
    var y : FoldersI = {
      name: "Mn3m",
      listOfEmails: []
   }

    this.listOfFolders.push(x)
    this.listOfFolders.push(y)
    console.log(this.listOfButtons)

  // this.serveMe?.getFolders(LoginComponent.globalUsername).subscribe((data : FoldersI[])=> {this.listOfFolders = data; console.log(this.listOfFolders);});
    this.listPreSize = this.viewArray.length
    this.parseArray()
    this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Open")
    this.listOfButtons = document.querySelectorAll("td  > button")
    this.checkClick()
      
    
  }


  parseArray(){
    for (let folder=0; folder < this.listOfFolders.length; folder++){
      this.viewArray[folder] = []
      this.viewArray[folder][0] = this.listOfFolders[folder].name
    }
  }

  addFolder(){
    var folder_input = (<HTMLInputElement>document.getElementById("folder")).value
    var folder : FoldersI = {
      name: folder_input,
      listOfEmails: []
    }
    this.serveMe.deleteFolder(this.serveMe.loginUsername,folder.name).subscribe((data : FoldersI[])=> {this.listOfFolders = data;});
    this.listPreSize = this.viewArray.length
    this.parseArray()
    this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Open")
    while (1){
      console.log(1)
      this.checkClick()
    }
  }

  checkClick(){
    console.log("I am in click")
    for (var i =  0 ; i < this.listOfButtons.length ; i++){
      if (i%2){
        this.listOfButtons[i].addEventListener("click", e =>{
            this.serveMe.deleteFolder(this.serveMe.loginUsername,this.listOfFolders[(i-1)/2].name).subscribe((data : FoldersI[])=> {
            this.listOfFolders = data;
            this.listPreSize = this.viewArray.length
            this.parseArray()
            this.placer.place(this.viewArray,this.iterationsNum,this.listPreSize,"Open")
          });
        })   
      }else{
        this.listOfButtons[i].addEventListener("click", e =>{
          this.router.navigate(['home/folders/specificFolder']);
          });
        }
        
      }
  }
}

