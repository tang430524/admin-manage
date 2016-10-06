import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {OnInit} from '@angular/core';
import {Injector}    from '@angular/core';

import {UserView} from "./userview";
import {RestCurdService} from "../shard/rest-curd.service";

@Component({
    moduleId: module.id,
    selector: 'user-list',
    templateUrl: 'users.html'
})
export class UserComponent implements OnInit {

    constructor(private router:Router, private indecter:Injector) {

    }

    restService:RestCurdService<UserView> = new RestCurdService<UserView>(this.indecter, "/user");

    users:UserView[];

    newClick():void {
        this.router.navigate(["/user-form"]);
    }

    itemClick(id:string):void {
        this.router.navigate(["/user-detail", id]);
    }

    changeStatus(id:string, disable:boolean):void {
        this.restService.switchStatus(id, !disable).then(()=> {
            this.users.forEach((u:UserView)=> {
                if (u.id == id) {
                    u.disabled = !disable;
                }
            });
        });
    }

    del(id:string):void {
        this.restService.delete(id).then(()=> {
            // this.users = this.users.filter((u:UserView)=> {
            //     u.id != id;
            // });
            let news:UserView[]=[];
            this.users.forEach((u:UserView)=> {
                if (u.id != id) {
                    news.push(u);
                }
                this.users=news;
            });


        });
    }


    ngOnInit():void {
        this.restService.list().then(data => {
                this.users = (data as UserView[]);
            }
        );
    }



    disabled(disable):string {
        if (disable) {
            return "禁用";
        }
        return "启用";
    }
}
