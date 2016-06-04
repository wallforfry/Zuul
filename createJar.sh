#!/bin/bash
# init
echo -n "Press [Enter] key to start compilation..."
read enter
echo "Compilation.."

javac ./*/*.java
javac ./*.java

echo -n "\nDo you want to create javadocs ? (Y/n) "
read answer
if echo "$answer" | grep -iq "^Y" ;then
    javadoc -d progdoc -author -version -private -linksource pkg_* *.java
    javadoc -d userdoc -author -version pkg_* *.java
else
    echo "Javadocs aren't created"
fi


echo -n "\nDo you want to create jar file ? (Y/n) "
read answer
if echo "$answer" | grep -iq "^Y" ;then
    echo -n "\nFile name : "
    read name
    jar cf ../"$name".jar ./*.* pkg_commands pkg_game pkg_item pkg_player pkg_room progdoc test userdoc images
    jar ufe ../"$name".jar Main

    echo -n "\nDo you want to list jar's files ? (Y/n) "
    read answer
    if echo "$answer" | grep -iq "^Y" ;then
        #Lister les fichiers
        jar tf ../"$name".jar
    else
        echo "$name.jar is ready"
    fi
else
    echo "Jar file isn't created"
fi
