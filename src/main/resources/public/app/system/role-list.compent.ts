import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {OnInit} from '@angular/core';
import {Injector}    from '@angular/core';

import {RestCurdService} from "../shard/rest-curd.service";

@Component({
    moduleId: module.id,
    selector: 'role-list',
    templateUrl: 'role-list.html'
})
export class RoleListComponent implements OnInit {

    constructor(private router:Router, private indecter:Injector) {

    }

    restService:RestCurdService<Object[]> = new RestCurdService<Object[]>(this.indecter, "/role");

    roles:any;

    newClick():void {
        this.router.navigate(["/role-form"]);
    }

    itemClick(id:string):void {
        this.router.navigate(["/role-detail", id]);
    }

    changeStatus(id:string, disable:boolean):void {
        this.restService.switchStatus(id, !disable).then(()=> {
            this.roles.forEach((u)=> {
                if (u.id == id) {
                    u.disabled = !disable;
                }
            });
        });
    }

    del(id:string):void {
        this.restService.delete(id).then(()=> {
            // this.roles = this.roles.filter((u:Object)=> {
            //     u.id != id;
            // });
            let news=[];
            this.roles.forEach((u)=> {
                if (u.id != id) {
                    news.push(u);
                }
                this.roles=news;
            });


        });
    }

    grant(id:string):void {
        this.router.navigate(["/grant-resource", id]);
    }

    grantMenu(id:string):void {
        this.router.navigate(["/grant-menu", id]);
    }



    ngOnInit():void {
        this.restService.list().then(data => {
                this.roles = (data as Object[]);
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
