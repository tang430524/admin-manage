/**
 * Created by qiangxie on 2016/10/28.
 */
import {Headers, Http} from "@angular/http";
import "./rxjs-extention";
import {Injectable} from "@angular/core";

@Injectable()//非Component需要加此注解才能注入
export class HttpUtil {


    constructor(private http:Http) {

    }

    getWithJsonContentType(url:string):Promise<any> {
        return this.http.get(url, {headers: this.getJsonHeader()}).toPromise()
            .then((response) => {
                return response.json();
            });
    }


    put(url:string, data:any):Promise<void> {
        return this.http.put(url, data, {headers: this.getJsonHeader()}).toPromise().then(response=>null);
    }

    getJsonHeader():Headers {
        return new Headers({'Content-Type': 'application/json', 'x-auth-token': sessionStorage.getItem("token")});

    }
}