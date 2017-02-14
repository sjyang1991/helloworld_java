
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
//////////////////////MongoDB 접속////////////////////////////////////////
var MongoClient = require('mongodb').MongoClient;
//Connection URL 
var url = 'mongodb://localhost:27017/didimdol';
//Use connect method to connect to the Server 
var dbObj = null;
MongoClient.connect(url, function(err, db) {
	console.log("Connected correctly to server");
	dbObj = db;
//	db.close();
});
///////////////////////////////////////////////////////////////////////////

app.get('/', function(req, res){//영화 전체 목록 조회
	connection.query('select * from movie', 
				function (error, results, fields) {//여기서만 results 이다 나머지 insert, delete, update는 result
		  if (error) res.send(error);
		  else {
			  var movie = dbObj.collection('movie');
			  movie.find({}).toArray(function(error,docs){	//MongoDB 조회 쿼리
				  if(error) res.send(error);
				  else {//APPLICATION SIDE JOIN-------------------
					  for(var i=0 ; i < results.length ; i++){
						  for( var j=0 ; j < docs.length ; j++){
							  if (results[i].no == docs[j].no){
								  results[i].review = docs[j].review;
								  break;
							  }
						  }
					  }
					  res.send(JSON.stringify(results));
				  }
			  });
		}
});
//connection.end();
});
app.get('/movie', function(req, res){//학생 목록 조회
	connection.query('select * from movie where no=?',
				req.query.no,
				function (error, results, fields) {
		  if (error) res.send(error);
		  else res.send(JSON.stringify(results));
		});
		//connection.end();
});
app.post('/',function(req,res){//학생 정보 추가
	connection.query('INSERT INTO movie SET ?', 
				{
					title			:req.body.title,
					director		:req.body.director
				}, 
				function (error, result) {
		  if (error) res.send(error);
		  else {
			  if(req.body.review != undefined){
				  var movie = dbObj.collection('movie');
				  movie.save(
						  {
							  no:result.insertId,
							  review:req.body.review
						  }, function(error2,result2){
							  res.send(JSON.stringify(result));
						  });
			  }else{
				  res.send(JSON.stringify(result));
			  }
		  } 
	});
});

app.put('/movie',function(req,res){//학생 정보 수정
	connection.query('UPDATE movie SET ? WHERE no=?', 
			[{
				title			:req.body.title,
				director		:req.body.director,
			},  Number(req.body.no)],
			function (error, result) {
	  if (error) res.send(error);
	  else {
		  if( req.body.review != undefined){
			  var movie = dbObj.collection('movie');
			  movie.update({no:Number(req.body.no)},
					  {'$set':{review:req.body.review}},
					  function(error2, result2){
						  res.send(JSON.stringify(result));
					  });
		  }else{
			  res.send(JSON.stringify(result));
		  }
	  }
	});
});

app.delete('/', function(req,res){
	connection.query("delete from movie",
			function(error,result){
		if(error) res.send(error);
		else res.send(JSON.stringify(result));
	});
});
app.delete('/movie', function(req,res){
	connection.query("delete from movie where no=?",
			Number(req.body.no),
			function(error,result){
		if(error) res.send(error);
		else {
			var movie = dbObj.collection('movie');
			movie.remove({no:Number(req.body.no)}, function(error2, result2) {
					res.send(JSON.stringify(result));
			});
		}
	});
});
app.put('/',function(req,res){
	connection.query("delete from movie", function(error,result){
		consol.log(req.body.movies);
		var movies = JSON.parse(req.body.movies);//문자열을 객체로
		consol.log(movies.length);
		for( var i=0; i < movies.length; i++){
			connection.query("insert into movie set ?", 
					movies[i],
					function(error,result){
				});
		}
		if(error) res.send(error);
		else res.send(JSON.stringify(result));		//객체를 문자열로
	});
});
app.put('/movie', function(req,res){
	connection.query('update movie set ? where no=?',
			[{
				title : req.body.title,
				director:req.body.director
			}, req.body.no],
			function(error, result){
		if (error) res.send(error);
		else res.send(JSON.stringify(result));
	});
});

//app.get('/', routes.index);
app.get('/users', user.list);

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
