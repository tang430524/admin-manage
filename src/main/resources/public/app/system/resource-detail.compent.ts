import {Component, OnInit, Injector} from "@angular/core";
import {Router, ActivatedRoute, Params} from "@angular/router";
import {RestCurdService} from "../shard/rest-curd.service";

@Component({
    moduleId: module.id,
    selector: 'resource-detail',
    templateUrl: 'resource-detail.html'
})
export class ResourceDetailComponent implements OnInit{

    constructor(private router: Router,private indecter:Injector,private active:ActivatedRoute) {

    }

    restService:RestCurdService<Object>=new RestCurdService<Object>(this.indecter,"/resource");

    resource:any = {};


    save(id:any):void {
        if (this.resource ==null){
            return;
        }

        this.restService.update(id, this.resource).then(()=> {
                this.router.navigate(["/resource"]);
            });

    }
    

     ngOnInit():void {
         this.active.params.forEach((params: Params) => {
             var id = params['id'];
             if(!id){
                 return;
             }
             this.restService.get(id).then((result)=>{
                 this.resource=result;
                 //alert(JSON.stringify(this.resource));
             })
         });
     }
}

