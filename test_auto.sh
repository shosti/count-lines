#!/bin/sh

set -xue

lein trampoline midje :autotest
