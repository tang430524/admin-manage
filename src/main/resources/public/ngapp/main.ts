/**
 * Created by xieqiang on 2016/9/25.
 */
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app.module.ts';
const platform = platformBrowserDynamic();
platform.bootstrapModule(AppModule);

