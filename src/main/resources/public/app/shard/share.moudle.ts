import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {BrowserModule} from "@angular/platform-browser";
import {HttpUtil} from "./HttpUtil";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule
    ],
    providers: [
        HttpUtil
    ],
    exports:[BrowserModule,FormsModule,HttpModule]
})
export class ShareModule { }
/**
 * Created by qiangxie on 2016/9/24.
 */
