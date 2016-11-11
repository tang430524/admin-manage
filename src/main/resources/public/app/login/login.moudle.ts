import {NgModule} from "@angular/core";
import {LoginService} from "./login.service";
import {LoginComponent} from "./login.compent";
import {routing} from "./login.routing";
import {ShareModule} from "../shard/share.moudle";
import {LoginGuard} from "./login-guard-service";
@NgModule({
    imports: [
        routing,
        ShareModule
      
      ],
    providers: [
        LoginService, LoginGuard
    ],
    declarations: [LoginComponent]
})
export class LoginModule { }
/**
 * Created by qiangxie on 2016/9/24.
 */
