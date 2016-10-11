import { ModuleWithProviders }  from '@angular/core';
import { RouterModule } from '@angular/router';
import {UserComponent} from "./user.compent";
import {UserFormComponent} from "./user-form.compent";
import {UserDetailComponent} from "./user-detail.compent";
import {RoleComponent} from "./role.compent";
import {RoleFormComponent} from "./role-form.compent";
import {RoleDetailComponent} from "./role-detail.compent";
export const routing: ModuleWithProviders = RouterModule.forChild([
    { path: 'user', component: UserComponent},
    { path: 'user-form', component: UserFormComponent},
    { path: 'user-detail/:id', component: UserDetailComponent},
    { path: 'role', component: RoleComponent},
    { path: 'role-form', component: RoleFormComponent},
    { path: 'role-detail/:id', component: RoleDetailComponent}
]);
