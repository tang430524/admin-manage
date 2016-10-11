import { NgModule }      from '@angular/core';
import {UserComponent} from "./user.compent";
import {UserFormComponent} from "./user-form.compent";
import {routing} from "./system.routing";
import {ShareModule} from '../shard/share.moudle';
import {UserDetailComponent} from "./user-detail.compent";
import {MenuComponent} from "./menu.compent";
import {RoleComponent} from "./role.compent";
import {RoleFormComponent} from "./role-form.compent";
import {RoleDetailComponent} from "./role-detail.compent";
@NgModule({
    imports: [
        ShareModule,
        routing,
      ],
   
    declarations: [UserComponent,UserFormComponent,UserDetailComponent,MenuComponent,RoleComponent,RoleFormComponent,RoleDetailComponent]
})
export class SystemModule { }
/**
 * Created by qiangxie on 2016/9/24.
 */
