import { NgModule }      from '@angular/core';
import { FormsModule }   from '@angular/forms';
import {LoginService} from "./login.service";
import {LoginComponent} from "./login.compent";
import {routing} from "./login.routing";
import { HttpModule }    from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import {ShareModule} from '../shard/share.moudle';
@NgModule({
    imports: [
        // BrowserModule,
        // FormsModule,
        // HttpModule,
        routing,
        ShareModule
      
      ],
    providers: [
      LoginService
    ],
    declarations: [LoginComponent]
})
export class LoginModule { }
/**
 * Created by qiangxie on 2016/9/24.
 */
