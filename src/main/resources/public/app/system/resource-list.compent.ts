import {Component, OnInit, Injector} from "@angular/core";
import {Router} from "@angular/router";
import {RestCurdService} from "../shard/rest-curd.service";

@Component({
    moduleId: module.id,
    selector: 'resource-list',
    templateUrl: 'resource-list.html'
})
export class ResourceListComponent implements OnInit {

    constructor(private router:Router, private indecter:Injector) {

    }

    restService:RestCurdService<Object[]> = new RestCurdService<Object[]>(this.indecter, "/resource");

    resources:any;

    newClick():void {
        this.router.navigate(["/resource/form"]);
    }

    itemClick(id:string):void {
        this.router.navigate(["/resource/detail", id]);
    }

    changeStatus(id:string, disable:boolean):void {
        this.restService.switchStatus(id, !disable).then(()=> {
            this.resources.forEach((u)=> {
                if (u.id == id) {
                    u.disabled = !disable;
                }
            });
        });
    }

    del(id:string):void {
        this.restService.delete(id).then(()=> {
            // this.resources = this.resources.filter((u:Object)=> {
            //     u.id != id;
            // });
            let news=[];
            this.resources.forEach((u)=> {
                if (u.id != id) {
                    news.push(u);
                }
                this.resources=news;
            });


        });
    }


    ngOnInit():void {
        this.restService.list().then(data => {
                this.resources = (data as Object[]);
            }
        );
    }



    disabled(disable):string {
        if (disable) {
            return "禁用";
        }
        return "启用";
    }
}
