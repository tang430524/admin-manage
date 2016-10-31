import {Component, Injector} from "@angular/core";
import {Router} from "@angular/router";
import {RestCurdService} from "../shard/rest-curd.service";

@Component({
    moduleId: module.id,
    selector: 'role-form',
    templateUrl: 'role-form.html'
})
export class RoleFormComponent {

    constructor(private router: Router,private indecter:Injector) {

    }

    restService:RestCurdService<Object>=new RestCurdService<Object>(this.indecter,"/role");

    role:any = {};


   
    save():void{
        if (this.role ==null){
            return;
        }

        this.restService.save(this.role).then(()=>{
                this.router.navigate(["/role"]);
            });

    }
   
}

