/* global toastr:false, moment:false */
(function() {
    'use strict';

    angular
        .module('analistaRural.core')
        .constant('toastr', toastr)
        .constant('moment', moment);
})();
