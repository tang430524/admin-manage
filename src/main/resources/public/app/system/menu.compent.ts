import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";

@Component({
    moduleId: module.id,
    selector: 'nav-menu',
    templateUrl: 'menu.html'
})
export class MenuComponent implements OnInit {

    menus:Menu[];

    constructor(private http:Http) {
    }

    ngOnInit():void {
        this.http.get("/user/nav").toPromise().then((response)=>{
            this.menus=response.json() as Menu[];
        });
    }

}

 class Menu{
    label:string;
    url:string;
    items:Menu[];

}
