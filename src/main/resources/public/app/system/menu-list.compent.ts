import {Component, OnInit, Injector} from "@angular/core";
import {Router} from "@angular/router";
import {RestCurdService} from "../shard/rest-curd.service";

@Component({
    moduleId: module.id,
    selector: 'menu-list',
    templateUrl: 'menu-list.html'
})
export class MenuListComponent implements OnInit {

    constructor(private router:Router, private indecter:Injector) {

    }

    restService:RestCurdService<Object[]> = new RestCurdService<Object[]>(this.indecter, "/menu");

    menus:any;

    newClick(parentId:string):void {
        this.router.navigate(["/menu/form", parentId]);
    }

    itemClick(id:string):void {
        this.router.navigate(["/menu/detail", id]);
    }

    changeStatus(id:string, disable:boolean):void {
        this.restService.switchStatus(id, !disable).then(()=> {
            this.menus.forEach((u)=> {
                if (u.id == id) {
                    u.disabled = !disable;
                }
            });
        });
    }

    del(id:string):void {
        this.restService.delete(id).then(()=> {
            // this.menus = this.menus.filter((u:Object)=> {
            //     u.id != id;
            // });
            let news=[];
            this.menus.forEach((u)=> {
                if (u.id != id) {
                    news.push(u);
                }
                this.menus=news;
            });


        });
    }


    ngOnInit():void {
        this.restService.list().then(data => {
                this.menus = (data as Object[]);
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
