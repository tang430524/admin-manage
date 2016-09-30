import { NgModule }      from '@angular/core';
import {UserComponent} from "./user.compent";
import {UserFormComponent} from "./user-form.compent";
import {routing} from "./system.routing";
import { HttpModule }    from '@angular/http';
import { FormsModule }   from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import {ShareModule} from '../shard/share.moudle';
@NgModule({
    imports: [
        // BrowserModule,
        // FormsModule,
        // HttpModule,
        ShareModule,
        routing,
      ],
   
    declarations: [UserComponent,UserFormComponent]
})
export class SystemModule { }
/**
 * Created by qiangxie on 2016/9/24.
 */
