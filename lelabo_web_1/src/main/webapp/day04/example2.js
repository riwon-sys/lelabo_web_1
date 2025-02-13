
// [1]  람다식 함수 정의
// const 상수명 = () => {}
const func1  = () =>{
	console.log('func1 execute');
} // fe

// [2] 람다식 함수 정의 안에서 fecth 함수 활용
const func2 = () =>{
	
	// (*) fetch : http 비동기 통신 제공하는 함수
	// day02 에 example1 서브릿 클래스의 get 메소드 aovld
	fetch(`http://localhost:8080/lelabo_web_1/day02/example1`)
} // fe

const func3 = () =>{
	fetch(`/lelabo_web_1/day02/example1`, { method : 'POST'} )
} //fe

const func4 = () =>{
	fetch(`/lelabo_web_1/day02/example1`, {method : 'PUT'})
} //fe

const func5 = () =>{
	fetch(`/lelabo_web_1/day02/example1`, {method : 'DELETE'})
} //fe

const func6 = () =>{
	let name = '유재석'; let age =20;
	
	fetch(`/lelabo_web_1/day02/example2?name=${name}&age=${ age }`)
} //fe

const func7 = () =>{
	let name = '신동엽'; let age =30;
	const option = {method : 'POST'}
	fecth( `/lealbo_web_1/day02/example2?name=${ name }&age=${ age }` , option )
} //fe

const fucc8 = () =>{
	let name = '서장훈'; let age =10;
	const option = {method : 'PUT'}
	fecth( `/lelabo_web_1/day02/example2?name=${ name }&age=${ age }` , option)
} //fe

const func9 = () =>{
	let name = "김희철"; let age =50;
	const option = {method : 'DELETE'}
	fecth( `/lelabo_web_1/day02/example2?name=${ name }&age=${ age }` , option )
} //fe

const func10 = () =>{
	let object = { data1 : '유재석' , data2 : 50 }
	const option = {
		method : 'POST' ,
		headers : { 'Content-Type' : 'application/json' } ,
		body : JSON.stringify( object ) // http 의 두번째 text
	} // oe
fetch( `/lelabo_web_1/day03/example3` , option );
}

const func11 = () => {
	let object = { data1 : '강호동' , data2 : 40 }
	const option = {
		method : 'PUT' ,
		headers : { 'Content-Type' : 'application/json' } ,
		body : JSON.stringify( object ) // http 의 두번째 text
	} // oe
fetch( `/lelabo_web_1/day03/example3` , option );	
}

const func12 = () => {
	const option = { method : 'GET' }
	fetch( `/lelabo_web_1/day03/example5` , option )
	.then( response => response.json() )
	.then( data => { console.log(data); })
} // fe

const func13 = () => {
	const option = { method : 'POST' }
	fetch( `/lelabo_web_1/day03/example5` , option )
	.then( response => response.text() )
	.then( data => { console.log(data); })
} // fe

const func14 = () => {
	const option = { method : 'PUT' }
    fetch( ` /lelabo_web_1/day03/example5` , option )
	.then( response => response.json() )
	.then( data => { console.log(data); })
	.catch( error => {console.log( error ); })
} //fe

const func15 = () => {
	const option = { method : 'DELETE' }
	fetch(` /lelabo_web_1/day03/example5` , option )
	.then( response => response.json() )
	.then( data => {console.log(data); })
	.catch( error => {console.log(error); })
}


/*

fetch ( ` http url ` , {옵션} )
      - GET : fetch(`/lelabo__web_1/day02/example1`, {method : `GET`})
	  - POST : fetch(`/lelabo__web_1/day02/example1`, {method : `POST`})
	  - PUT : fetch(`/lelabo__web_1/day02/example1`, {method : `PUT`})
	  - DELETE : fetch(`/lelabo__web_1/day02/example1`, {method : `DELETE`})
	  
`` : 백틱 템플릿 : 문자열 사이에 변수/함수 호출 과 연산식을 넣을 수 있는 템플릿
`문자열 $ {변수명} 문자열${ 함수명()} 문자열 ${연산}`	  


header : { 'Content-Type' : 'application/json' } 


*/