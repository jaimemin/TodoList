let buttonList = document.getElementsByTagName('button');
for (let button = 0; button < buttonList.length; button++) {
	buttonList[button].addEventListener('click', ajax);
}

function ajax(event) {
	let button = event.target;
	let status = button.getAttribute('buttonStatus');
	let id = button.getAttribute('buttonId');
	// url 앞에 .을 추가 안해줄 경우 403 에러가 발생하는데 이유가 궁금합니다.
	let url = "./todo-update/" + status + "/" + id;

	let xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200
				&& this.responseText === 'updated') {
			let todoCard = button.parentNode.parentNode;
			console.log("applied");
			if (status === 'TODO') {
				button.setAttribute('buttonStatus', 'DOING');
				document.querySelector('#DOING').appendChild(todoCard);
			} else if (status === 'DOING') {
				button.setAttribute('buttonStatus', 'DONE');
				button.style.display = 'none';
				document.querySelector('#DONE').appendChild(todoCard);
			}
		} else {
			console.log(this.readyState);
			console.log(this.status);
			console.log(this.responseText);

			if (this.responseText === 'failed') {
				console.log('error occured on update');
			} else {
				console.log('error occured on ajax');
			}
		}
	}

	// update이기 때문에 PUT 메서드 사용
	xmlHttpRequest.open('PUT', url, true);
	// 키와 값을 =와 함께 표현하고 &의 묶음으로 표현하는 데이터 구조
	xmlHttpRequest.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded; charset=UTF-8");
	xmlHttpRequest.send();
}