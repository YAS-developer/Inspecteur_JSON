# COMMANDES #

JAVAC = javac
JAVAC_OPTIONS =  -Xlint:deprecation -encoding UTF-8 -d build -classpath build -sourcepath "src:tmp" -implicit:none

JAVA = java
JAR = jar
EXEC_JAR = ${JAVA} -jar

# CHEMINS RELATIFS #

SRC = src/json
BUILD = build/json
DOC = doc/json

JAR_JSON = Inspecteur.jar

run : ${JAR_JSON}
	

doc :
	javadoc -d doc -noqualifier all src/json/model/*.java src/json/view/*.java src/json/controler/*.java

clean :
	rm -rf ${BUILD}/* *.jar



# REGLES DE DEPENDANCE #z

## model ##


# ${BUILD}/model/JNoeud.class : ${SRC}/model/JNoeud.java \
# 								${SRC}/view/VuePrincipale.java
# 	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/model/JNoeud.java ${SRC}/view/*.java


# ${BUILD}/model/JObject.class : ${SRC}/model/JObject.java \
# 								${BUILD}/model/JNoeud.class \
# 								${SRC}/view/VuePrincipale.java
# 	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/model/JObject.java	${SRC}/view/*.java

# ${BUILD}/model/JKey.class : ${SRC}/model/JKey.java \
# 								${BUILD}/model/JNoeud.class \
# 								${BUILD}/model/JTab.class \
# 								${BUILD}/model/JObject.class
# 	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/model/JKey.java

# ${BUILD}/model/JTab.class : ${SRC}/model/JTab.java \
# 								${BUILD}/model/JNoeud.class
# 	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/model/JTab.java

# ${BUILD}/model/JOther.class : ${SRC}/model/JOther.java \
# 								${BUILD}/model/JNoeud.class
# 	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/model/JOther.java

# ${BUILD}/model/VBool.class : ${SRC}/model/VBool.java \
# 								${BUILD}/model/JNoeud.class
# 	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/model/VBool.java

# ${BUILD}/model/VNumber.class : ${SRC}/model/VNumber.java \
# 								${BUILD}/model/JNoeud.class
# 	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/model/VNumber.java

# ${BUILD}/model/VString.class : ${SRC}/model/VString.java \
# 								${BUILD}/model/JNoeud.class
# 	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/model/VString.java


# ${BUILD}/model/ArbreT.class : ${SRC}/model/ArbreT.java \
# 							  ${BUILD}/model/JObject.class 
# 	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/model/ArbreT.java

# ${BUILD}/model/%.class : ${SRC}/model/JNoeud.javaa \
# 						${SRC}/model/JObject.java \
# 						${SRC}/model/JKey.java\
# 						${SRC}/model/JTab.java \
# 						${SRC}/model/JOther.java \
# 						${SRC}/model/VBool.java \
# 						${SRC}/model/VNumber.java \
# 						${SRC}/model/VString.java \
# 						${SRC}/model/ArbreT.java 
# 	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/model/*.java ${SRC}/view/*.java

# VIEW #

# ${BUILD}/view/%.class : ${SRC}/view/Frame.java \
# 						${SRC}/view/BeauBouton.java \
# 						${SRC}/view/VueHaut.java \
# 						${SRC}/view/VuePrincipale.java \
# 						${SRC}/view/LabelModel.java \
# 						${SRC}/view/PanelModele.java \
# 						${SRC}/view/VueBas.java 
# 	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/view/*.java




# CONTROLER #

# ${BUILD}/controler/%.class : ${SRC}/controler/EventFrame.java \
# 							 ${SRC}/controler/ReplyEvent.java \
# 							 ${BUILD}/view/Frame.class	
# 		${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/controler/*.java 


all : ${SRC}/model/JNoeud.java \
		${SRC}/model/JObject.java \
		${SRC}/model/JKey.java \
		${SRC}/model/JTab.java \
		${SRC}/model/JOther.java \
		${SRC}/model/VBool.java \
		${SRC}/model/VNumber.java \
		${SRC}/model/VString.java \
		${SRC}/model/ArbreT.java \
			${SRC}/view/Frame.java \
			${SRC}/view/BeauBouton.java \
			${SRC}/view/VueHaut.java \
			${SRC}/view/VuePrincipale.java \
			${SRC}/view/LabelModel.java \
			${SRC}/view/PanelModel.java \
			${SRC}/view/VueBas.java \
				${SRC}/controler/EventFrame.java \
				${SRC}/controler/ReplyEvent.java 
	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/model/*.java ${SRC}/view/*.java ${SRC}/controler/*.java 				




${BUILD}/main/Main.class : all \
						   ${SRC}/main/Main.java 
	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/main/Main.java 	


${JAR_JSON} : ${BUILD}/main/Main.class
	${JAR} cvfe ${JAR_JSON} json.main.Main -C build json




# ${BUILD}/model/JObject.class \
#  							${BUILD}/model/JKey.class \
#  							${BUILD}/model/JTab.class \
#  							${BUILD}/model/JOther.class \
#  							${BUILD}/model/VBool.class \
#  							${BUILD}/model/VNumber.class \
#  							${BUILD}/model/VString.class \
#  							${BUILD}/model/ArbreT.class \
# 									${BUILD}/view/Frame.class \
# 									${BUILD}/view/VueBas.class \
# 									${BUILD}/view/VuePrincipale.class \
# 									${BUILD}/view/LabelModel.class \
# 									${BUILD}/view/PanelModele.class \
# 										${BUILD}/controler/EventFrame.class \
# 										${BUILD}/controler/ReplyEvent.class 	







	





