"use strict";
var router_1 = require('@angular/router');
var login_compent_1 = require('./login.compent');
var dashbord_compent_1 = require("./dashbord.compent");
var appRoutes = [
    {
        path: 'login',
        component: login_compent_1.LoginComponent
    },
    {
        path: 'dashbord',
        component: dashbord_compent_1.DashBordComponent
    },
    {
        path: '',
        redirectTo: '/login',
        pathMatch: 'full'
    }
];
exports.routing = router_1.RouterModule.forRoot(appRoutes);
//# sourceMappingURL=app.routing.js.map