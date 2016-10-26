import {Component} from '@angular/core';
import {OnInit} from '@angular/core';
import {Injector}    from '@angular/core';
import {RestCurdService} from "../shard/rest-curd.service";
import {Router, ActivatedRoute, Params} from '@angular/router';
import {Http, Headers} from "@angular/http";

/**为角色分配资源权限*/
@Component({
    moduleId: module.id,
    selector: 'grant-resource',
    templateUrl: 'grant-resource.html'
})
export class GrantResourceComponent implements OnInit {

    constructor(private router:Router, private indecter:Injector, private active:ActivatedRoute, private http:Http) {

    }

    restService:RestCurdService<any> = new RestCurdService<any>(this.indecter, "/resource");

    resources:any;

    rid:string;//当前角色id

    grant():void {
        let checkedRoles = this.resources.filter((resource:any) => {
            return resource.disabled;
        }).map((resource:any)=>{
            return resource.id;
        });
        if (checkedRoles.length == 0) {
            return;
        }
        this.http.put("/role/"+ this.rid+"/grant-resource", JSON.stringify(checkedRoles), {headers: new Headers({'Content-Type': 'application/json'})}).toPromise().then(()=> {
            this.router.navigate(["/role"]);
        });
    }


    ngOnInit():void {
        this.active.params.forEach((params:Params) => {
            var id = params['id'];
            if (!id) {
                return;
            }
            this.rid = id;
        });

        this.restService.list().then(data => {
                this.resources = data;
            }
        );
    }

}
