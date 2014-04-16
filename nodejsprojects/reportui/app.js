
/**
 * Module dependencies.
 */

var express = require('express');
var routes = require('./routes');
var user = require('./routes/user');
var http = require('http');
var path = require('path');
var notifications = require('./notifications')


mcapi = require('./node_modules/mailchimp-api/mailchimp')

// New Code
var mongo = require('mongodb');
var monk = require('monk');
var mongoskin = require('mongoskin');

var mandrill = require('mandrill-api/mandrill');
mandrill_client = new mandrill.Mandrill('yYRJJRG8FHmY78Jcyy3qXg');

var app = express();

db = mongoskin.db('mongodb://w4indiaprod:mootly007@wealth4india.com:27017/w4india');
// set MailChimp API key here
mc = new mcapi.Mailchimp('7da5576ec81d13572c3008ac81fd50af-us8');

// all environments
app.set('port', process.env.PORT || 3000);
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');
//app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.json());
app.use(express.urlencoded());
app.use(express.methodOverride());
app.use(express.cookieParser('your secret here'));
app.use(express.session());
app.use(app.router);
app.use(express.static(path.join(__dirname, 'public')));

// development only
if ('development' == app.get('env')) {
  app.use(express.errorHandler());
}

app.get('/', routes.index);
//app.get('/users', user.list);
app.get('/inactivemembers', routes.memberlist(db,notifications,false));

//notifications.sendInactiveReminder("amit@mootly.com","w4india","SADASDASDSAD"); 

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
