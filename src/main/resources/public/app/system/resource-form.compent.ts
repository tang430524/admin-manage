import {Component, Injector} from "@angular/core";
import {Router} from "@angular/router";
import {RestCurdService} from "../shard/rest-curd.service";

@Component({
    moduleId: module.id,
    selector: 'resource-form',
    templateUrl: 'resource-form.html'
})
export class ResourceFormComponent {

    constructor(private router: Router,private indecter:Injector) {

    }

    restService:RestCurdService<Object>=new RestCurdService<Object>(this.indecter,"/resource");

    resource:any = {};


   
    save():void{
        if (this.resource ==null){
            return;
        }

        this.restService.save(this.resource).then(()=>{
                this.router.navigate(["/resource"]);
            });

    }
   
}

