import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { routing } from './app.routing';
import {AppComponent} from "./app.compent";
import {DashBordComponent} from "./dashbord.compent";
import {LoginModule} from "./login/login.moudle";
import {SystemModule} from "./system/system.moudle";
import {ShareModule} from './shard/share.moudle';

@NgModule({
    imports: [
        // BrowserModule,
        // FormsModule,
        LoginModule,
        SystemModule,
        routing,
        ShareModule
      ],
   
    declarations: [ AppComponent, DashBordComponent],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }
/**
 * Created by qiangxie on 2016/9/24.
 */
