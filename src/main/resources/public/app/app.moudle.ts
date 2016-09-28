import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule }    from '@angular/http';
import { LoginComponent } from './login.compent'
import { routing } from './app.routing';
import {AppComponent} from "./app.compent";
import {DashBordComponent} from "./dashbord.compent";
import {UserComponent} from "./user.compent";
import {LoginService} from './login.service';
import 'rxjs/add/operator/toPromise';
@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        routing,
        HttpModule
      ],
    providers: [
      LoginService
    ],
    declarations: [ LoginComponent,AppComponent, DashBordComponent,UserComponent],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }
/**
 * Created by qiangxie on 2016/9/24.
 */
