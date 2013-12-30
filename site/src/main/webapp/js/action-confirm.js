$('a[data-confirm]').click(function(ev) {
         var href = $(this).attr('href');
         if (!$('#dataConfirmModal').length) {
             $('body').append('<div class="modal fade" id="dataConfirmModal" tabindex="-1"'+
            			'role="dialog" aria-labelledby="dataConfirmLabel" aria-hidden="true">'+
            			'<div class="modal-dialog">'+
            				'<div class="modal-content">'+
            					'<div class="modal-header">'+
            						'<button type="button" class="close" data-dismiss="modal"'+
            							'aria-hidden="true">&times;</button>'+
            						'<h4 class="modal-title" id="dataConfirmLabel">Please Confirm</h4>'+
            					'</div>'+
            					'<div class="modal-body"></div>'+
            					'<div class="modal-footer">'+
            						'<a href="#" class="btn btn-default" data-dismiss="modal"><i class="glyphicon glyphicon-remove-sign"></i>Cancel</a>'+
            						'<a href="#" class="btn btn-success" id="dataConfirmOK"><i class="glyphicon glyphicon-ok-sign"></i>OK</a>'+
            					'</div>'+
            				'</div>'+
            			'</div>'+
            		'</div>');
         }
         $('#dataConfirmModal').find('.modal-body').text("Are you sure you want to delete?");
         $('#dataConfirmOK').attr('href', href);
         $('#dataConfirmModal').modal({show:true});
         return false;
     });