import {Component, Injector, OnInit} from "@angular/core";
import {Router, ActivatedRoute, Params} from "@angular/router";
import {RestCurdService} from "../shard/rest-curd.service";

@Component({
    moduleId: module.id,
    selector: 'menu-form',
    templateUrl: 'menu-form.html'
})
export class MenuFormComponent implements OnInit{

    constructor(private router: Router,private indecter:Injector,private active:ActivatedRoute) {

    }

    restService:RestCurdService<Object>=new RestCurdService<Object>(this.indecter,"/menu");

    menu:CreateMenuVo=new CreateMenuVo();
   
    save():void{
       
        this.restService.save(this.menu).then(()=>{
            this.router.navigate(["/menu"]);
        });

    }

    ngOnInit():void {
        this.active.params.forEach((params: Params) => {
            let parentPath= params['path'];
            this.menu.path=parentPath;
        });
    }


}

class CreateMenuVo{
    label:string;
    order:number;
    path:string;
    url:string;
}

