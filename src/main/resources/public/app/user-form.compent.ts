import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { OnInit } from '@angular/core';
import { Injector }    from '@angular/core';
import {RestCurdService} from "./rest-curd.service";
import {User} from "./user";
@Component({
    selector: 'user-form',
    templateUrl: 'app/pages/user-form.html'
})
export class UserFormComponent {

    constructor(private router: Router,private indecter:Injector) {

    }

    restService:RestCurdService<User>=new RestCurdService<User>(this.indecter,"/user");

    user:User=new User;


   
    save():void{
        if (this.user ==null){
            return;
        }
        if (this.user.id==null){
            this.restService.save(this.user).then(()=>{
                this.router.navigate(["/user"]);
            });
        }else{
            this.restService.update(this.user).then(()=>{
                this.router.navigate(["/user"]);
            });
        }
    }


    
    private handleError(error: any): void{
        console.error('An error occurred', error); // for demo purposes only
        alert("operation fail!"+error.text());
    };

   
}

