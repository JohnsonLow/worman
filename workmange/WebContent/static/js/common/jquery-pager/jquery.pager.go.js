
(function($) {

    var pagerJS_src = document.getElementById("pagerJS").src;
    var param = pagerJS_src.substring(pagerJS_src.indexOf('?')+1,pagerJS_src.length);

    var number = param.split('&&')[0];
    var glo_path= param.split('&&')[1];
    glo_path = glo_path.split('=')[1];
	
	 var g_pagecount;
    if(param=='number=null')
    {
       number=9;
    }else{
       number = parseInt(param.split('=')[1]);
    }

     $.fn.goOpPage =function(opObject,buttonClickCallback) 
    {
		
    	
		 //var goValue = $('#inputGo').val();
		  var goValue = opObject.parent().parent().children('span').eq(opObject.parent().parent().children('span').length-3).children('input').eq(0).val();
		 var gg_pagecount = opObject.parent().parent().children('span').eq(opObject.parent().parent().children('span').length-1).text();
		 if(parseInt(goValue)!=goValue)
		 {
             //$('#inputGo').val('');
			 opObject.parent().parent().children('span').eq(opObject.parent().parent().children('span').length-3).children('input').eq(0).val('');
             return ;
		 }else
		 if(goValue<=0)
		 {
			
			 buttonClickCallback(1);
		 }else
		 if(g_pagecount>goValue)
		 {
			 buttonClickCallback(goValue);
		 }else 
		 {
			 buttonClickCallback(gg_pagecount);
		 }
		

	};
    $.fn.pager = function(options) {

        var opts = $.extend({}, $.fn.pager.defaults, options);

        return this.each(function() {

        // <ul><span>共'+pagecount+'页</span></ul>
        var datanumber = options.datanumber;
        if(datanumber==undefined)
        {
             $(this).empty().append(renderpager(parseInt(options.pagenumber), parseInt(options.pagecount), options.buttonClickCallback));
        }else
        {
              $(this).empty().append(renderpager2(parseInt(options.pagenumber), parseInt(options.pagecount),parseInt(datanumber), options.buttonClickCallback));
        }
          
            
            // specify correct cursor activity
            $('.pages li').mouseover(function() { document.body.style.cursor = "pointer"; }).mouseout(function() { document.body.style.cursor = "auto"; });
        });
    };


 // render and return the pager with the supplied options
    function renderpager2(pagenumber, pagecount, datanumber,buttonClickCallback) {

        // setup $pager to hold render
        var $pager = $('<ul class="pages"><span style="margin-left:20%;text-decoration:none;cursor: auto;color:#000;">共计&nbsp;'+pagecount+'&nbsp;页&nbsp;('+datanumber+'条记录)&nbsp;</span></ul>');//2011-12-23
        g_pagecount = pagecount;
        // add in the previous and next buttons
        $pager.append(renderButton('首页', pagenumber, pagecount, buttonClickCallback)).append(renderButton('上一页', pagenumber, pagecount, buttonClickCallback));

	  /* if(pagenumber!=1)
	   {
		     $pager.append(renderButton('上一页', pagenumber, pagecount, buttonClickCallback));
	   }*/

        // pager currently only handles 10 viewable pages ( could be easily parameterized, maybe in next version ) so handle edge cases
        var startPoint = 1;
        var endPoint = number;
		 if(number%2!=0)
		 {
		        if (pagenumber > (number-1)/2) 
		        {
			        
			            var temp2 = (number-1)/2;
			            startPoint = pagenumber -temp2;
			            endPoint = pagenumber + temp2;
			        
		        }
		 }else
         {
	            if (pagenumber > (number/2-1)) 
		        {
			            var temp1 = number/2-1;
			            startPoint = pagenumber - temp1;
			            endPoint = pagenumber + temp1+1;
		        }
         }

        if (endPoint > pagecount) {
         //if(number%2!=0){
            startPoint = pagecount - (number-1);
         //}else
         //{
         //   startPoint = pagecount - number;
         //}
         
            endPoint = pagecount;
        }

        if (startPoint < 1) {
            startPoint = 1;
        }

        // loop thru visible pages and render buttons
        for (var page = startPoint; page <= endPoint; page++) {

            var currentButton = $('<span class="page-number">' + (page) + '</span>');

            page == pagenumber ? currentButton.addClass('pgCurrent') : currentButton.click(function() { buttonClickCallback(this.firstChild.data); });
            currentButton.appendTo($pager);
        }

       // render in the next and last buttons before returning the whole rendered control back.
        $pager.append(renderButton('下一页', pagenumber, pagecount, buttonClickCallback)).append(renderButton('末页', pagenumber, pagecount, buttonClickCallback));
        //$pager.append("<span class=\"page-number\" style=\"cursor:auto;text-decoration:none;\"><input size=\"1\"type=\"text\" name=\"inputGo\" id=\"inputGo\" style=\"width:20px; height:12px; line-height:12px; border:1px solid #000; text-align:left; font-size:11px; margin-right:5px;\"/>页</span><span><img style=\"border:0px; margin-bottom:-2px;cursor:pointer;\" src=\""+glo_path+"/static/images/icon_go.gif\"  onclick=\"$.fn.goOpPage()\"></span>");
	     $pager.append("<span class=\"page-number\" style=\"cursor:auto;text-decoration:none;\"><input size=\"1\"type=\"text\" name=\"inputGo\" class=\"inputGo\" style=\"width:20px; height:12px; line-height:12px; border:1px solid #000; text-align:left; font-size:11px; margin-right:5px;\"/>页</span><span><img style=\"border:0px; margin-bottom:-2px;cursor:pointer;\" src=\""+glo_path+"/static/images/icon_go.gif\"  onclick=\"$.fn.goOpPage($(this),"+buttonClickCallback+")\"></span><span style=\"display:none\">"+pagecount+"</span>");
	   /*if(pagenumber!=pagecount)
	   {
		       $pager.append(renderButton('下一页', pagenumber, pagecount, buttonClickCallback));
	   }
	   */
        /*<ul><span>共'+pagecount+'页</span></ul>*/
        
        return $pager;
    }



    // render and return the pager with the supplied options
    function renderpager(pagenumber, pagecount,buttonClickCallback) {

        // setup $pager to hold render
        var $pager = $('<ul class="pages"><span style="margin-left:20%;text-decoration:none;cursor: auto;color:#000;">共计&nbsp;'+pagecount+'&nbsp;页</span></ul>');//2011-12-23
        g_pagecount = pagecount;
        // add in the previous and next buttons
        $pager.append(renderButton('首页', pagenumber, pagecount, buttonClickCallback)).append(renderButton('上一页', pagenumber, pagecount, buttonClickCallback));

	  /* if(pagenumber!=1)
	   {
		     $pager.append(renderButton('上一页', pagenumber, pagecount, buttonClickCallback));
	   }*/

        // pager currently only handles 10 viewable pages ( could be easily parameterized, maybe in next version ) so handle edge cases
        var startPoint = 1;
        var endPoint = number;
		 if(number%2!=0)
		 {
		        if (pagenumber > (number-1)/2) 
		        {
			        
			            var temp2 = (number-1)/2;
			            startPoint = pagenumber -temp2;
			            endPoint = pagenumber + temp2;
			        
		        }
		 }else
         {
	            if (pagenumber > (number/2-1)) 
		        {
			            var temp1 = number/2-1;
			            startPoint = pagenumber - temp1;
			            endPoint = pagenumber + temp1+1;
		        }
         }

        if (endPoint > pagecount) {
         //if(number%2!=0){
            startPoint = pagecount - (number-1);
         //}else
         //{
         //   startPoint = pagecount - number;
         //}
         
            endPoint = pagecount;
        }

        if (startPoint < 1) {
            startPoint = 1;
        }

        // loop thru visible pages and render buttons
        for (var page = startPoint; page <= endPoint; page++) {

            var currentButton = $('<span class="page-number">' + (page) + '</span>');

            page == pagenumber ? currentButton.addClass('pgCurrent') : currentButton.click(function() { buttonClickCallback(this.firstChild.data); });
            currentButton.appendTo($pager);
        }

       // render in the next and last buttons before returning the whole rendered control back.
        $pager.append(renderButton('下一页', pagenumber, pagecount, buttonClickCallback)).append(renderButton('末页', pagenumber, pagecount, buttonClickCallback));
        //$pager.append("<span class=\"page-number\" style=\"cursor:auto;text-decoration:none;\"><input size=\"1\"type=\"text\" name=\"inputGo\" id=\"inputGo\" style=\"width:20px; height:12px; line-height:12px; border:1px solid #000; text-align:left; font-size:11px; margin-right:5px;\"/>页</span><span><img style=\"border:0px; margin-bottom:-2px;cursor:pointer;\" src=\""+glo_path+"/static/images/icon_go.gif\"  onclick=\"$.fn.goOpPage()\"></span>");
	     $pager.append("<span class=\"page-number\" style=\"cursor:auto;text-decoration:none;\"><input size=\"1\"type=\"text\" name=\"inputGo\" class=\"inputGo\" style=\"width:20px; height:12px; line-height:12px; border:1px solid #000; text-align:left; font-size:11px; margin-right:5px;margin-top:-4px;\"/>页</span><span><img style=\"border:0px; margin-bottom:-2px;cursor:pointer;\" src=\""+glo_path+"/static/images/icon_go.gif\"  onclick=\"$.fn.goOpPage($(this),"+buttonClickCallback+")\"></span><span style=\"display:none\">"+pagecount+"</span>");
	   /*if(pagenumber!=pagecount)
	   {
		       $pager.append(renderButton('下一页', pagenumber, pagecount, buttonClickCallback));
	   }
	   */
        /*<ul><span>共'+pagecount+'页</span></ul>*/
        
        return $pager;
    }

    // renders and returns a 'specialized' button, ie 'next', 'previous' etc. rather than a page number button
    function renderButton(buttonLabel, pagenumber, pagecount, buttonClickCallback) {

        var $Button = $('<span class="pgNext">' + buttonLabel + '</span>');

        var destPage = 1;

        // work out destination page for required button type
        switch (buttonLabel) {
            case "首页":
                destPage = 1;
                break;
            case "上一页":
                destPage = pagenumber - 1;
                break;
            case "下一页":
                destPage = pagenumber + 1;
                break;
             case "末页":
                destPage = pagecount;
                break;
                
        }
        if (buttonLabel == "首页")
        {
           //$Button.attr("style","margin-left:25%;");
        //$Button.attr("style","");
        }
        // disable and 'grey' out buttons if not needed.
        if (buttonLabel == "首页" || buttonLabel == "上一页") {
            pagenumber <= 1 ? $Button.addClass('pgEmpty') : $Button.click(function() { buttonClickCallback(destPage); });
        
        }
        else {
            pagenumber >= pagecount ? $Button.addClass('pgEmpty') : $Button.click(function() { buttonClickCallback(destPage); });
        }
        return $Button;
    }

    // pager defaults. hardly worth bothering with in this case but used as placeholder for expansion in the next version
    $.fn.pager.defaults = {
        pagenumber: 1,
        pagecount: 1
    };

})(jQuery);





