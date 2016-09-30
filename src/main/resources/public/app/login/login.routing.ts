import { ModuleWithProviders }  from '@angular/core';
import { RouterModule } from '@angular/router';
import {LoginComponent} from "./login.compent";
export const routing: ModuleWithProviders = RouterModule.forChild([
    { path: 'login', component: LoginComponent}
]);
