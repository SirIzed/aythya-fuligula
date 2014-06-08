#! /bin/bash
input=ui_parts
if [ -n "$1" ]; then input=$1; fi

output=../core/assets/$input
if [ -n "$2" ]; then output=$2; fi

packageName=$input
if [ -n "$3" ]; then packageName=$3; fi

java -cp gdx.jar:gdx-tools-1.1.1-SNAPSHOT-distribution.jar com.badlogic.gdx.tools.texturepacker.TexturePacker $input $output $packageName


