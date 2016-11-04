import {Component, OnInit} from "@angular/core";
import {HttpUtil} from "../HttpUtil";
import {Router} from "@angular/router";
import {MyProfile} from "../MyProfile";
@Component({
    moduleId: module.id,
    selector: 'header-compent',
    templateUrl: 'header.html'
})
export class HeaderComponent implements OnInit {
    user:MyProfile;

    constructor(private http:HttpUtil, private router:Router) {
    }


    ngOnInit():void {
        this.http.getWithJsonContentType("/user/profile").then((rep) => {
            this.user = rep;
        });
    }

    goprofile():void {
        this.router.navigate(['/user/my-profile']);
    }
    
   
}


