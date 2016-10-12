import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Injector }    from '@angular/core';
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

    resource:any=new Object();


   
    save():void{
        if (this.resource ==null){
            return;
        }
        if (this.resource.id==null){
            this.restService.save(this.resource).then(()=>{
                this.router.navigate(["/resource"]);
            });
        }else{
            this.restService.update(this.resource).then(()=>{
                this.router.navigate(["/resource"]);
            });
        }
    }
   
}

