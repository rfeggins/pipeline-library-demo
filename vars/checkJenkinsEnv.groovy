#!/usr/bin/env groovy

def call () {

script {
   for(e in env) {
        echo e + " is " + ${e}
    }
}
