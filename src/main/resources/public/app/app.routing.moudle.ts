import {NgModule} from "@angular/core";
import {DashBordComponent} from "./dashbord.compent";
import {RouterModule} from "@angular/router";
import {LoginGuard} from "./login/login-guard-service";

@NgModule({
    imports: [
        RouterModule.forRoot([
            {
                path: 'dashbord',
                component: DashBordComponent,
                canActivate: [LoginGuard]
            },

            {
                path: '',
                redirectTo: '/dashbord',
                pathMatch: 'full'
            }
        ])
    ],
    providers: [
        LoginGuard
    ],
    exports: [RouterModule]
})

export class AppRoutingModule {
}




