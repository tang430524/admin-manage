import { Component } from '@angular/core';
import {Router, ActivatedRoute, Params} from '@angular/router';
import { OnInit } from '@angular/core';
import { Injector }    from '@angular/core';
import {RestCurdService} from "../shard/rest-curd.service";
import {UserForm} from "./user-form";
@Component({
    moduleId: module.id,
    selector: 'user-detail',
    templateUrl: 'user-detail.html'
})
export class UserDetailComponent implements OnInit{

    constructor(private router: Router,private indecter:Injector,private active:ActivatedRoute) {

    }

    restService:RestCurdService<UserForm>=new RestCurdService<UserForm>(this.indecter,"/user");

    user:UserForm=new UserForm();


   
    save():void{
        if (this.user ==null){
            return;
        }

            this.restService.update(this.user).then(()=>{
                this.router.navigate(["/user"]);
            });

    }


    
    private handleError(error: any): void{
        console.error('An error occurred', error); // for demo purposes only
        alert("operation fail!"+error.text());
    };


     ngOnInit():void {
         this.active.params.forEach((params: Params) => {
             var id = params['id'];
             if(!id){
                 return;
             }
             this.restService.get(id).then((result)=>{
                 this.user=result;
                 //alert(JSON.stringify(this.user));
             })
         });
     }
}

