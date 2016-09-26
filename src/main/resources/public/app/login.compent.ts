import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
    selector: 'login-component',
    templateUrl: 'app/pages/login.html'
})
export class LoginComponent {
    loginName='';
    password='';
    remember=true;
    constructor(
        private router: Router) {
    }

    onSubmit():void{
        // alert(this.loginName+this.password+''+this.remember);
        //todo
        this.router.navigate(["/dashbord"]);
    }
}
