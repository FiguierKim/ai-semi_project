$(document).ready(function(){

	let id=$.cookie('id');
	if(id){
		document.getElementById("welcomeMsg").innerHTML=id+"님 환영합니다 <button id='logoutBtn'>로그아웃</button>";
	}
	
	//로그아웃
	$(document).on('click','#logoutBtn',function(){
		
		    $.post('main',
		    	{sign : "logout"},
		    	function(data){	
		    		$.removeCookie('id',{path:'/'}); 	
		    		location.reload();
		    	}
		    );
		
	});
});




