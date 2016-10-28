import {Component, OnInit} from "@angular/core";
import {Router, ActivatedRoute, Params} from "@angular/router";
import {HttpUtil} from "../shard/HttpUtil";

/**为角色分配资源权限*/
@Component({
    moduleId: module.id,
    selector: 'grant-resource',
    templateUrl: 'grant-resource.html'
})
export class GrantResourceComponent implements OnInit {

    constructor(private router:Router, private active:ActivatedRoute, private http:HttpUtil) {

    }

    resources:any;

    rid:string;//当前角色id

    grant():void {

        this.http.put("/role/" + this.rid + "/grant-resource", JSON.stringify(this.resources)).then(()=> {
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

        this.http.getWithJsonContentType("/role/" + this.rid + "/select-resource").then(data => {
                this.resources = data;
            }
        );
    }

}
