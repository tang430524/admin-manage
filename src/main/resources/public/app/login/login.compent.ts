import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {LoginService} from './login.service';

@Component({
    moduleId: module.id,
    selector: 'login-component',
    templateUrl: 'login.html'
})
export class LoginComponent {
    username='';
    password='';
    remember=true;
    constructor(
        private router: Router,private loginService: LoginService) {
    }

    onSubmit():void{
       this.loginService.login(this.username,this.password,this.remember).then(success => {
               if (success) {
                   this.router.navigate(["/dashbord"]);
               } else {
                   alert("login fail");
               }
           }
       ).catch(this.handleError);
    }

    private handleError(error: any): void{
        console.error('An error occurred', error); // for demo purposes only
       alert("login fail!");
    }
}
