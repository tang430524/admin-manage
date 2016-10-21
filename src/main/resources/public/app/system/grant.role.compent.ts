import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {OnInit} from '@angular/core';
import {Input} from '@angular/core';
import {Injector}    from '@angular/core';

import {RestCurdService} from "../shard/rest-curd.service";
import {UserView} from "./userview";

/**为用户分配角色*/
@Component({
    moduleId: module.id,
    selector: 'grant-role',
    templateUrl: 'grant-role.html'
})
export class GrantRoleComponent implements OnInit {

    constructor(private router:Router, private indecter:Injector) {

    }

    restService:RestCurdService<Object[]> = new RestCurdService<Object[]>(this.indecter, "/role");

    roles:any;

    checkedRoles:GrantRole[]=[];

    @Input()
    user:UserView;

    grant():void {

        this.router.navigate(["/role"]);
    }

   


    ngOnInit():void {
        this.restService.list().then(data => {
                this.roles = (data as Object[]);
            }
        );
    }

}
