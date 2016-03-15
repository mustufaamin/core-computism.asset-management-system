/**
 * Created by Umair Ullah on 1/22/2016.
 */
module.exports = function(grunt) {

    // 1. All configuration goes here
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),

        /*concat: {
            options: {
                separator: "\n\n"
            },
            dist: {
                src: [

                ],
                dest:
            }
        },

        uglify: {
            options: {
                report: 'min',
                mangle: false
            },
            build: {
                src: 'overview/js/build/production.js',
                dest:'overview/js/build/production.min.js'
            }
        }*/



    });

    // 3. Where we tell Grunt we plan to use this plug-in.
    /*grunt.loadNpmTasks('grunt-contrib-concat');*/

    /*grunt.loadNpmTasks('grunt-contrib-uglify');*/

    //grunt.loadNpmTasks('grunt-processhtml');

    //grunt.loadNpmTasks('grunt-karma');

    //grunt.loadNpmTasks('grunt-contrib-jshint');

    // 4. Where we tell Grunt what to do when we type "grunt" into the terminal.
    /*grunt.registerTask('default', ['concat', 'uglify']);*/

    //grunt.registerTask('test',['karma']);

    //jshint:{
        //myFiles: 'overview/js/**/*.js'
   // }

};