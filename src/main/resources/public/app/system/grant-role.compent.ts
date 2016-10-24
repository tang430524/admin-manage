import {Component} from '@angular/core';
import {OnInit} from '@angular/core';
import {Injector}    from '@angular/core';
import {RestCurdService} from "../shard/rest-curd.service";
import {Router, ActivatedRoute, Params} from '@angular/router';
import {Http, Headers} from "@angular/http";

/**为用户分配角色*/
@Component({
    moduleId: module.id,
    selector: 'grant-role',
    templateUrl: 'grant-role.html'
})
export class GrantRoleComponent implements OnInit {

    constructor(private router:Router, private indecter:Injector, private active:ActivatedRoute, private http:Http) {

    }

    restService:RestCurdService<any> = new RestCurdService<any>(this.indecter, "/role");

    roles:any;

    uid:string;//当前用户id

    grant():void {
        let checkedRoles = this.roles.filter((role:any) => {
            return role.disabled;
        }).map((role:any)=>{
            return role.id;
        });
        if (checkedRoles.length == 0) {
            return;
        }
        this.http.put("/user/grantRole/" + this.uid, JSON.stringify(checkedRoles), {headers: new Headers({'Content-Type': 'application/json'})}).toPromise().then(()=> {
            this.router.navigate(["/user"]);
        });
    }


    ngOnInit():void {
        this.active.params.forEach((params:Params) => {
            var id = params['id'];
            if (!id) {
                return;
            }
            this.uid = id;
        });

        this.restService.list().then(data => {
                this.roles = data;
            }
        );
    }

}
