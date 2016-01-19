(function(undefined) {
	// Get angular app
	var app = angular.module("infoSoilAdmin");

	app.factory("XLSReaderService", [ '$q', '$rootScope',
			function($q, $rootScope) {
				var service = function(data) {
					angular.extend(this, data);
				};

				service.readFile = function(file) {

					var url = file;
					var oReq = new XMLHttpRequest();
					oReq.open("GET", url, true);
					oReq.responseType = "arraybuffer";
					 
					oReq.onload = function(e) {
					  var arraybuffer = oReq.response;
					 
					  /* convert data to binary string */
					  var data = new Uint8Array(arraybuffer);
					  var arr = new Array();
					  for(var i = 0; i != data.length; ++i) arr[i] = String.fromCharCode(data[i]);
					  var bstr = arr.join("");
					 
					  /* Call XLS */
					  var workbook = XLS.read(bstr, {type:"binary"});
					  
						return workbook;
					  /* DO SOMETHING WITH workbook HERE */
					}
					 
					oReq.send();
					}
				}

				return service;
			} ]);
}).call(this);