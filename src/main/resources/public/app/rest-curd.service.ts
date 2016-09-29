/**
 * Created by qiangxie on 2016/9/29.
 * 基于rest+json协议的curd服务类
 */

/**
 * Created by qiangxie on 2016/9/28.
 */
import { Injectable }    from '@angular/core';
import { Injector }    from '@angular/core';
import { Headers, Http } from '@angular/http';
import './rxjs';

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
                return response.json() as T[] ;
            });
    }
    
    save(T): Promise<void> {
        return this.http.post(this.resourceUrl, JSON.stringify(T), {headers: this.headers}).toPromise()
            .then(response =>null);
    }

    update(T): Promise<void> {
        return this.http.put(this.resourceUrl, JSON.stringify(T), {headers: this.headers}).toPromise()
            .then(response =>null);
    }

    delete(id:string): Promise<void> {
        return this.http.delete(this.resourceUrl+"/"+id, {headers: this.headers}).toPromise()
            .then(response =>null);
    }

    switchStatus(id:string,disable:boolean): Promise<void> {
        return this.http.put(this.resourceUrl+"/"+id+"/"+disable, {headers: this.headers}).toPromise()
            .then(response =>null);
    }

    get(id:string): Promise<T> {
        return this.http.get(this.resourceUrl+"/"+id, {headers: this.headers}).toPromise()
            .then(response => (response.json() as T));
    }

}

