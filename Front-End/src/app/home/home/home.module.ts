import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SentComponent } from './sent/sent/sent.component';
import { TrashComponent } from './trash/trash/trash.component';
import { ContactsComponent } from './contacts/contacts/contacts.component';
import { SendEmailComponent } from './sendEmail/send-email/send-email.component';
import { InboxComponent } from './inbox/inbox/inbox.component';
import { DraftComponent } from './draft/draft/draft.component';


@NgModule({
  declarations: [
    SentComponent,
    TrashComponent,
    ContactsComponent,
    SendEmailComponent,
    InboxComponent,
    DraftComponent
  ],
  imports: [
    CommonModule

  ]
})
export class HomeModule { }
