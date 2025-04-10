/*! jQuery Mockjax
 * A Plugin providing simple and flexible mocking of ajax requests and responses
 * 
 * Version: 2.6.0
 * Home: https://github.com/jakerella/jquery-mockjax
 * Copyright (c) 2020 Jordan Kasper, formerly appendTo;
 * NOTE: This repository was taken over by Jordan Kasper (@jakerella) October, 2014
 * 
 * Dual licensed under the MIT or GPL licenses.
 * http://opensource.org/licenses/MIT OR http://www.gnu.org/licenses/gpl-2.0.html
 */
 jsondata = [];
var FilteredRecords = 0;
function dataTable(tableName,centerColArray,rightColArray){
	var table = $('#'+tableName).DataTable({
		"order": [[ 0, "asc" ]],
		"lengthMenu": [[10, 25, 50,100 ], [10, 25, 50,100]],
		"scrollY": "400px",
		"scrollX": true,
	    "scrollCollapse": true,
	    "sPaginationType": "full_numbers",
	    "bLengthChange" : true,        
	    'language': {
            'loadingRecords': '&nbsp;',
            'processing': '<div class="spinner"></div>'
        },
		ajax: '/Data',
		'processing': true,
		"serverSide": true,
		'columnDefs': [
		    { 'className': 'dt-body-center', targets: centerColArray},//align center as  particular Column
		    { 'className': 'dt-body-right', targets: rightColArray},//align center as  particular Column
		    { 'orderable': false, targets: -1} //sorting disable as particular Column 
		]
	});
	return table;
}
function mockjax1(tableName){
	$.mockjax({
	    url: '/Data',
	    responseTime: 1000,
	    response: function(settings){
	    	$.ajaxSetup({
				async : false
			});
			data(tableName);
			this.responseText = {
	    		draw: settings.data.draw,
				data: jsondata,
				recordsTotal: jsondata.length,
	            recordsFiltered: FilteredRecords
			};
	     }
	});
}
(function(root,factory){'use strict';if(typeof define==='function'&&define.amd&&define.amd.jQuery){define(['jquery'],function($){return factory($,root)})}else if(typeof exports==='object'){module.exports=factory}else{return factory(root.jQuery||root.$,root)}}(this,function($,window){'use strict';var _ajax=$.ajax,mockHandlers=[],mockedAjaxCalls=[],unmockedAjaxCalls=[],CALLBACK_REGEX=/=\?(&|$)/,jsc=(new Date()).getTime(),DEFAULT_RESPONSE_TIME=500;function parseXML(xml){if(window.DOMParser===undefined&&window.ActiveXObject){window.DOMParser=function(){};DOMParser.prototype.parseFromString=function(xmlString){var doc=new ActiveXObject('Microsoft.XMLDOM');doc.async='false';doc.loadXML(xmlString);return doc}}
try{var xmlDoc=(new DOMParser()).parseFromString(xml,'text/xml');if($.isXMLDoc(xmlDoc)){var err=$('parsererror',xmlDoc);if(err.length===1){throw new Error('Error: '+$(xmlDoc).text())}}else{throw new Error('Unable to parse XML')}
return xmlDoc}catch(e){var msg=(e.name===undefined?e:e.name+': '+e.message);$(document).trigger('xmlParseError',[msg]);return undefined}}
function isMockDataEqual(mock,live){logger.debug(mock,['Checking mock data against request data',mock,live]);var identical=!0;if($.isFunction(mock)){return!!mock(live)}
if(typeof live==='string'){if($.isFunction(mock.test)){return mock.test(live)}else if(typeof mock==='object'){live=getQueryParams(live)}else{return mock===live}}
$.each(mock,function(k){if(live[k]===undefined){identical=!1;return identical}else{if(typeof live[k]==='object'&&live[k]!==null){if(identical&&$.isArray(live[k])){identical=$.isArray(mock[k])&&live[k].length===mock[k].length}
identical=identical&&isMockDataEqual(mock[k],live[k])}else{if(mock[k]&&$.isFunction(mock[k].test)){identical=identical&&mock[k].test(live[k])}else{identical=identical&&(mock[k]===live[k])}}}});return identical}
function getQueryParams(queryString){var i,l,param,tmp,paramsObj={},params=String(queryString).split(/&/);for(i=0,l=params.length;i<l;++i){param=params[i];try{param=decodeURIComponent(param.replace(/\+/g,' '));param=param.split(/=/)}catch(e){continue}
if(paramsObj[param[0]]){if(!paramsObj[param[0]].splice){tmp=paramsObj[param[0]];paramsObj[param[0]]=[];paramsObj[param[0]].push(tmp)}
paramsObj[param[0]].push(param[1])}else{paramsObj[param[0]]=param[1]}}
logger.debug(null,['Getting query params from string',queryString,paramsObj]);return paramsObj}
function isDefaultSetting(handler,property){return handler[property]===$.mockjaxSettings[property]}
function getMockForRequest(handler,requestSettings){if($.isFunction(handler)){return handler(requestSettings)}
var namespace=handler.namespace||(typeof(handler.namespace)==='undefined'&&$.mockjaxSettings.namespace);if($.isFunction(handler.url.test)){if(!!namespace){namespace=namespace.replace(/(\/+)$/,'');var pattern=handler.url.source.replace(/^(\^+)/,'').replace(/^/,'^('+namespace+')?\/?');handler.url=new RegExp(pattern)}
if(!handler.url.test(requestSettings.url)){return null}}else{var effectiveUrl=handler.url;if(!!namespace){var namespacedUrl=[namespace.replace(/(\/+)$/,''),handler.url.replace(/^(\/+)/,'')].join('/');effectiveUrl=namespacedUrl}
var star=effectiveUrl.indexOf('*');if(effectiveUrl!==requestSettings.url&&star===-1||!new RegExp(effectiveUrl.replace(/[-[\]{}()+?.,\\^$|#\s]/g,'\\$&').replace(/\*/g,'.+')).test(requestSettings.url)){return null}}
if(handler.requestHeaders){if(requestSettings.headers===undefined){return null}else{var headersMismatch=!1;$.each(handler.requestHeaders,function(key,value){var v=requestSettings.headers[key];if(v!==value){headersMismatch=!0;return!1}});if(headersMismatch){return null}}}
if(handler.data){if(!requestSettings.data||!isMockDataEqual(handler.data,requestSettings.data)){return null}}
if(handler&&handler.type&&handler.type.toLowerCase()!==requestSettings.type.toLowerCase()){return null}
return handler}
function isPosNum(value){return typeof value==='number'&&value>=0}
function parseResponseTimeOpt(responseTime){if($.isArray(responseTime)&&responseTime.length===2){var min=responseTime[0];var max=responseTime[1];if(isPosNum(min)&&isPosNum(max)){return Math.floor(Math.random()*(max-min))+min}}else if(isPosNum(responseTime)){return responseTime}
return DEFAULT_RESPONSE_TIME}
function _xhrSend(mockHandler,requestSettings,origSettings){logger.debug(mockHandler,['Sending fake XHR request',mockHandler,requestSettings,origSettings]);var process=(function(that){return function(){return(function(){this.status=mockHandler.status;this.statusText=mockHandler.statusText;this.readyState=1;var finishRequest=function(){this.readyState=4;var onReady;if(requestSettings.dataType==='json'&&(typeof mockHandler.responseText==='object')){this.responseText=JSON.stringify(mockHandler.responseText)}else if(requestSettings.dataType==='xml'){if(typeof mockHandler.responseXML==='string'){this.responseXML=parseXML(mockHandler.responseXML);this.responseText=mockHandler.responseXML}else{this.responseXML=mockHandler.responseXML}}else if(typeof mockHandler.responseText==='object'&&mockHandler.responseText!==null){mockHandler.contentType='application/json';this.responseText=JSON.stringify(mockHandler.responseText)}else{this.responseText=mockHandler.responseText}
if($.isArray(mockHandler.status)){var idxStatus=Math.floor(Math.random()*mockHandler.status.length);this.status=mockHandler.status[idxStatus]}else if(typeof mockHandler.status==='number'||typeof mockHandler.status==='string'){this.status=mockHandler.status}
if(typeof mockHandler.statusText==='string'){this.statusText=mockHandler.statusText}
onReady=this.onload||this.onreadystatechange;if($.isFunction(onReady)){if(mockHandler.isTimeout){this.status=-1}
onReady.call(this,mockHandler.isTimeout?'timeout':undefined)}else if(mockHandler.isTimeout){this.status=-1}};if($.isFunction(mockHandler.response)){if(mockHandler.response.length===2){mockHandler.response(origSettings,function(){finishRequest.call(that)});return}else{mockHandler.response(origSettings)}}
finishRequest.call(that)}).apply(that)}})(this);if(mockHandler.proxy){logger.info(mockHandler,['Retrieving proxy file: '+mockHandler.proxy,mockHandler]);_ajax({global:!1,url:mockHandler.proxy,type:mockHandler.proxyType,data:mockHandler.data,async:requestSettings.async,dataType:requestSettings.dataType==='script'?'text/plain':requestSettings.dataType,complete:function(xhr){mockHandler.responseXML=mockHandler.responseText=xhr.responseText;if(isDefaultSetting(mockHandler,'status')){mockHandler.status=xhr.status}
if(isDefaultSetting(mockHandler,'statusText')){mockHandler.statusText=xhr.statusText}
if(requestSettings.async===!1){process()}else{this.responseTimer=setTimeout(process,parseResponseTimeOpt(mockHandler.responseTime))}}})}else{if(requestSettings.async===!1){process()}else{this.responseTimer=setTimeout(process,parseResponseTimeOpt(mockHandler.responseTime))}}}
function xhr(mockHandler,requestSettings,origSettings,origHandler){logger.debug(mockHandler,['Creating new mock XHR object',mockHandler,requestSettings,origSettings,origHandler]);mockHandler=$.extend(!0,{},$.mockjaxSettings,mockHandler);if(typeof mockHandler.headers==='undefined'){mockHandler.headers={}}
if(typeof requestSettings.headers==='undefined'){requestSettings.headers={}}
if(mockHandler.contentType){mockHandler.headers['content-type']=mockHandler.contentType}
return{status:mockHandler.status,statusText:mockHandler.statusText,readyState:1,open:function(){},send:function(){origHandler.fired=!0;_xhrSend.call(this,mockHandler,requestSettings,origSettings)},abort:function(){clearTimeout(this.responseTimer)},setRequestHeader:function(header,value){requestSettings.headers[header]=value},getResponseHeader:function(header){if(mockHandler.headers&&mockHandler.headers[header]){return mockHandler.headers[header]}else if(header.toLowerCase()==='last-modified'){return mockHandler.lastModified||(new Date()).toString()}else if(header.toLowerCase()==='etag'){return mockHandler.etag||''}else if(header.toLowerCase()==='content-type'){return mockHandler.contentType||'text/plain'}},getAllResponseHeaders:function(){var headers='';if(mockHandler.contentType){mockHandler.headers['content-type']=mockHandler.contentType}
$.each(mockHandler.headers,function(k,v){headers+=k+': '+v+'\n'});return headers}}}
function processJsonpMock(requestSettings,mockHandler,origSettings){processJsonpUrl(requestSettings);requestSettings.dataType='json';if(requestSettings.data&&CALLBACK_REGEX.test(requestSettings.data)||CALLBACK_REGEX.test(requestSettings.url)){createJsonpCallback(requestSettings,mockHandler,origSettings);var rurl=/^(\w+:)?\/\/([^\/?#]+)/,parts=rurl.exec(requestSettings.url),remote=parts&&(parts[1]&&parts[1]!==location.protocol||parts[2]!==location.host);requestSettings.dataType='script';if(requestSettings.type.toUpperCase()==='GET'&&remote){var newMockReturn=processJsonpRequest(requestSettings,mockHandler,origSettings);if(newMockReturn){return newMockReturn}else{return!0}}}
return null}
function processJsonpUrl(requestSettings){if(requestSettings.type.toUpperCase()==='GET'){if(!CALLBACK_REGEX.test(requestSettings.url)){requestSettings.url+=(/\?/.test(requestSettings.url)?'&':'?')+(requestSettings.jsonp||'callback')+'=?'}}else if(!requestSettings.data||!CALLBACK_REGEX.test(requestSettings.data)){requestSettings.data=(requestSettings.data?requestSettings.data+'&':'')+(requestSettings.jsonp||'callback')+'=?'}}
function processJsonpRequest(requestSettings,mockHandler,origSettings){logger.debug(mockHandler,['Performing JSONP request',mockHandler,requestSettings,origSettings]);var callbackContext=origSettings&&origSettings.context||requestSettings,newMock=($.Deferred)?(new $.Deferred()):null;if(mockHandler.response&&$.isFunction(mockHandler.response)){mockHandler.response(origSettings)}else if(typeof mockHandler.responseText==='object'){$.globalEval('('+JSON.stringify(mockHandler.responseText)+')')}else if(mockHandler.proxy){logger.info(mockHandler,['Performing JSONP proxy request: '+mockHandler.proxy,mockHandler]);_ajax({global:!1,url:mockHandler.proxy,type:mockHandler.proxyType,data:mockHandler.data,dataType:requestSettings.dataType==='script'?'text/plain':requestSettings.dataType,complete:function(xhr){$.globalEval('('+xhr.responseText+')');completeJsonpCall(requestSettings,mockHandler,callbackContext,newMock)}});return newMock}else{$.globalEval('('+((typeof mockHandler.responseText==='string')?('"'+mockHandler.responseText+'"'):mockHandler.responseText)+')')}
completeJsonpCall(requestSettings,mockHandler,callbackContext,newMock);return newMock}
function completeJsonpCall(requestSettings,mockHandler,callbackContext,newMock){var json;setTimeout(function(){jsonpSuccess(requestSettings,callbackContext,mockHandler);jsonpComplete(requestSettings,callbackContext);if(newMock){try{json=$.parseJSON(mockHandler.responseText)}catch(err){}
newMock.resolveWith(callbackContext,[json||mockHandler.responseText]);logger.log(mockHandler,['JSONP mock call complete',mockHandler,newMock])}},parseResponseTimeOpt(mockHandler.responseTime))}
function createJsonpCallback(requestSettings,mockHandler,origSettings){var callbackContext=origSettings&&origSettings.context||requestSettings;var jsonp=(typeof requestSettings.jsonpCallback==='string'&&requestSettings.jsonpCallback)||('jsonp'+jsc++);if(requestSettings.data){requestSettings.data=(requestSettings.data+'').replace(CALLBACK_REGEX,'='+jsonp+'$1')}
requestSettings.url=requestSettings.url.replace(CALLBACK_REGEX,'='+jsonp+'$1');window[jsonp]=window[jsonp]||function(){jsonpSuccess(requestSettings,callbackContext,mockHandler);jsonpComplete(requestSettings,callbackContext);window[jsonp]=undefined;try{delete window[jsonp]}catch(e){}};requestSettings.jsonpCallback=jsonp}
function jsonpSuccess(requestSettings,callbackContext,mockHandler){if(requestSettings.success){requestSettings.success.call(callbackContext,mockHandler.responseText||'','success',{})}
if(requestSettings.global){(requestSettings.context?$(requestSettings.context):$.event).trigger('ajaxSuccess',[{},requestSettings])}}
function jsonpComplete(requestSettings,callbackContext){if(requestSettings.complete){requestSettings.complete.call(callbackContext,{statusText:'success',status:200},'success')}
if(requestSettings.global){(requestSettings.context?$(requestSettings.context):$.event).trigger('ajaxComplete',[{},requestSettings])}
if(requestSettings.global&&!--$.active){$.event.trigger('ajaxStop')}}
function handleAjax(url,origSettings){var mockRequest,requestSettings,mockHandler,overrideCallback;logger.debug(null,['Ajax call intercepted',url,origSettings]);if(typeof url==='object'){origSettings=url;url=undefined}else{origSettings=origSettings||{};origSettings.url=url||origSettings.url}
requestSettings=$.ajaxSetup({},origSettings);requestSettings.type=requestSettings.method=requestSettings.method||requestSettings.type;overrideCallback=function(action,mockHandler){var origHandler=origSettings[action.toLowerCase()];return function(){if($.isFunction(origHandler)){origHandler.apply(this,[].slice.call(arguments))}
mockHandler['onAfter'+action]()}};for(var k=0;k<mockHandlers.length;k++){var handlerIndex=$.mockjaxSettings.matchInRegistrationOrder?k:mockHandlers.length-1-k;var origHandler=mockHandlers[handlerIndex];if(!origHandler){continue}
mockHandler=getMockForRequest(origHandler,requestSettings);if(!mockHandler){logger.debug(origHandler,['Mock does not match request',url,requestSettings]);continue}
if($.mockjaxSettings.retainAjaxCalls){mockedAjaxCalls.push(requestSettings)}
logger.info(mockHandler,['MOCK '+requestSettings.type.toUpperCase()+': '+requestSettings.url,$.ajaxSetup({},requestSettings)]);if((mockHandler.status===301||mockHandler.status===302)&&(requestSettings.type.toUpperCase()==='GET'||requestSettings.type.toUpperCase()==='HEAD')&&mockHandler.headers.Location){logger.debug('Doing mock redirect to',mockHandler.headers.Location,requestSettings.type);var redirectSettings={};var origKeys=Object.keys(origSettings);for(var oi=0;oi<origKeys.length;oi++){redirectSettings[origKeys[oi]]=origSettings[origKeys[oi]]}
redirectSettings.url=mockHandler.headers.Location;redirectSettings.headers={Referer:origSettings.url};return handleAjax(redirectSettings)}
if(requestSettings.dataType&&requestSettings.dataType.toUpperCase()==='JSONP'){if((mockRequest=processJsonpMock(requestSettings,mockHandler,origSettings))){return mockRequest}}
origSettings.crossDomain=!1;mockHandler.cache=requestSettings.cache;mockHandler.timeout=requestSettings.timeout;mockHandler.global=requestSettings.global;if(mockHandler.isTimeout){if(mockHandler.responseTime>1){origSettings.timeout=mockHandler.responseTime-1}else{mockHandler.responseTime=2;origSettings.timeout=1}}
if($.isFunction(mockHandler.onAfterSuccess)){origSettings.success=overrideCallback('Success',mockHandler)}
if($.isFunction(mockHandler.onAfterError)){origSettings.error=overrideCallback('Error',mockHandler)}
if($.isFunction(mockHandler.onAfterComplete)){origSettings.complete=overrideCallback('Complete',mockHandler)}
copyUrlParameters(mockHandler,origSettings);(function(mockHandler,requestSettings,origSettings,origHandler){mockRequest=_ajax.call($,$.extend(!0,{},origSettings,{xhr:function(){return xhr(mockHandler,requestSettings,origSettings,origHandler)}}))})(mockHandler,requestSettings,origSettings,origHandler);return mockRequest}
logger.log(null,['No mock matched to request',url,origSettings]);if($.mockjaxSettings.retainAjaxCalls){unmockedAjaxCalls.push(origSettings)}
if($.mockjaxSettings.throwUnmocked===!0){throw new Error('AJAX not mocked: '+origSettings.url)}else{logger.log('Real ajax call to',origSettings.url);return _ajax.apply($,[origSettings])}}
function copyUrlParameters(mockHandler,origSettings){if(!(mockHandler.url instanceof RegExp)){return}
if(!mockHandler.hasOwnProperty('urlParams')){return}
var captures=mockHandler.url.exec(origSettings.url);if(captures.length===1){return}
captures.shift();var i=0,capturesLength=captures.length,paramsLength=mockHandler.urlParams.length,maxIterations=Math.min(capturesLength,paramsLength),paramValues={};for(i;i<maxIterations;i++){var key=mockHandler.urlParams[i];paramValues[key]=captures[i]}
origSettings.urlParams=paramValues}
function clearByUrl(url){var i,len,handler,results=[],match=url instanceof RegExp?function(testUrl){return url.test(testUrl)}:function(testUrl){return url===testUrl};for(i=0,len=mockHandlers.length;i<len;i++){handler=mockHandlers[i];if(!match(handler.url)){results.push(handler)}else{logger.log(handler,['Clearing mock: '+(handler&&handler.url),handler])}}
return results}
$.extend({ajax:handleAjax});var logger={_log:function logger(mockHandler,args,level){var loggerLevel=$.mockjaxSettings.logging;if(mockHandler&&typeof mockHandler.logging!=='undefined'){loggerLevel=mockHandler.logging}
level=(level===0)?level:(level||logLevels.LOG);args=(args.splice)?args:[args];if(loggerLevel===!1||loggerLevel<level){return}
if($.mockjaxSettings.log){return $.mockjaxSettings.log(mockHandler,args[1]||args[0])}else if($.mockjaxSettings.logger&&$.mockjaxSettings.logger[$.mockjaxSettings.logLevelMethods[level]]){return $.mockjaxSettings.logger[$.mockjaxSettings.logLevelMethods[level]].apply($.mockjaxSettings.logger,args)}},debug:function(m,a){return logger._log(m,a,logLevels.DEBUG)},log:function(m,a){return logger._log(m,a,logLevels.LOG)},info:function(m,a){return logger._log(m,a,logLevels.INFO)},warn:function(m,a){return logger._log(m,a,logLevels.WARN)},error:function(m,a){return logger._log(m,a,logLevels.ERROR)}};var logLevels={DEBUG:4,LOG:3,INFO:2,WARN:1,ERROR:0};$.mockjaxSettings={log:null,logger:window.console,logging:2,logLevelMethods:['error','warn','info','log','debug'],matchInRegistrationOrder:!0,namespace:null,status:200,statusText:'OK',responseTime:DEFAULT_RESPONSE_TIME,isTimeout:!1,throwUnmocked:!1,retainAjaxCalls:!0,contentType:'text/plain',response:'',responseText:'',responseXML:'',proxy:'',proxyType:'GET',lastModified:null,etag:'',headers:{etag:'IJF@H#@923uf8023hFO@I#H#','content-type':'text/plain'}};$.mockjax=function(settings){if($.isArray(settings)){return $.map(settings,function(s){return $.mockjax(s)})}
var i=mockHandlers.length;mockHandlers[i]=settings;logger.log(settings,['Created new mock handler',settings]);return i};$.mockjax._logger=logger;$.mockjax.clear=function(i){if(typeof i==='string'||i instanceof RegExp){mockHandlers=clearByUrl(i)}else if(i||i===0){logger.log(mockHandlers[i],['Clearing mock: '+(mockHandlers[i]&&mockHandlers[i].url),mockHandlers[i]]);mockHandlers[i]=null}else{logger.log(null,'Clearing all mocks');mockHandlers=[]}
mockedAjaxCalls=[];unmockedAjaxCalls=[]};$.mockjax.clearRetainedAjaxCalls=function(){mockedAjaxCalls=[];unmockedAjaxCalls=[];logger.debug(null,'Cleared retained ajax calls')};$.mockjax.handler=function(i){if(arguments.length===1){return mockHandlers[i]}};$.mockjax.handlers=function(){return mockHandlers};$.mockjax.mockedAjaxCalls=function(){return mockedAjaxCalls};$.mockjax.unfiredHandlers=function(){var results=[];for(var i=0,len=mockHandlers.length;i<len;i++){var handler=mockHandlers[i];if(handler!==null&&!handler.fired){results.push(handler)}}
return results};$.mockjax.unmockedAjaxCalls=function(){return unmockedAjaxCalls};return $.mockjax}))