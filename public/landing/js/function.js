$(document).ready(function(){ 
	
/*********************
	tabs, toggle accordion
	*********************/
	$(".tabs").tabs(".panes > div", {effect: 'fade'});

	$("#accordion").tabs("#accordion div.pane", {tabs: 'h6', effect: 'slide', initialIndex: null});
	


	//Hide (Collapse) the toggle containers on load
	$(".toggle div.pane").hide(); 

	//Switch the "Open" and "Close" state per click then slide up/down (depending on open/close state)
	$(".toggle h6.title").click(function(){
		$(this).toggleClass("active").next().slideToggle("normal");
		return false; //Prevent the browser jump to the link anchor
	});

});
	
(function(a){a.tools=a.tools||{version:"v1.2.5"},a.tools.tabs={conf:{tabs:"a",current:"current",onBeforeClick:null,onClick:null,effect:"default",initialIndex:0,event:"click",rotate:!1,history:!1},addEffect:function(a,c){b[a]=c}};var b={"default":function(a,b){this.getPanes().hide().eq(a).show(),b.call()},fade:function(a,b){var c=this.getConf(),d=c.fadeOutSpeed,e=this.getPanes();d?e.fadeOut(d):e.hide(),e.eq(a).fadeIn(c.fadeInSpeed,b)},slide:function(a,b){this.getPanes().slideUp(200),this.getPanes().eq(a).slideDown(400,b)},ajax:function(a,b){this.getPanes().eq(0).load(this.getTabs().eq(a).attr("href"),b)}},c;a.tools.tabs.addEffect("horizontal",function(b,d){c||(c=this.getPanes().eq(0).width()),this.getCurrentPane().animate({width:0},function(){a(this).hide()}),this.getPanes().eq(b).animate({width:c},function(){a(this).show(),d.call()})});function d(c,d,e){var f=this,g=c.add(this),h=c.find(e.tabs),i=d.jquery?d:c.children(d),j;h.length||(h=c.children()),i.length||(i=c.parent().find(d)),i.length||(i=a(d)),a.extend(this,{click:function(c,d){var i=h.eq(c);typeof c=="string"&&c.replace("#","")&&(i=h.filter("[href*="+c.replace("#","")+"]"),c=Math.max(h.index(i),0));if(e.rotate){var k=h.length-1;if(c<0)return f.click(k,d);if(c>k)return f.click(0,d)}if(!i.length){if(j>=0)return f;c=e.initialIndex,i=h.eq(c)}if(c===j)return f;d=d||a.Event(),d.type="onBeforeClick",g.trigger(d,[c]);if(!d.isDefaultPrevented()){b[e.effect].call(f,c,function(){d.type="onClick",g.trigger(d,[c])}),j=c,h.removeClass(e.current),i.addClass(e.current);return f}},getConf:function(){return e},getTabs:function(){return h},getPanes:function(){return i},getCurrentPane:function(){return i.eq(j)},getCurrentTab:function(){return h.eq(j)},getIndex:function(){return j},next:function(){return f.click(j+1)},prev:function(){return f.click(j-1)},destroy:function(){h.unbind(e.event).removeClass(e.current),i.find("a[href^=#]").unbind("click.T");return f}}),a.each("onBeforeClick,onClick".split(","),function(b,c){a.isFunction(e[c])&&a(f).bind(c,e[c]),f[c]=function(b){b&&a(f).bind(c,b);return f}}),e.history&&a.fn.history&&(a.tools.history.init(h),e.event="history"),h.each(function(b){a(this).bind(e.event,function(a){f.click(b,a);return a.preventDefault()})}),i.find("a[href^=#]").bind("click.T",function(b){f.click(a(this).attr("href"),b)}),location.hash&&e.tabs=="a"&&c.find("[href="+location.hash+"]").length?f.click(location.hash):(e.initialIndex===0||e.initialIndex>0)&&f.click(e.initialIndex)}a.fn.tabs=function(b,c){var e=this.data("tabs");e&&(e.destroy(),this.removeData("tabs")),a.isFunction(c)&&(c={onBeforeClick:c}),c=a.extend({},a.tools.tabs.conf,c),this.each(function(){e=new d(a(this),b,c),a(this).data("tabs",e)});return c.api?e:this}})(jQuery);



/***************************************************
		IMAGE ZOOM
***************************************************/
$(document).ready(function() {
	$("a.zoom img").mouseover(function(){
		$(this).stop(true,true);
		$(this).fadeTo(300, 0.5);
	});

	$("a.zoom img").mouseout(function(){
		$(this).fadeTo(400, 1.0);
	});
	
		
		
	// hide #back-top first
	$("#back-top").hide();
	
	// fade in #back-top
	$(function () {
		$(window).scroll(function () {
			if ($(this).scrollTop() > 100) {
				$('#back-top').fadeIn();
			} else {
				$('#back-top').fadeOut();
			}
		});

		// scroll body to 0px on click
		$('#back-top a').click(function () {
			$('body,html').animate({
				scrollTop: 0
			}, 800);
			return false;
		});
	});
	
	
	
    //Set opacity on each span to 0%
    $(".fb-rollover").css({'opacity':'0'});

	$('.fsocial_network a').hover(
		function() {
			$(this).find('.fb-rollover').stop().fadeTo(500, 1);
		},
		function() {
			$(this).find('.fb-rollover').stop().fadeTo(500, 0);
		}
	)
	
    //Set opacity on each span to 0%
    $(".twitter-rollover").css({'opacity':'0'});

	$('.fsocial_network a').hover(
		function() {
			$(this).find('.twitter-rollover').stop().fadeTo(500, 1);
		},
		function() {
			$(this).find('.twitter-rollover').stop().fadeTo(500, 0);
		}
	)
	
    //Set opacity on each span to 0%
    $(".linkedin-rollover").css({'opacity':'0'});

	$('.fsocial_network a').hover(
		function() {
			$(this).find('.linkedin-rollover').stop().fadeTo(500, 1);
		},
		function() {
			$(this).find('.linkedin-rollover').stop().fadeTo(500, 0);
		}
	)

	    //Set opacity on each span to 0%
    $(".rss-rollover").css({'opacity':'0'});

	$('.fsocial_network a').hover(
		function() {
			$(this).find('.rss-rollover').stop().fadeTo(500, 1);
		},
		function() {
			$(this).find('.rss-rollover').stop().fadeTo(500, 0);
		}
	)
	
	    //Set opacity on each span to 0%
    $(".gplus-rollover").css({'opacity':'0'});

	$('.fsocial_network a').hover(
		function() {
			$(this).find('.gplus-rollover').stop().fadeTo(500, 1);
		},
		function() {
			$(this).find('.gplus-rollover').stop().fadeTo(500, 0);
		}
	)
	
	    //Set opacity on each span to 0%
    $(".mail-rollover").css({'opacity':'0'});

	$('.fsocial_network a').hover(
		function() {
			$(this).find('.mail-rollover').stop().fadeTo(500, 1);
		},
		function() {
			$(this).find('.mail-rollover').stop().fadeTo(500, 0);
		}
	)



	$('.testimonial').cycle({
 		fx:'slide',
 		timeout:4000
 	});


});


