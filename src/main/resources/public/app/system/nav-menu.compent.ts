import {Component, OnInit} from "@angular/core";
import {HttpUtil} from "../shard/HttpUtil";

@Component({
    moduleId: module.id,
    selector: 'nav-menu',
    templateUrl: 'nav-menu.html'
})
export class NavMenuComponent implements OnInit {

    menus:Menu[];

    constructor(private http:HttpUtil) {
    }

    ngOnInit():void {
        this.http.getWithJsonContentType("/user/nav").then((response)=> {
            this.menus = response;
        });
    }

}

 class Menu{
    label:string;
    url:string;
     type:number;
     style:string;
     childNodes:Menu[];

}
