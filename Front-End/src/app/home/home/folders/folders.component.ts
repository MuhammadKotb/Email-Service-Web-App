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
  private listOfFolders : FoldersI[] = []
  private viewArray : string[][] = []
  private listOfButtons: NodeListOf<Element> | undefined
  private listPreSize = this.viewArray.length
  private serveMe : FolderService | undefined
  private placer : InboxComponent | undefined


  constructor(private router:Router) { }

  ngOnInit(): void {

  //   var x : FoldersI = {
  //     name: "Joe",
  //     listOfEmails: []
  //   }
  //   var y : FoldersI = {
  //     name: "Mn3m",
  //     listOfEmails: []
  //  }

  //   this.listOfFolders.push(x)
  //   this.listOfFolders.push(y)

  this.serveMe?.getFolders(LoginComponent.globalUsername).subscribe((data : FoldersI[])=> {this.listOfFolders = data; console.log(this.listOfFolders);});
  this.listPreSize = this.viewArray.length
    this.parseArray()
    this.placer?.place(this.viewArray,2,this.listPreSize,"Open")
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
    this.listOfFolders.push(folder)
    this.viewArray.length = 0
    this.viewArray[0] = []
    this.viewArray[0][0] = folder.name
    this.placer?.place(this.viewArray,2,this.listPreSize,"Open")
    
    
  }


  checkClick(){
    var listOfButtons = document.querySelectorAll("td  > button")
      for (var i =  0 ; i < listOfButtons.length ; i++){
        if (i%2){
          listOfButtons[i].addEventListener("click", e =>{
            this.serveMe?.deleteFolder(this.serveMe.loginUsername,this.listOfFolders[(i-1)/2].name).subscribe((data : FoldersI[])=> {this.listOfFolders = data;});
          })
          this.listPreSize = this.viewArray.length
          this.parseArray()
          this.placer?.place(this.viewArray,5,this.listPreSize,"Open")
        }else{
          listOfButtons[i].addEventListener("click", e =>{
            this.router.navigate(['home/folders/specificFolder']);
            });
          }
          
        }
        
      }
  }

