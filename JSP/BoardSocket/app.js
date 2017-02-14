
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

app.get('/', routes.index);
app.get('/users', user.list);
////////////////////////Mysql 접속//////////////////////////////////////////
var mysql      = require('mysql');
var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : 'test',
  database : 'didimdol'
}); 
connection.connect();
//////////////////////MongoDB 접속////////////////////////////////////////
var MongoClient = require('mongodb').MongoClient;
var ObjectID = require('mongodb').ObjectID;
//Connection URL 
var url = 'mongodb://localhost:27017/didimdol';
//Use connect method to connect to the Server 
var dbObj = null;
MongoClient.connect(url, function(err, db) {
	console.log("Connected correctly to server");
	console.log(err);
	dbObj = db;
//	db.close();
});
var server = http.createServer(app);
var socketio = require('socket.io');
var io = socketio.listen(server);
io.sockets.on('connection',function(socket) {
	console.log('connection');
	socket.on('article_list',function(data){
		connection.query('select * from board',
				function(err, results, fields){
			socket.emit('article_list',
					JSON.stringify(results));
		});
	});
	socket.on('article_delete',function(data){
		data = JSON.parse(data);
		connection.query('delete from board where no=?',
				data.no, function(err, result){
			socket.emit('article_delete', JSON.stringify(result));
		});
	});
	socket.on('article_insert',function(data){
		data = JSON.parse(data);
		connection.query('insert into board set ?',
				{title:data.title,contents:data.contents},
				function(err,result){
			socket.emit('article_insert',JSON.stringify(result));
		});
	});
	socket.on('article_detail',function(data){
		data = JSON.parse(data);
		connection.query('select * from board where no=?', data.no,
				function(err, results, fields){
			if(results.length > 0){
				socket.emit('article_detail',
						JSON.stringify(
								{
									title:results[0].title,
									contents:results[0].contents,
									writer:results[0].writer,
									created_at:results[0].created_at
								}
							));
			}else{
				socket.emit('article_detail',
						JSON.stringify({title:'',contents:'',writer:'',created_at:''}));
			}
		});
	});
	socket.on('comment_insert',function(data){
		data = JSON.parse(data); //문자열을 객체로	
		var board = dbObj.collection('board');
		board.save({
			no:Number(data.no), comment:data.comment, created_at:new Date()
		}, function(err, result){
			socket.emit('comment_insert', JSON.stringify(result));
		});
	});
	socket.on('comment_delete',function(data){
		data = JSON.parse(data);
		var board = dbObj.collection('board');
		board.remove({_id:ObjectID.createFromHexString(data._id)},	//
				function(err, result){
			socket.emit('comment_delete', JSON.stringify(result));
		});
	});
	socket.on('comment_list',function(data){
		data = JSON.parse(data);
		var board = dbObj.collection('board');
		board.find({no:Number(data.no)}).toArray(function(err, results){//data.no 로 게시글의 댓글들을 찾아서 어레이로 바꾸어서 JSON화하여 전송
			socket.emit('comment_list', JSON.stringify(results));
		});
	});
});
server.listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
