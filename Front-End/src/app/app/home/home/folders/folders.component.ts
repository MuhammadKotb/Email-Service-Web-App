import { Component, OnChanges, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InboxComponent } from '../inbox/inbox.component';
import { EmailI } from '../home.component';

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
  private listOfButtons: NodeListOf<Element>= null

  constructor(private router:Router) { }

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

    this.parseArray()
    let placer = new InboxComponent()
    placer.place(this.viewArray,2,"Open")

    this.listOfButtons = document.querySelectorAll("td  > button")
    console.log(this.listOfButtons)
    for (var i = 0 ; i < this.listOfButtons.length ; i+=2){
      this.listOfButtons[i].addEventListener("click", e =>{
        this.router.navigate(['home/folders/specificFolder']);
    })}
    
  }


  parseArray(){
    for (let folder=0; folder < this.listOfFolders.length; folder++){
      this.viewArray[folder] = []
      this.viewArray[folder][0] = this.listOfFolders[folder].name
    }
  }

  addFolder(){
    this.ngOnInit()
    var folder_input = (<HTMLInputElement>document.getElementById("folder")).value
    var folder : FoldersI = {
      name: folder_input,
      listOfEmails: []
    }
    this.listOfFolders.push(folder)
    this.viewArray.length = 0
    this.viewArray[0] = []
    this.viewArray[0][0] = folder.name
    let placer = new InboxComponent()
    placer.place(this.viewArray,2,"Open")
    
    
  }

  switchToSpecificFolder(){
    this.router.navigate(['home/folders/specificFolder']);
    
  }

}
