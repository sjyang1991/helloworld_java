
/**
 * Module dependencies.
 */

var express = require('express')
  , routes = require('./routes')
  , user = require('./routes/user')
  , http = require('http')
  , path = require('path');

var app = express();

// all environments
app.set('port', process.env.PORT || 3000);
app.set('views', __dirname + '/views');
app.set('view engine', 'jade');
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());
app.use(express.methodOverride());
app.use(app.router);
app.use(express.static(path.join(__dirname, 'public')));

// development only
if ('development' == app.get('env')) {
  app.use(express.errorHandler());
}
/////////////////////MYSQL 접속///////////////////////////////////////////
var mysql      = require('mysql');
var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : 'test',
  database : 'didimdol'
});
 
connection.connect();

app.get('/', function(req,res){
	connection.query('select * from board',
			function(err, results, fields){
		if (err) res.send(err);
		else res.render('index', 
				{title:'게시판 글목록', boards:results});
	});
});

app.get('/write', function(req,res){
	res.render('write', {title:'글쓰기'});
});

app.post('/write',function(req,res){
	connection.query("insert into board (title,writer,contents,created_at) values(?,?,?,?)",
			[
				req.body.title,
				req.body.writer,
				req.body.contents,
				new Date()
			], function(err, result){
				res.redirect('/');
			});
});
//app.get('/', routes.index);
app.get('/users', user.list);

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
