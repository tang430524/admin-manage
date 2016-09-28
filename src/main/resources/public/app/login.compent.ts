import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {LoginService} from './login.service';

@Component({
    selector: 'login-component',
    templateUrl: 'app/pages/login.html'
})
export class LoginComponent {
    username='';
    password='';
    remember=true;
    constructor(
        private router: Router,private loginService: LoginService) {
    }

    onSubmit():void{
       this.loginService.login(this.username,this.password,this.remember).then(() => {
           this.router.navigate(["/dashbord"]);
               // if (success) {
               //     this.router.navigate(["/dashbord"]);
               // } else {
               //     alert("login fail");
               // }
           }
       );
        
    }
}
