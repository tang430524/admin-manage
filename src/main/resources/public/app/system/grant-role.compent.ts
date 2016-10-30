import {Component, OnInit} from "@angular/core";
import {Router, ActivatedRoute, Params} from "@angular/router";
import {HttpUtil} from "../shard/HttpUtil";

/**为用户分配角色*/
@Component({
    moduleId: module.id,
    selector: 'grant-role',
    templateUrl: 'grant-role.html'
})
export class GrantRoleComponent implements OnInit {

    constructor(private router:Router, private http:HttpUtil, private active:ActivatedRoute) {

    }


    roles:any;

    uid:string;//当前用户id

    grant():void {

        this.http.put("/user/" + this.uid + "/grantRole", JSON.stringify(this.roles)).then(()=> {
            this.router.navigate(["/user"]);
        });
    }


    ngOnInit():void {
        this.active.params.forEach((params:Params) => {
            var id = params['uid'];
            if (!id) {
                return;
            }
            this.uid = id;
        });

        this.http.getWithJsonContentType("/user/" + this.uid + "/select-role").then(data => {
                this.roles = data;
            }
        );
    }

}
