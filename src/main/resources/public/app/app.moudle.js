"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var platform_browser_1 = require('@angular/platform-browser');
var forms_1 = require('@angular/forms');
var http_1 = require('@angular/http');
var login_compent_1 = require('./login.compent');
var app_routing_1 = require('./app.routing');
var app_compent_1 = require("./app.compent");
var dashbord_compent_1 = require("./dashbord.compent");
var user_compent_1 = require("./user.compent");
var login_service_1 = require('./login.service');
require('rxjs/add/operator/toPromise');
var user_form_compent_1 = require("./user-form.compent");
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            imports: [
                platform_browser_1.BrowserModule,
                forms_1.FormsModule,
                app_routing_1.routing,
                http_1.HttpModule
            ],
            providers: [
                login_service_1.LoginService
            ],
            declarations: [login_compent_1.LoginComponent, app_compent_1.AppComponent, dashbord_compent_1.DashBordComponent, user_compent_1.UserComponent, user_form_compent_1.UserFormComponent],
            bootstrap: [app_compent_1.AppComponent]
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;
/**
 * Created by qiangxie on 2016/9/24.
 */
//# sourceMappingURL=app.moudle.js.map