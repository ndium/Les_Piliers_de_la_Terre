#!/bin/sh

cd ..
javac @Compile.list
{echo "a" ; echo "1"} | java equipe_25.Controleur 

