#!/bin/sh
# program compile

#main

	Param=$1
	case "$Param" in
		c)	COMP_TARGET=`basename $2`;
			export COMP_TARGET=$2
			make -f Makefile.c;;
		pc)	export COMP_TARGET=$2
			make -f Makefile.pc all;;
		clean)	make -f Makefile.pc clean;;
		*)	echo "Usage: $0 argument";;
	esac
