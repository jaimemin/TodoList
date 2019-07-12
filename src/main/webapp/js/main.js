let buttonList = document.getElementsByTagName('button');
Array.from(buttonList).forEach((button) => {
	button.addEventListener('click', ajax);
});

function ajax(event) {
	let button = event.target;
	let status = button.getAttribute('buttonStatus');
	let id = button.getAttribute('buttonId');
	let parameter = `status=${status}&id=${id}`;

	let xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = () => {
		if (xmlHttpRequest.readyState === 4) {
			if (xmlHttpRequest.status >= 400){
				alert("에러 발생! 잠시 후에 서비스를 이용해주세요.")
				return;
			}
			
			let todoCard = button.parentNode.parentNode;
			let changedStatus = (status === 'TODO') ? 'DOING' : 'DONE';
			
			if (changedStatus === 'DONE') {
				button.style.display = 'none';
			}
			
			button.setAttribute('buttonStatus', changedStatus);
			document.querySelector('#' + changedStatus).appendChild(todoCard);
		}
	}
	
	// async = true
	xmlHttpRequest.open('POST', "/TodoList/todo-update", true);
	// 키와 값을 =와 함께 표현하고 &의 묶음으로 표현하는 데이터 구조
	xmlHttpRequest.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded; charset=UTF-8");
	xmlHttpRequest.send(parameter);
}