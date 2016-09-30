/**
 * Created by xieqiang on 2016/9/25.
 */

//及时编译
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import {AppModule} from "./app.moudle";
const platform = platformBrowserDynamic();
platform.bootstrapModule(AppModule);


//预编译
// The browser platform without a compiler
// import { platformBrowser } from '@angular/platform-browser';
//
// // The app module factory produced by the static offline compiler
// import { AppModuleNgFactory } from '../aot/app/app.moudle.ngfactory';
//
// // Launch with the app module factory.
// platformBrowser().bootstrapModuleFactory(AppModuleNgFactory);
