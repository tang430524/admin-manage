import {ModuleWithProviders} from "@angular/core";
import {RouterModule} from "@angular/router";
import {UserListComponent} from "./user-list.compent";
import {UserFormComponent} from "./user-form.compent";
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
import {MenuDetailComponent} from "./menu-detail.compent";
import {MenuFormComponent} from "./menu-form.compent";
import {GrantMenuComponent} from "./grant-menu.compent";
import {MyProfileComponent} from "./myprofile.compent";
export const routing: ModuleWithProviders = RouterModule.forChild([
    { path: 'user', component: UserListComponent},
    {path: 'user/form', component: UserFormComponent},
    {path: 'user/detail/:id', component: UserDetailComponent},
    {path: 'user/my-profile', component: MyProfileComponent},
    { path: 'role', component: RoleListComponent},
    {path: 'role/form', component: RoleFormComponent},
    {path: 'role/detail/:id', component: RoleDetailComponent},
    { path: 'resource', component: ResourceListComponent},
    {path: 'resource/form', component: ResourceFormComponent},
    {path: 'resource/detail/:id', component: ResourceDetailComponent},
    { path: 'syslog', component: SyslogListComponent},
    { path: 'menu', component: MenuListComponent},
    {path: 'menu/form/:path', component: MenuFormComponent},
    {path: 'menu/detail/:id', component: MenuDetailComponent},
    {path: 'grant/role/:uid', component: GrantRoleComponent},
    {path: 'grant/resource/:rid', component: GrantResourceComponent},
    {path: 'grant/menu/:rid', component: GrantMenuComponent}
]);
