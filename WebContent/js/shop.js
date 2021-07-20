$(document).ready(function() {
	$('#basketInsertBtn').click(function() {

		const product = $('input:checkbox[name=product]:checked');

		const product_value = product[0].value;

		$.post("main",
			{
				sign: "basketInsert",
				product_value
			},
			function(data) {
				alert(data);
			}
		);
	});

	$("#basketViewBtn").click(function() {
		$.post('main',
			{ sign: "basketView" },
			function(data) {
				$('#basketViewDiv').html(data);
			}
		);
	});
});