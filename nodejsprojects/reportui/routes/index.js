
/*
 * GET home page.
 */

exports.index = function(req, res){
  res.render('index', { title: 'Express' });
};

exports.memberlist = function(db,notifications,isActive) {
    return function(req, res) {
    	db.collection('w4india_membersignups').find({'mootlywcm:isActive':isActive}).toArray(function(err, result) {
		   	if (err) throw err;
		   	
		   	//BE CAREFUL and COMMENT OUT THIS AS SOON AS YOU ARE DONE TESTINT
		   	//notifications.sendInactiveReminder("amit@mootly.com","w4india","SADASDASDSAD"); 
		   	
		   	
		   	//do NOT ENABLE THIS
		   	/*
		   	for (i =0;i<result.length;i++) {
		   		email = result[i]["mootlywcm:email"];
		   		isActive = result[i]["mootlywcm:isActive"];
		   		activationCode = result[i]["jcr:uuid"];
		   		console.log("email:" + email);
		   		mergeVars = {};
				mc.lists.subscribe({id: "3db00d1b52", email:{email:email},
					merge_vars: {MMERGE4:isActive.toString(),MMERGE5:activationCode},update_existing:!(isActive)}, 
					function(data) {
				      //req.session.success_flash = 'User subscribed successfully! Look for the confirmation email.';
				      //res.redirect('/lists/'+req.params.id);
				      console.log('User subscribed successfully! Look for the confirmation email.');
				    },
				    function(error) {
				      if (error.error) {
				        //req.session.error_flash = error.code + ": " + error.error;
				        console.log(error.code + ":" + error.error);
				      } else {
				        console.log('There was an error subscribing that user');
				      }
				      //res.redirect('/lists/'+req.params.id);
				    });
		   	}
		   	*/
		    res.render('memberlist', {
                "memberlist" : result
            });
		});
		
        //var collection = db.collection('w4india_membersignups');
        //collection.find({'mootlywcm:isActive':isActive},{},function(e,docs){
        //   res.render('memberlist', {
        //        "memberlist" : docs
        //    });
        //});
    };
};