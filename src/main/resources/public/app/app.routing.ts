import {ModuleWithProviders, Injectable} from "@angular/core";
import {Routes, Router, RouterModule, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from "@angular/router";
import {DashBordComponent} from "./dashbord.compent";
import "./shard/rxjs-extention";
import {Observable} from "rxjs";

const appRoutes:Routes = [
    {
        path: 'dashbord',
        component: DashBordComponent,
        //canActivate: [canToDashbord]
    },
    {
        path: 'login',
        loadChildren: 'app/login/login.module#LoginModule'
    },
    
    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full',
        //canActivate: [canToDashbord]
    }
];

export const routing:ModuleWithProviders = RouterModule.forRoot(appRoutes);

@Injectable()
class canToDashbord implements CanActivate {

    private router:Router;


    canActivate(route:ActivatedRouteSnapshot, state:RouterStateSnapshot):Observable<boolean>|Promise<boolean>|boolean {
        try {
            let can = sessionStorage.hasOwnProperty("token");
            if (!can) {
                this.router.navigate(['/login']);
            }
            return can;
        } catch (e:any) {
            this.router.navigate(['/login']);
            return false;
        }
    }


}
