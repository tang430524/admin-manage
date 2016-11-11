/**
 * Created by qiangxie on 2016/11/11.
 */
import {Injectable} from "@angular/core";
import {Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from "@angular/router";
import {LoginService} from "./login.service";

@Injectable()
export class LoginGuard implements CanActivate {

    constructor(private router:Router, private loginService:LoginService) {
    }


    canActivate(route:ActivatedRouteSnapshot, state:RouterStateSnapshot):boolean {

        let login = this.loginService.isLogin;
        if (!login) {
            this.router.navigate(['/login']);
        }
        return login;
    }
}
