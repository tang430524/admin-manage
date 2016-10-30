import {Component, OnInit} from "@angular/core";
import {Router, ActivatedRoute, Params} from "@angular/router";
import {HttpUtil} from "../shard/HttpUtil";

/**为角色分配资源权限*/
@Component({
    moduleId: module.id,
    selector: 'grant-menu',
    templateUrl: 'grant-menu.html'
})
export class GrantMenuComponent implements OnInit {

    constructor(private router:Router, private active:ActivatedRoute, private http:HttpUtil) {

    }

    menus:any;

    rid:string;//当前角色id

    grant():void {

        this.http.put("/role/" + this.rid + "/grant-menu", JSON.stringify(this.menus)).then(()=> {
            this.router.navigate(["/role"]);
        });
    }


    ngOnInit():void {
        this.active.params.forEach((params:Params) => {
            var id = params['rid'];
            if (!id) {
                return;
            }
            this.rid = id;
        });

        this.http.getWithJsonContentType("/role/" + this.rid + "/select-menu").then(data => {
                this.menus = data;
            }
        );
    }

}
