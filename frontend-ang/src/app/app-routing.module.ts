import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {ProfileComponent} from "./profile/profile.component";
import {LoginComponent} from "./login/login.component";
import {LoadStudentsComponent} from "./load-students/load-students.component";
import {LoadPymentsComponent} from "./load-pyments/load-pyments.component";
import {DashboradComponent} from "./dashborad/dashborad.component";
import {StudentsComponent} from "./students/students.component";
import {PaymentsComponent} from "./payments/payments.component";
import {AdminTemplateComponent} from "./admin-template/admin-template.component";
import {AuthGuard} from "./guards/auth.guard";
import {AuthorizationGuard} from "./guards/authorization.guard";
import {StudentDetailsComponent} from "./student-details/student-details.component";
import {NewPaymentComponent} from "./new-payment/new-payment.component";
import {PaymentDetailsComponent} from "./payment-details/payment-details.component";

const routes: Routes = [
  {path : "",component : LoginComponent},
  {path : "login",component : LoginComponent},
  {path : "admin",component : AdminTemplateComponent,
    canActivate : [AuthGuard],
    children : [
      {path : "payment-details/:id",component : PaymentDetailsComponent},
      {path : "home",component : HomeComponent},
      {path : "profile",component : ProfileComponent},
      {path : "loadStudents",component : LoadStudentsComponent,canActivate : [AuthorizationGuard],data : {roles : ['ADMIN']}},
      {path : "loadPayments",component : LoadPymentsComponent,canActivate : [AuthorizationGuard],data : {roles : ['ADMIN']}},
      {path : "dashboard",component : DashboradComponent},
      {path : "students",component : StudentsComponent},
      {path : "payments",component : PaymentsComponent},
      {path : "student-details/:code",component : StudentDetailsComponent},
      {path : "new-payment/:studentCode",component : NewPaymentComponent}
    ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }