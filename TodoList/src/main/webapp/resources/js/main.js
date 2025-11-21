// 제목이 작성되지 않은 경우 form 제출 막기
const addForm = document.querySelector("#addForm"); // form
const title = document.querySelector("[name='title']"); // input 태그 중 name
const detail = document.querySelector("[name='detail']"); // input 태그 중 detail

// addForm이 제출될 때
// 즉, form태그에 제출이라는 이벤트가 발생했을 때!
// form태그 안에 submit 타입으로 버튼을 만드는데,
// 이 버튼이 클릭될 때 submit 이벤트가 발생한다!
addForm.addEventListener("submit", (e) => {
  // 제목에 입력된 값 가져와서 양쪽 공백 제거
  const input = title.value.trim();

  // 제목이 입력되지 않았을 때
  if (input.length === 0) {
    // form 태그 제출 이벤트 막기
    e.preventDefault();
    alert("제목을 입력해주세요!");
    title.focus();
  }
});
