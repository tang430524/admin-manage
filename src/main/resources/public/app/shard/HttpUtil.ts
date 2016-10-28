/**
 * Created by qiangxie on 2016/10/28.
 */
import {Headers, Http} from "@angular/http";
import "./rxjs-extention";
import {Injectable} from "@angular/core";

@Injectable()//非Component需要加此注解才能注入
export class HttpUtil {

    private jsonHeaders = new Headers({'Content-Type': 'application/json'});

    private formHeaders = new Headers({'Content-Type': 'application/x-www-form-urlencoded'});

    constructor(private http:Http) {

    }

    getWithJsonContentType(url:string):Promise<any> {
        return this.http.get(url, {headers: this.jsonHeaders}).toPromise()
            .then((response) => {
                return response.json();
            });
    }

    getWithFormType(url:string):Promise<any> {
        return this.http.get(url, {headers: this.formHeaders}).toPromise()
            .then((response) => {
                return response.json();
            });
    }

    put(url:string, data:any):Promise<void> {
        return this.http.put(url, data, {headers: new Headers({'Content-Type': 'application/json'})}).toPromise().then(response=>null);
    }
}