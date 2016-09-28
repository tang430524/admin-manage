/**
 * Created by qiangxie on 2016/9/28.
 */
import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';
import './rxjs';

@Injectable()
export class LoginService {
    private headers = new Headers({'Content-Type': 'application/x-www-form-urlencoded'});
    private url = '/login';  // URL to web api
    constructor(private http:Http) {

    }

    login(username,password,remember): Promise<void>{
        return this.http.post(this.url,`username=${username}&password=${password}&remember-me=${remember}`,{headers: this.headers}).toPromise().then(response=>{
             response.ok as Boolean;
        }).catch(this.handleError);;
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    }

}