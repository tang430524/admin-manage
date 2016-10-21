import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {OnInit} from '@angular/core';
import {Injector}    from '@angular/core';
import {Http} from "@angular/http";
import {RestCurdService} from "../shard/rest-curd.service";

@Component({
    moduleId: module.id,
    selector: 'syslog-list',
    templateUrl: 'syslog.html'
})
export class SyslogComponent implements OnInit {

    constructor(private http:Http, private indecter:Injector) {

    }

    restService:RestCurdService<Object[]> = new RestCurdService<Object[]>(this.indecter, "/syslog");

    syslogs:any;

    clear():void {
        if(!confirm("确认清除日志?")){
            return;
        }
        this.http.delete("/syslog").toPromise().then((response)=>{
            this.syslogs=[];
        });
    }

  

    ngOnInit():void {
        this.restService.list().then(data => {
                this.syslogs = (data as Object[]);
            }
        );
    }
    
}
