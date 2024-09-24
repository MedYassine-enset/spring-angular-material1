import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { AdminTemplateComponent } from './admin-template/admin-template.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButton, MatButtonModule} from "@angular/material/button";
import {MatIcon, MatIconModule} from "@angular/material/icon";
import {MatMenu, MatMenuItem, MatMenuModule, MatMenuTrigger} from "@angular/material/menu";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatActionList, MatList, MatListItem, MatListModule} from "@angular/material/list";
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { LoadStudentsComponent } from './load-students/load-students.component';
import { LoadPymentsComponent } from './load-pyments/load-pyments.component';
import { LoginComponent } from './login/login.component';
import { StudentsComponent } from './students/students.component';
import { PaymentsComponent } from './payments/payments.component';
import { DashboradComponent } from './dashborad/dashborad.component';
import {
    MatCard,
    MatCardActions,
    MatCardContent,
    MatCardHeader,
    MatCardModule,
    MatCardTitle
} from "@angular/material/card";
import {MatDivider, MatDividerModule} from "@angular/material/divider";
import {MatFormField, MatFormFieldModule, MatLabel} from "@angular/material/form-field";
import {MatInput, MatInputModule} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import {AuthGuard} from "./guards/auth.guard";
import {AuthorizationGuard} from "./guards/authorization.guard";
import { provideHttpClient, withInterceptorsFromDi } from "@angular/common/http";
import {MatTable, MatTableModule} from "@angular/material/table";
import {MatPaginator, MatPaginatorModule} from "@angular/material/paginator";
import {MatSort, MatSortHeader, MatSortModule} from "@angular/material/sort";
import {CommonModule} from "@angular/common";
import { StudentDetailsComponent } from './student-details/student-details.component';
import { NewPaymentComponent } from './new-payment/new-payment.component';
import {
  MatDatepicker,
  MatDatepickerInput,
  MatDatepickerModule,
  MatDatepickerToggle
} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {MatSelect, MatSelectModule} from "@angular/material/select";
import {PdfViewerModule} from "ng2-pdf-viewer";
import { PaymentDetailsComponent } from './payment-details/payment-details.component';

@NgModule({ declarations: [
        AppComponent,
        AdminTemplateComponent,
        HomeComponent,
        ProfileComponent,
        LoadStudentsComponent,
        LoadPymentsComponent,
        LoginComponent,
        StudentsComponent,
        PaymentsComponent,
        DashboradComponent,
        StudentDetailsComponent,
        NewPaymentComponent,
        PaymentDetailsComponent
    ],
    bootstrap: [AppComponent], imports: [BrowserModule,
        AppRoutingModule,
        MatToolbarModule,
        MatButtonModule,
        MatIconModule,
        MatMenuModule,
        MatMenuTrigger,
        MatMenuItem,
        MatSidenavModule,
        MatListModule,
        MatListItem,
        MatCardModule,
        MatCardHeader,
        MatCardTitle,
        MatCardContent,
        MatDividerModule,
        MatFormFieldModule,
        MatInputModule,
        MatLabel,
        MatActionList,
        MatCardActions,
        ReactiveFormsModule,
        MatTableModule,
        MatPaginatorModule,
        MatSortModule,
        MatSortHeader,
        CommonModule,
        MatDatepickerModule, MatNativeDateModule, MatDatepickerToggle, MatDatepickerInput, MatFormFieldModule, MatSelectModule,PdfViewerModule
    ],
    providers: [
        provideAnimationsAsync(), AuthGuard, AuthorizationGuard,
        provideHttpClient(withInterceptorsFromDi())
    ] })
export class AppModule { }
