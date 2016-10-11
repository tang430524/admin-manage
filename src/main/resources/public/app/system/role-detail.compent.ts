import { Component } from '@angular/core';
import {Router, ActivatedRoute, Params} from '@angular/router';
import { OnInit } from '@angular/core';
import { Injector }    from '@angular/core';
import {RestCurdService} from "../shard/rest-curd.service";

@Component({
    moduleId: module.id,
    selector: 'role-detail',
    templateUrl: 'role-detail.html'
})
export class RoleDetailComponent implements OnInit{

    constructor(private router: Router,private indecter:Injector,private active:ActivatedRoute) {

    }

    restService:RestCurdService<Object>=new RestCurdService<Object>(this.indecter,"/role");

    role:any=new Object();


   
    save():void{
        if (this.role ==null){
            return;
        }

            this.restService.update(this.role).then(()=>{
                this.router.navigate(["/role"]);
            });

    }
    

     ngOnInit():void {
         this.active.params.forEach((params: Params) => {
             var id = params['id'];
             if(!id){
                 return;
             }
             this.restService.get(id).then((result)=>{
                 this.role=result;
                 //alert(JSON.stringify(this.role));
             })
         });
     }
}

