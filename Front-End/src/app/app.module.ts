import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login/login.component';
import { HomeComponent } from './home/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { TrashComponent } from './home/home/trash/trash/trash.component';
import { InboxComponent } from './home/home/inbox/inbox/inbox.component';
import { SendEmailComponent } from './home/home/sendEmail/send-email/send-email.component';
import { SentComponent } from './home/home/sent/sent/sent.component';
import { DraftComponent } from './home/home/draft/draft/draft.component';
import { ContactsComponent } from './home/home/contacts/contacts/contacts.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SentComponent,
    TrashComponent,
    ContactsComponent,
    SendEmailComponent,
    InboxComponent,
    DraftComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path:'',component: LoginComponent,outlet:'registeration'},
      {path:'home',component:HomeComponent,outlet:'registeration'},
      {path:'home/trash',component:TrashComponent,outlet:'branching'},
      {path:'home/inbox',component:InboxComponent,outlet:'branching'},
      {path:'home/sendEmail',component:SendEmailComponent,outlet:'branching'},
      {path:'home/sent',component:SentComponent,outlet:'branching'},
      {path:'home/draft',component:DraftComponent,outlet:'branching'},
      {path:'home/contacts',component:ContactsComponent,outlet:'branching'},
    ]),
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [LoginComponent,HomeComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
