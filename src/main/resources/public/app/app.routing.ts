import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {DashBordComponent} from "./dashbord.compent";


const appRoutes: Routes = [
    {
        path: 'dashbord',
        component: DashBordComponent
    },
    {
        path: 'login',
        loadChildren: 'app/login/login.module#LoginModule'
    },
    
    {
        path: 'user',
        loadChildren: 'app/system/system.module#SystemModule'
    },
    {
        path: 'user-form',
        loadChildren: 'app/system/system.module#SystemModule'
    },
    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
    }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
