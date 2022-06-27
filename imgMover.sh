#!/bin/bash

dest_path=$1
source_path="."
slike=$(grep -o '/images/.*\.png' ./"$dest_path"/readme.md)


for slika in ${slike}; do 
    # echo "source path: $source_path$slika"
    # echo "Target path: $dest_path$slika"
    mv "$source_path$slika" "$dest_path$slika"
done