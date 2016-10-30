import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {BrowserModule} from "@angular/platform-browser";
import {HttpUtil} from "./HttpUtil";
import {HeaderComponent} from "./layout/header.compent";
import {FooterComponent} from "./layout/footer.compent";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule
    ],
    providers: [
        HttpUtil
    ],
    declarations:[HeaderComponent,FooterComponent],
    exports:[BrowserModule,FormsModule,HttpModule,HeaderComponent,FooterComponent]
})
export class ShareModule { }
/**
 * Created by qiangxie on 2016/9/24.
 */
