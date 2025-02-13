// [1] 게시물 등록
const boardWrite = () => {
    // 1) HTML에서 입력창(DOM 요소) 가져오기
    let writerInput = document.querySelector('.writerInput');
    let pwdInput = document.querySelector('.pwdInput');
    let titleInput = document.querySelector('.titleInput');
    let contentInput = document.querySelector('.contentInput');  // ★ 주의: '.contentInput' (도트 . 누락 주의)

    // 2) 가져온 DOM 요소들에서 실제 입력값(value)을 꺼내오기
    let bwriter = writerInput.value;
    let bpwd = pwdInput.value;
    let btitle = titleInput.value;
    let bcontent = contentInput.value;

    // 3) 객체(자바스크립트 오브젝트)로 묶기
    let dataObj = {
        bwriter : bwriter,
        bpwd : bpwd,
        btitle : btitle,
        bcontent : bcontent
    }

    // 4) fetch로 서버에 전송할 옵션 설정
    const option = {
        method : 'POST',
        headers : { 'Content-Type' : 'application/json' }, // 주의: 소문자 headers
        body : JSON.stringify(dataObj)                     // JS 객체 → JSON 문자열
    }

    // 5) fetch로 서버 요청 보내기 (URL: '/lelabo_web_1/day06/board6')
    fetch('/lelabo_web_1/day06/board6', option)
    .then(response => response.json()) // 응답을 JSON으로 파싱
    .then(data => {
        // data == true면 글쓰기 성공, false면 실패라고 가정
        if (data == true) {
            alert('글쓰기 성공!');
            location.href = "/lelabo_web_1/day06/board.jsp"; // 글 목록 페이지 등으로 이동
        } else {
            alert('글쓰기 실패 ㅠㅠ');
        }
    })
    .catch(error => {
        alert('시스템 오류 : 관리자에게 문의하세요!');
        console.log(error); // 에러 디버깅용
    })
}  // function end