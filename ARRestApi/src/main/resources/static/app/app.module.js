(function() {
	'use strict';

	angular.module('analistaRural', [
	/*
	 * Order is not important. Angular makes a pass to register all of the
	 * modules listed and then when app.dashboard tries to use app.data, its
	 * components are available.
	 */

	/*
	 * Everybody has access to these. We could place these under every feature
	 * area, but this is easier to maintain.
	 */
	'analistaRural.core',

	/*
	 * Feature areas
	 */
	'analistaRural.activities', 'analistaRural.layout' ]);

})();
