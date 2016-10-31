/**
 * Created by qiangxie on 2016/9/29.
 * 基于rest+json协议的curd服务类
 */

/**
 * Created by qiangxie on 2016/9/28.
 */
import {Injector} from "@angular/core";
import {Headers, Http} from "@angular/http";
import "./rxjs-extention";

//@Injectable()
export class RestCurdService<T> {
    private headers = new Headers({'Content-Type': 'application/json'});
    private http:Http;
    constructor(inject:Injector,public resourceUrl:string) {
        this.http=inject.get(Http);
    }

    list():Promise<T[]>{
        return this.http.get(this.resourceUrl, {headers: this.headers}).toPromise()
            .then((response) => {
                if (response._body == "") {
                    return [];
                }
                return response.json() as T[] ;
            });
    }
    
    save(T): Promise<void> {
        return this.http.post(this.resourceUrl, JSON.stringify(T), {headers: this.headers}).toPromise()
            .then(response =>null);
    }

    update(id:any, T):Promise<void> {
        return this.http.put(this.resourceUrl + "/" + id, JSON.stringify(T), {headers: this.headers}).toPromise()
            .then(response =>null);
    }

    delete(id:any):Promise<void> {
        return this.http.delete(this.resourceUrl+"/"+id, {headers: this.headers}).toPromise()
            .then(response =>null);
    }

    switchStatus(id:any, disable:boolean):Promise<void> {
        return this.http.put(this.resourceUrl+"/"+id+"/status?disable="+disable, {headers: this.headers}).toPromise()
            .then(response =>null);
    }

    get(id:any):Promise<T> {
        return this.http.get(this.resourceUrl+"/"+id, {headers: this.headers}).toPromise()
            .then(response => (response.json() as T));
    }

}

