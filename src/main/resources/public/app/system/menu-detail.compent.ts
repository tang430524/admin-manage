import {Component, OnInit, Injector} from "@angular/core";
import {Router, ActivatedRoute, Params} from "@angular/router";
import {RestCurdService} from "../shard/rest-curd.service";

@Component({
    moduleId: module.id,
    selector: 'menu-detail',
    templateUrl: 'menu-detail.html'
})
export class MenuDetailComponent implements OnInit{

    constructor(private router: Router,private indecter:Injector,private active:ActivatedRoute) {

    }

    restService:RestCurdService<Object>=new RestCurdService<Object>(this.indecter,"/menu");

    menu:any = {};


    save(id:any):void {
        if (this.menu ==null){
            return;
        }

        this.restService.update(id, this.convert(this.menu)).then(()=> {
                this.router.navigate(["/menu"]);
            });

    }

    convert(menu:any):UpdateMenuVo{
        let vo=new UpdateMenuVo();
        vo.label=menu.label;
        vo.order=menu.order;
        vo.url = menu.url;
        return vo;
    }
    

     ngOnInit():void {
         this.active.params.forEach((params: Params) => {
             var id = params['id'];
             if(!id){
                 return;
             }
             this.restService.get(id).then((result)=>{
                 this.menu=result;
                 //alert(JSON.stringify(this.menu));
             })
         });
     }
}

class UpdateMenuVo{
    id:string;
    label:string;
    order:number;
    url:string;
}

