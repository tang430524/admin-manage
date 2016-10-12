import { ModuleWithProviders }  from '@angular/core';
import { RouterModule } from '@angular/router';
import {UserComponent} from "./user.compent";
import {UserFormComponent} from "./user-form.compent";
import {UserDetailComponent} from "./user-detail.compent";
import {RoleComponent} from "./role.compent";
import {RoleFormComponent} from "./role-form.compent";
import {RoleDetailComponent} from "./role-detail.compent";
import {ResourceComponent} from "./resources.compent";
import {ResourceFormComponent} from "./resource-form.compent";
import {ResourceDetailComponent} from "./resource-detail.compent";
import {SyslogComponent} from "./syslog.compent";
export const routing: ModuleWithProviders = RouterModule.forChild([
    { path: 'user', component: UserComponent},
    { path: 'user-form', component: UserFormComponent},
    { path: 'user-detail/:id', component: UserDetailComponent},
    { path: 'role', component: RoleComponent},
    { path: 'role-form', component: RoleFormComponent},
    { path: 'role-detail/:id', component: RoleDetailComponent},
    { path: 'resource', component: ResourceComponent},
    { path: 'resource-form', component: ResourceFormComponent},
    { path: 'resource-detail/:id', component: ResourceDetailComponent},
    { path: 'syslog', component: SyslogComponent}
]);
