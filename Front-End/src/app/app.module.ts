import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login/login.component';
import { HomeComponent } from './home/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { TrashComponent } from './trash/trash.component';
import { InboxComponent } from './inbox/inbox.component';
import { SendEmailComponent } from './send-email/send-email.component';
import { SentComponent } from './sent/sent.component';
import { DraftComponent } from './draft/draft.component';
import { ContactsComponent } from './contacts/contacts.component';

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
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    LoginComponent,
    HomeComponent,
    SentComponent,
    TrashComponent,
    ContactsComponent,
    SendEmailComponent,
    InboxComponent,
    DraftComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
