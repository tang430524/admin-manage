/**
 * Created by qiangxie on 2016/9/28.
 */
import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

@Injectable()
export class LoginService {
    private headers = new Headers({'Content-Type': 'application/x-www-form-urlencoded'});
    private url = '/login';  // URL to web api
    constructor(private http:Http) {
    }

    login(username,password,remember): Promise<boolean> {
        return this.http.post(this.url, `username=${username}&password=${password}&remember-me=${remember}`, {headers: this.headers}).toPromise()
            .then((response) => {
                return response.ok;
            });
    }

}