import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { LoginComponent } from './login.compent'
import { routing } from './app.routing';
import {AppComponent} from "./app.compent";
import {DashBordComponent} from "./dashbord.compent";
import {UserComponent} from "./user.compent";

@NgModule({
    imports:      [ BrowserModule,
        FormsModule,
        routing],
    declarations: [ LoginComponent,AppComponent, DashBordComponent,UserComponent],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }
/**
 * Created by qiangxie on 2016/9/24.
 */
