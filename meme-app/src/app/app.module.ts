import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { AddcardComponent } from './addcard/addcard.component';
import { TagService } from './services/tag.service';
import { CardService } from './services/card.service';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UrlService } from './services/url.service';
import { RegisterComponent } from './register/register.component';
import { ViewCollectionComponent } from './view-collection/view-collection.component';
import { AdminComponent } from './admin/admin.component';
import { PickCardPackComponent } from './pick-card-pack/pick-card-pack.component';
import { ViewCardPackComponent } from './view-card-pack/view-card-pack.component';
import { RemoveUserComponent } from './remove-user/remove-user.component';
import { CardDetailsComponent } from './card-details/card-details.component';
<<<<<<< HEAD
import { BrowsePatronsComponent } from './browse-patrons/browse-patrons.component';
=======
import { BuyStonksComponent } from './buy-stonks/buy-stonks.component';
import { AdminCardComponent } from './admin-card/admin-card.component';
>>>>>>> 54e055720b0c7078117dbab61b1d0089b9196cf1

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
    AddcardComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    ViewCollectionComponent,
    AdminComponent,
    PickCardPackComponent,
    ViewCardPackComponent,
    RemoveUserComponent,
    CardDetailsComponent,
<<<<<<< HEAD
    BrowsePatronsComponent
=======
    BuyStonksComponent,
    AdminCardComponent
>>>>>>> 54e055720b0c7078117dbab61b1d0089b9196cf1
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    FontAwesomeModule
  ],
  providers: [
    TagService,
    CardService,
    UrlService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
