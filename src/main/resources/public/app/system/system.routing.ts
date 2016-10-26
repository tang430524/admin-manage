import { ModuleWithProviders }  from '@angular/core';
import { RouterModule } from '@angular/router';
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
export const routing: ModuleWithProviders = RouterModule.forChild([
    { path: 'user', component: UserListComponent},
    { path: 'user-form', component: UserFormComponent},
    { path: 'user-detail/:id', component: UserDetailComponent},
    { path: 'role', component: RoleListComponent},
    { path: 'role-form', component: RoleFormComponent},
    { path: 'role-detail/:id', component: RoleDetailComponent},
    { path: 'resource', component: ResourceListComponent},
    { path: 'resource-form', component: ResourceFormComponent},
    { path: 'resource-detail/:id', component: ResourceDetailComponent},
    { path: 'syslog', component: SyslogListComponent},
    { path: 'menu', component: MenuListComponent},
    { path: 'grant-role/:id',component:GrantRoleComponent},
    { path: 'grant-resource/:id',component:GrantResourceComponent}
]);
