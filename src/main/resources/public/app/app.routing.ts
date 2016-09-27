import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login.compent'
import {DashBordComponent} from "./dashbord.compent";
import {UserComponent} from "./user.compent";

const appRoutes: Routes = [
    {
        path: 'login',
        component: LoginComponent
     },
    {
        path: 'dashbord',
        component: DashBordComponent
    },
    {
        path: 'users',
        component: UserComponent
    },
    {
        path: '',
        redirectTo: '/login',
        pathMatch: 'full'
    }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
