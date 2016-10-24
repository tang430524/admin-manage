import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {OnInit} from '@angular/core';
import {Injector}    from '@angular/core';

import {UserVo} from "./user-vo";
import {RestCurdService} from "../shard/rest-curd.service";

@Component({
    moduleId: module.id,
    selector: 'user-list',
    templateUrl: 'user-list.html'
})
export class UserListComponent implements OnInit {

    constructor(private router:Router, private indecter:Injector) {

    }

    restService:RestCurdService<UserVo> = new RestCurdService<UserVo>(this.indecter, "/user");

    users:UserVo[];

    newClick():void {
        this.router.navigate(["/user-form"]);
    }

    itemClick(id:string):void {
        this.router.navigate(["/user-detail", id]);
    }

    grant(id:string):void {
        this.router.navigate(["/grant-role", id]);
    }

    changeStatus(id:string, disable:boolean):void {
        this.restService.switchStatus(id, !disable).then(()=> {
            this.users.forEach((u:UserVo)=> {
                if (u.id == id) {
                    u.disabled = !disable;
                }
            });
        });
    }

    del(id:string):void {
        this.restService.delete(id).then(()=> {
            // this.users = this.users.filter((u:UserVo)=> {
            //     u.id != id;
            // });
            let news:UserVo[]=[];
            this.users.forEach((u:UserVo)=> {
                if (u.id != id) {
                    news.push(u);
                }
                this.users=news;
            });


        });
    }


    ngOnInit():void {
        this.restService.list().then(data => {
                this.users = (data as UserVo[]);
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
