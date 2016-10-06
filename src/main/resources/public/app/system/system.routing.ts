import { ModuleWithProviders }  from '@angular/core';
import { RouterModule } from '@angular/router';
import {UserComponent} from "./user.compent";
import {UserFormComponent} from "./user-form.compent";
import {UserDetailComponent} from "./user-detail.compent";
export const routing: ModuleWithProviders = RouterModule.forChild([
    { path: 'user', component: UserComponent},
    { path: 'user-form', component: UserFormComponent},
    { path: 'user-detail/:id', component: UserDetailComponent}
]);
