(function() {
    'use strict';

    angular
        .module('analistaRural.layout')
        .controller('ShellController', ShellController);

    ShellController.$inject = ['$timeout', 'config', 'logger'];

    function ShellController($timeout, config, logger) {
        /*jshint validthis: true */
        var vm = this;

        vm.title = config.appTitle;
        vm.busyMessage = 'Please wait ...';
        vm.isBusy = true;
        vm.showSplash = true;

        activate();

        function activate() {
            logger.success(config.appTitle + ' loaded!', null);
            hideSplash();
        }

        function hideSplash() {
            //Force a 1 second delay so we can see the splash.
            $timeout(function() {
                vm.showSplash = false;
            }, 1000);
        }
    }
})();
