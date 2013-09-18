<%@include file="../../includes/tags.jspf" %>
<div class="modal hide" id="modal">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">x</button>
    <h3><w4india:resellername/> Tutorial</h3>
  </div>
  <div class="modal-body">      
    <p>One fine body</p>
  </div>
  <div class="modal-footer">
    <a href="#" class="btn" data-dismiss="modal">Close</a>
  </div>
</div>
<script type="text/javascript">
//for main.jsp (Main home page in their Text-widget)
$('#itr1').on('click',function(){
	$('div.modal-body').html('<iframe width="500" height="281" src="//www.youtube.com/embed/N8uSYsth98I?list=PLmKJmEkZclKGvO_9sOtrcw2OqXHqz0g4r" frameborder="0" allowfullscreen></iframe>');  
});
//for main.jsp (Main home page in their Text-widget)
$('#itr2,#itr3,#itr4,#itr5').on('click',function(){
	$('div.modal-body').html('<iframe width="500" height="281" src="//www.youtube.com/embed/RcqDH2w3Wb4" frameborder="0" allowfullscreen></iframe>');  
});
//for cara.jsp (Carousel) on home page Individual and HUF
$('#huf_invdl').on('click',function(){
	$('div.modal-body').html('<iframe width="500" height="281" src="//www.youtube.com/embed/N8uSYsth98I?list=PLmKJmEkZclKGvO_9sOtrcw2OqXHqz0g4r" frameborder="0" allowfullscreen></iframe>');
 });    
//for cara.jsp (Carousel) on home page eZ File
 $('#ezFile').on('click', function() {
	$('div.modal-body').html('<iframe width="500" height="281" src="//www.youtube.com/embed/RcqDH2w3Wb4" frameborder="0" allowfullscreen></iframe>');
});
//for cara.jsp (Carousel) on home page e File
$('#eFile').on('click', function() {
	$('div.modal-body').html('<iframe width="500" height="281" src="//www.youtube.com/embed/N8uSYsth98I" frameborder="0" allowfullscreen></iframe>');
});
$('#modal').on('hide', function () {
	  $('div.modal-body').html('');  
	});
</script>