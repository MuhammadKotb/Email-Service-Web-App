import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { HomeComponent } from './home/home/home.component';
import { TrashComponent } from './trash/trash.component';
import { InboxComponent } from './inbox/inbox.component';
import { SendEmailComponent } from './send-email/send-email.component';
import { SentComponent } from './sent/sent.component';
import { DraftComponent } from './draft/draft.component';
import { ContactsComponent } from './contacts/contacts.component';


const routes: Routes = [
  {path:'',component: LoginComponent,outlet:'registeration'},
  {path:'home',component:HomeComponent,outlet:'registeration'},
  {path:'trash',component:TrashComponent,outlet:'branching'},
  {path:'inbox',component:InboxComponent,outlet:'branching'},
  {path:'sendEmail',component:SendEmailComponent,outlet:'branching'},
  {path:'sent',component:SentComponent,outlet:'branching'},
  {path:'draft',component:DraftComponent,outlet:'branching'},
  {path:'contacts',component:ContactsComponent,outlet:'branching'},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
