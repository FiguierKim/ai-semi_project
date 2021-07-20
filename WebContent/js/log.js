$(document).ready(function() {
	$('#loginBtn').click(function() {

		const id = $('#id').val();
		const pw = $('#pw').val();

		$.post("main",
			{
				sign: "login",
				id,
				pw
			},
			function(data, status) {
				data = JSON.parse(data);
				console.log(data);
				if (data.msg) {			// 로그인 실패
					alert(data.msg);
				} else {					// 로그인 성공
					$.cookie("id", data.id, { path: '/' });
					document.getElementById("welcomeMsg").innerHTML = data.id + "님 환영합니다 <button id='logoutBtn'>로그아웃</button>";
				}
			}
		);

	});

});



