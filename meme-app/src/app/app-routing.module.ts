import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddcardComponent } from './addcard/addcard.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ViewCollectionComponent } from './view-collection/view-collection.component';
import { AdminComponent } from './admin/admin.component';
import { PickCardPackComponent } from './pick-card-pack/pick-card-pack.component';
import { ViewCardPackComponent } from './view-card-pack/view-card-pack.component';
import { RemoveUserComponent } from './remove-user/remove-user.component';
import { CardDetailsComponent } from './card-details/card-details.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'card/add',
    component: AddcardComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'view-collection',
    component: ViewCollectionComponent
  },
  {
    path: 'admin',
    component: AdminComponent
  },
  {
    path: 'pick-card-pack',
    component: PickCardPackComponent
  },
  {
    path: 'view-card-pack',
    component: ViewCardPackComponent
  },
  {
    path: 'remove-user',
    component: RemoveUserComponent
  },
  { path: 'card-details/:id', 
    component: CardDetailsComponent 
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
