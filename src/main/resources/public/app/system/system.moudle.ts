/**
 * Created by qiangxie on 2016/9/24.
 */

import {NgModule} from "@angular/core";
import {UserListComponent} from "./user-list.compent";
import {UserFormComponent} from "./user-form.compent";
import {routing} from "./system.routing";
import {ShareModule} from "../shard/share.moudle";
import {UserDetailComponent} from "./user-detail.compent";
import {RoleListComponent} from "./role-list.compent";
import {RoleFormComponent} from "./role-form.compent";
import {RoleDetailComponent} from "./role-detail.compent";
import {ResourceListComponent} from "./resource-list.compent";
import {ResourceFormComponent} from "./resource-form.compent";
import {ResourceDetailComponent} from "./resource-detail.compent";
import {SyslogListComponent} from "./syslog-list.compent";
import {MenuListComponent} from "./menu-list.compent";
import {GrantRoleComponent} from "./grant-role.compent";
import {GrantResourceComponent} from "./grant-resource.compent";
import {MenuFormComponent} from "./menu-form.compent";
import {MenuDetailComponent} from "./menu-detail.compent";
import {GrantMenuComponent} from "./grant-menu.compent";
import {NavMenuComponent} from "./nav-menu.compent";
@NgModule({
    imports: [
        ShareModule,
        routing,
      ],
   
    declarations: [UserListComponent,UserFormComponent,UserDetailComponent,
        RoleListComponent,RoleFormComponent,RoleDetailComponent,
        ResourceListComponent,ResourceFormComponent,ResourceDetailComponent,
        SyslogListComponent,MenuListComponent, MenuFormComponent,MenuDetailComponent,
        GrantRoleComponent, GrantResourceComponent,GrantMenuComponent,
        NavMenuComponent
    ] ,
    exports:[NavMenuComponent]
})
export class SystemModule { }

