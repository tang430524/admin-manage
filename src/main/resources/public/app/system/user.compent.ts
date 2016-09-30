import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { OnInit } from '@angular/core';
import { Injector }    from '@angular/core';

import {User} from "./user";
import {RestCurdService} from "../shard/rest-curd.service";

@Component({
    moduleId: module.id,
    selector: 'user-list',
    templateUrl: 'users.html'
})
export class UserComponent implements OnInit {

    constructor(private router: Router,private indecter:Injector) {

    }

    restService:RestCurdService<User>=new RestCurdService<User>(this.indecter,"/user");

    users:User[];

    newClick():void{
        this.router.navigate(["/user-form"]);
    }

    itemClick(user:User):void{
       // this.router.navigate(["/user-form"]);
    }
    
    save():void{

    }


     ngOnInit():void {
       this.restService.list().then(data => {
           this.users= (data as User[]);
        }
       ).catch(this.handleError);
     }

    private handleError(error: any): void{
        console.error('An error occurred', error); // for demo purposes only
        alert("operation fail!"+error.text());
    };

    disabled(disable):string {
        if (disable){
            return "禁用";
        }
        return "正常";
    }
}
