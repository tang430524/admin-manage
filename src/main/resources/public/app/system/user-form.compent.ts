import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Injector }    from '@angular/core';
import {RestCurdService} from "../shard/rest-curd.service";
import {UserForm} from "./user-form";
@Component({
    moduleId: module.id,
    selector: 'user-form',
    templateUrl: 'user-form.html'
})
export class UserFormComponent {

    constructor(private router: Router,private indecter:Injector) {

    }

    restService:RestCurdService<UserForm>=new RestCurdService<UserForm>(this.indecter,"/user");

    user:UserForm=new UserForm;


   
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
   
}

