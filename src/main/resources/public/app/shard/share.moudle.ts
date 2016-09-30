import { NgModule }            from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { HttpModule }    from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule
    ],

    exports:[BrowserModule,FormsModule,HttpModule]
})
export class ShareModule { }
/**
 * Created by qiangxie on 2016/9/24.
 */
