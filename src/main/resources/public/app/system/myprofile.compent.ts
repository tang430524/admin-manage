import {Component, OnInit} from "@angular/core";
import {HttpUtil} from "../shard/HttpUtil";
import {Location} from "@angular/common";
import {MyProfile} from "../shard/MyProfile";
@Component({
    moduleId: module.id,
    selector: 'my-profile',
    templateUrl: 'my-profile.html'
})
export class MyProfileComponent implements OnInit {

    constructor(private http:HttpUtil, private location:Location) {

    }

    myinfo:MyProfile;
    updateInfo:UpdateProfile = new UpdateProfile();

    save():void {

        this.http.put('/user/profile', JSON.stringify(this.updateInfo)).then(()=> {
            this.location.back();
        });

    }


    ngOnInit():void {
        this.http.getWithJsonContentType('/user/profile').then((result)=> {
            this.myinfo = result;
            this.updateInfo = new UpdateProfile();
            this.updateInfo.email = this.myinfo.email;
            this.updateInfo.password = "";
        })
    }

}


class UpdateProfile {
    email;
    password;
}

