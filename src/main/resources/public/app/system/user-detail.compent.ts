import {Component, OnInit, Injector} from "@angular/core";
import {Router, ActivatedRoute, Params} from "@angular/router";
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


    save(id:any):void {
        if (this.user ==null){
            return;
        }

        this.restService.update(id, this.user).then(()=> {
                this.router.navigate(["/user"]);
            });

    }
    


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

