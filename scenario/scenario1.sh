#!/bin/sh

cd ..
javac @Compile.list
java equipe_25.Controleur &
sleep 1
echo "a"