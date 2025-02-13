
console.log(`example1.js 실행`);

// 1. js 자료
console.log(3);                //숫자 Number   정수
console.log(3.14);             // Nnmber      실수 
console.log(true);             // boolean     논리

console.log(null);             // null        객체없어요
console.log(undefined);        // undefined   정의없어요

console.log("안녕!");           // string      ""
console.log('안녕!');           // string      ''
console.log(`안녕!`);           // string // 주로 사용 하겠어요! ``

console.log([3,3.14,true,`안녕!`]); // array     []
console.log(function 함수명(){});   // function  함수

console.log({"속성명1" : 3 ,"속성명2" : `안녕!`});      // object  {}

// * let 변수 선언 키워드 , const 상수 선언 키워드

// 2. js 함수
   
// (1) 선언적 함수 : function 함수명 ( 매개변수명 , 매개변수명 ){ 실행문 ;}
  
   function func1( a, b ){ // (정의/만들기)
	let c = a + b;
	return c;
   } // fe
   
   let result = func1( 3 ,4 );          // 함수 호출|사용
   console.log(result1);
   
   // (2) 익명 함수 : function( 매개변수명 , 매개변수명 ){ 실행문 ;}
    const func2 = function( a ,b ){ // (정의/만들기)
	let c = a + b; return c;
   } //fe
   
   let result2 = func2( 5 , 1 );
   console.log(result2);                   // 함수 호출|사용
   
   
   // (3) 람다식(화살표) 함수 : (매개변수명 , 매개변수명)=> { 실행문; }
   const fuc3 = (a,b) => {                   
	console.log(`func3 execute`)                // (정의/만들기)
	c = a+b; return c;
	}
	let result3 = fun3(10,7);
	console.log( result3 )                        // 함수 호출|사용
   
	
	// (4) 람다식 함수의 활용처를 알아보아요
	const words = [ '사과' , '수박' , '딸기' , '오렌지' ]
   // 예 - 배열 내 모든 요소 값들을 하나씩 출력하세요
   // (1) for
   for(let index =0; index <= words.length-1; index++){
	console.log(words[index]);
   }
   
   // (2) forEach( (반복변수명) => {실행문} ) 함수 // 배열 내 요소를 하나씩 반복변수명에 대입
   words.forEach( (word) => { console.log( word ) } );
   
   // (3) 배열변수명.map // 배열내 요소를 하나씩 반복변수명에 대입 반복실행
   words.map( (word) => { console.log( word ) } );
   
   // (4) (*) forEach 와 map 함수의 차이점
       // forEach 는 return 지원하지 않아요.
   let newWords1 = words.forEach(( i )=>{ return i; } );
   
       // map 은 return 지원해요.
   let newWords2 = words.map((j) => {return j; } );   
   